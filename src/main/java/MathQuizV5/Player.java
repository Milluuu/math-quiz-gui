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
    private int basicScore;
    private int scienceScore;
    
    public Player(String username, String password, int score) {
        this.username = username;
        this.password = password;
        this.basicScore = score;
    }
    
    public void setBasicScore(int basicScore) {
        this.basicScore = basicScore;
    }
    
    public int getBasicScore() {
        return basicScore;
    }
    
    public void setScienceScore(int scienceScore){
        this.scienceScore = scienceScore;
    }
    
    public int getScienceScore(){
        return scienceScore;
    }
    
    public void updateBasicScore(int addPoints) {
        this.basicScore += addPoints;
        DbManager.addGameSession(this.username, "Math", this.basicScore);    }
    
    public void updateScienceScore(int addPoints){
        this.scienceScore += addPoints;
        DbManager.addGameSession(this.username, "Science", this.scienceScore);
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

