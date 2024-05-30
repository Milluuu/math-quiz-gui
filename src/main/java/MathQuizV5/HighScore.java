/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MathQuizV5;

import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Milu
 */
public class HighScore extends DefaultTableModel {
    private static final String[] COLUMN_NAMES = {"Username", "Score"};

    public HighScore(List<Player> players) {
        super(COLUMN_NAMES, 0);
        for (Player player : players) {
            addRow(new Object[]{player.getUsername(), player.getScore()});
        }
    }

    //Added this so user cant edit the text in the table
    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }
}
