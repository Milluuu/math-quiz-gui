package MathQuizV5;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Milu
 */
public class GameTimerTest {

    private GameTimer instance;
    private boolean timerExpired;

    public GameTimerTest() {
    }

    // Setup class-level resources before any tests run
    @BeforeClass
    public static void setUpClass() {
    }

    // Clean up class-level resources after all tests run
    @AfterClass
    public static void tearDownClass() {
    }

    // Setup method, runs before each test
    @Before
    public void setUp() {
        timerExpired = false;
        instance = new GameTimer(10, () -> timerExpired = true);
    }

    // Tear down method, runs after each test
    @After
    public void tearDown() {
        instance.stop();
    }

    // Test the start method
    @Test
    public void testStart() {
        System.out.println("start");
        instance.start();
        assertTrue(instance.isRunning());
    }

    // Test the stop method
    @Test
    public void testStop() {
        System.out.println("stop");
        instance.start();
        instance.stop();
        assertFalse(instance.isRunning());
    }

    // Test the getRemainingTime method
    @Test
    public void testGetRemainingTime() throws InterruptedException {
        System.out.println("getRemainingTime");
        instance.start();
        Thread.sleep(2000); // Wait for 2 seconds
        int result = instance.getRemainingTime();
        System.out.println("Remaining time after 2 seconds: " + result);
        assertTrue(result <= 9 && result >= 5);
    }

    // Test the isRunning method
    @Test
    public void testIsRunning() {
        System.out.println("isRunning");
        instance.start();
        assertTrue(instance.isRunning());
        instance.stop();
        assertFalse(instance.isRunning());
    }

    // Test if the timer expires correctly
    @Test
    public void testTimerExpires() throws InterruptedException {
        System.out.println("testTimerExpires");
        instance.start();
        Thread.sleep(11000); // Wait for 11 seconds to ensure timer has expired
        assertTrue(timerExpired);
    }
}