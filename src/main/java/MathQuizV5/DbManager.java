/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MathQuizV5;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;

/**
 *
 * @author Milu
 */
public class DbManager {

    private static String URL = "jdbc:derby:MathQuizDB";
    private static Connection conn = null;

    public DbManager() {
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            conn = DriverManager.getConnection(URL);
            System.out.println("Database connection successful");
//            dbSetup();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static boolean checkTableExisting(String tableName) {
        boolean tableExists = false;
        try {
            DatabaseMetaData dbmd = conn.getMetaData();
            ResultSet rs = dbmd.getTables(null, null, tableName, null);
            tableExists = rs.next();
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error checking if table exists: " + e.getMessage());
        }
        return tableExists;
    }

//    private static void dbSetup() {
//        try {
//            Statement statement = conn.createStatement();
//            String tableName = "UserInfo"; // Use consistent case
//            if (!checkTableExisting(tableName)) {
//                String createTableQuery = "CREATE TABLE " + tableName + " (" +
//                        "username VARCHAR(50) PRIMARY KEY, " +
//                        "password VARCHAR(255), " +
//                        "score INT DEFAULT 0" +
//                        ")";
//                statement.executeUpdate(createTableQuery);
//            }
//            statement.close();
//        } catch (SQLException e) {
//            System.out.println("Error: " + e.getMessage());
//        }
//    }

    public static void registerUser(String username, String password) {
        try {
            Statement statement = conn.createStatement();
            String insertQuery = "INSERT INTO UserInfo (username, password) VALUES ('" + username + "', '" + password + "')";
            statement.executeUpdate(insertQuery);
            statement.close();
            System.out.println("User registered successfully: " + username);
        } catch (SQLException e) {
            if (e instanceof SQLIntegrityConstraintViolationException) {
                System.out.println("Error: Username already exists.");
            } else {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
    
    public static boolean checkUserInformation(String username, String password) {
        try{
            Statement statement = conn.createStatement();
            String query = "SELECT * FROM UserInfo WHERE username = '" + username + "' AND password = '" + password + "'"; 
            ResultSet result = statement.executeQuery(query);
            boolean userExists = result.next();
            result.close();
            return userExists;
            } catch (SQLException e) {
                System.out.println("Error: " + e.getMessage());
                return false;
            }
    }

    public static void closeDbConnection() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
                System.out.println("Database connection closed");
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}