/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package MathQuizV5;


/**
 *
 * @author Milu
 */
public class MathQuizProject {

    public static void main(String[] args) {
       
        DbManager manager = new DbManager();
        StartupScreen initialScreen = new StartupScreen();
        initialScreen.setVisible(true);    
        
        initialScreen.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                DbManager.closeDbConnection();
            }
        });
        
    }
}