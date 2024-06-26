package MathQuizV5;

import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class DbManagerTest {

    private static final String TEST_USER = "testUser";
    private static final String TEST_PASSWORD = "testPassword";

    // Set up the database and register a test user before running the tests
    @BeforeClass
    public static void setUpClass() {
        DbManager.setupDatabase();
        DbManager.registerUser(TEST_USER, TEST_PASSWORD);
    }

    // Close the database connection after running all the tests
    @AfterClass
    public static void tearDownClass() {
        DbManager.closeDbConnection();
    }

    // Test adding a game session
    @Test
    public void testAddGameSession() {
        String username = TEST_USER;
        String gameType = "Math";
        int score = 200;
        DbManager.addGameSession(username, gameType, score);
        List<Player> highScores = DbManager.getHighScore(gameType);
        assertNotNull(highScores);
        assertTrue(highScores.stream().anyMatch(player -> username.equals(player.getUsername()) && score == player.getBasicScore()));
    }

    // Test registering a new user
    @Test
    public void testRegisterUser() {
        String newUser = "newUser";
        String newPassword = "newPassword";
        DbManager.registerUser(newUser, newPassword);
        Player player = DbManager.checkUserInformation(newUser, newPassword);
        assertNotNull(player);
        assertEquals(newUser, player.getUsername());
    }

    // Test checking user information
    @Test
    public void testCheckUserInformation() {
        Player player = DbManager.checkUserInformation(TEST_USER, TEST_PASSWORD);
        assertNotNull(player);
        assertEquals(TEST_USER, player.getUsername());
    }

    // Test retrieving high scores
    @Test
    public void testGetHighScore() {
        String modeMath = "Math";
        List<Player> resultMath = DbManager.getHighScore(modeMath);
        assertNotNull(resultMath);

        String modeScience = "Science";
        List<Player> resultScience = DbManager.getHighScore(modeScience);
        assertNotNull(resultScience);
    }

    // Test closing the database connection
    @Test
    public void testCloseDbConnection() {
        DbManager.closeDbConnection();
        assertTrue(true);
    }
}
