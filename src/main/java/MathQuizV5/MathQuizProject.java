/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package MathQuizV5;

import com.formdev.flatlaf.FlatDarkLaf;
import java.awt.Color;
import javax.swing.UIManager;

/**
 *
 * @author Milu
 */
public class MathQuizProject {

    public static void main(String[] args) {
        try {
            // Set FlatLaf as the look and feel
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (Exception ex) {
            System.err.println("Failed to initialize FlatLaf");
        }
        
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