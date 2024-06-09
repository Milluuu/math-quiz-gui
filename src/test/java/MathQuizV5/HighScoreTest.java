/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package MathQuizV5;

import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author adida
 */
public class HighScoreTest {
    
    private Player player1;
    private Player player2;
    private HighScore highScore;

    @Before
    public void setUp() {
        player1 = new Player("Alice", "password1", 150);
        player2 = new Player("Bob", "password2", 200);
        List<Player> players = Arrays.asList(player1, player2);
        highScore = new HighScore(players);
    }

    @Test
    public void testColumnNames() {
        assertEquals("Username", highScore.getColumnName(0));
        assertEquals("Score", highScore.getColumnName(1));
    }

    @Test
    public void testRowCount() {
        assertEquals(2, highScore.getRowCount());
    }

    @Test
    public void testCellValues() {
        assertEquals("Alice", highScore.getValueAt(0, 0));
        assertEquals(150, highScore.getValueAt(0, 1));
        assertEquals("Bob", highScore.getValueAt(1, 0));
        assertEquals(200, highScore.getValueAt(1, 1));
    }

    @Test
    public void testIsCellEditable() {
        assertFalse(highScore.isCellEditable(0, 0));
        assertFalse(highScore.isCellEditable(0, 1));
        assertFalse(highScore.isCellEditable(1, 0));
        assertFalse(highScore.isCellEditable(1, 1));
    }
}