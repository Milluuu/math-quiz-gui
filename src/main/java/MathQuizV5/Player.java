/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MathQuizV5;

/**
 *
 * @author Milu
 */
public class Player {
    private String username;
    private String password;
    private int score;
    
    public Player(String username, String password, int score) {
        this.username = username;
        this.password = password;
        this.score = score;
    }
    
    public void setScore(int score) {
        this.score = score;
    }
    
    public int getScore() {
        return score;
    }
    
    public void updateScore(int addPoints) {
        this.score += addPoints;
        DbManager.updateScore(this.username, this.score);
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getUsername() {
        return username;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getPassword() {
        return password;
    }
}

