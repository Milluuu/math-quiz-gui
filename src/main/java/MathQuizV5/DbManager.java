/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MathQuizV5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Milu
 */
public class DbManager {
    
    private Connection conn = null;
    private String url = "jdbc:derby:MathQuizDB;create=true";
    private String dbUsername = "kefe";
    private String dbPassword = "kefe";
    
    public DbManager() {
        try{
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC not found");
        }
        dbSetup();
     
      }    
    
   //Create the userinfo table to store username and pass 
   public void dbSetup() {
       try{
           conn = DriverManager.getConnection(url, dbUsername, dbPassword);
           Statement statement = conn.createStatement();
           String createTableQuery = "CREATE TABLE UserInfo (" +
            "username VARCHAR(50) PRIMARY KEY, " +
            "password VARCHAR(255), " +
            "score INT" +
            ")";
                   
            statement.executeUpdate(createTableQuery);       
       } catch (SQLException e) {
           System.out.println("Error" + e.getMessage());
       }
   }
   

}
