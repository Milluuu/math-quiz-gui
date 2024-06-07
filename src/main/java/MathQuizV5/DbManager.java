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
import java.util.ArrayList;
import java.util.List;

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
    
    //updates the users score uso
    public static void updateBasicScore(String username, int score){
        try {
            Statement statement = conn.createStatement();
            String updateQuery = "UPDATE UserInfo SET score = " + score + " WHERE username = '" + username + "'";
            statement.executeUpdate(updateQuery);
            statement.close();
            System.out.println("Score has been updated");
        } catch (SQLException e) {
            System.out.println("There has been an error updating the score: " + e.getMessage());
        }
    }
    
    public static void updateScienceScore(String username, int score){
        try {
            Statement statement = conn.createStatement();
            String updateQuery = "UPDATE UserInfo SET score = " + score + " WHERE username = '" + username + "'";
            statement.executeUpdate(updateQuery);
            statement.close();
            System.out.println("Score has been updated");
        } catch (SQLException e) {
            System.out.println("There has been an error updating the score: " + e.getMessage());
        }
    }   
    
    public static void addGameSession(String username, String gameType, int score) {
        try {
            Statement statement = conn.createStatement();

            // Check if the user already has a session for the given game type
            String checkQuery = "SELECT * FROM GameSessions WHERE username = '" + username + "' AND gameType = '" + gameType + "'";
            ResultSet resultSet = statement.executeQuery(checkQuery);

            if (resultSet.next()) {
                // Update the existing session
                String updateQuery = "UPDATE GameSessions SET score = " + score + " WHERE username = '" + username + "' AND gameType = '" + gameType + "'";
                statement.executeUpdate(updateQuery);
            } else {
                // Insert a new session
                String insertQuery = "INSERT INTO GameSessions (username, gameType, score) VALUES ('" + username + "', '" + gameType + "', " + score + ")";
                statement.executeUpdate(insertQuery);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            System.out.println("Error adding game session: " + e.getMessage());
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
    
    public static Player checkUserInformation(String username, String password) {
        Player player = null;
        try {
            Statement statement = conn.createStatement();
            String query = "SELECT * FROM UserInfo WHERE username = '" + username + "' AND password = '" + password + "'"; 
            ResultSet result = statement.executeQuery(query);
            if (result.next()) {
                String user = result.getString("username");
                String pass = result.getString("password");
                int score = result.getInt("score");
                player = new Player(user, pass, score);
            }
            result.close();
            statement.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return player;
    }
    
    //this returves the players username and score and displays it into the table depending on what mode
    public static List<Player> getHighScore(String mode) {
        List<Player> highScores = new ArrayList<>();
        String query;

        if ("Math".equalsIgnoreCase(mode)) {
            query = "SELECT username, MAX(score) AS score FROM GameSessions WHERE gameType = 'Math' GROUP BY username ORDER BY score DESC";
        } else if ("Science".equalsIgnoreCase(mode)) {
            query = "SELECT username, MAX(score) AS score FROM GameSessions WHERE gameType = 'Science' GROUP BY username ORDER BY score DESC";
        } else {
            throw new IllegalArgumentException("Invalid mode: " + mode);
        }

        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String username = resultSet.getString("username");
                int score = resultSet.getInt("score");
                highScores.add(new Player(username, "", score));
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            System.out.println("Error getting high score: " + e.getMessage());
        }
        return highScores;
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
