/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package MathQuizV5;

/**
 *
 * @author adida
 */
public interface PlayerInfo {
    void setUsername(String username);
    String getUsername();

    void setPassword(String password);
    String getPassword();

    void setBasicScore(int basicScore);
    int getBasicScore();

    void setScienceScore(int scienceScore);
    int getScienceScore();

    void updateBasicScore(int addPoints);
    void updateScienceScore(int addPoints);
}
