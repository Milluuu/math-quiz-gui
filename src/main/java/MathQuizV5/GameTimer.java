/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MathQuizV5;

import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author adida
 */

public class GameTimer {
    private Timer timer;
    private int remainingTime;
    private final Runnable onTimeUp;

    public GameTimer(int durationInSeconds, Runnable onTimeUp) {
        this.remainingTime = durationInSeconds;
        this.onTimeUp = onTimeUp;
        this.timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                remainingTime--;
                if (remainingTime <= 0) {
                    timer.stop();
                    onTimeUp.run();
                }
            }
        });
    }

    public void start() {
        if (!timer.isRunning()) {
            timer.start();
            System.out.println("Timer started with " + remainingTime + " seconds remaining.");
        }
    }

    public void stop() {
        if (timer.isRunning()) {
            timer.stop();
            System.out.println("Timer stopped with " + remainingTime + " seconds remaining.");
        }
    }

    public int getRemainingTime() {
        return remainingTime;
    }

    public boolean isRunning() {
        return timer.isRunning();
    }

    // Reset the timer to a specific duration
    public void reset(int durationInSeconds) {
        stop();
        this.remainingTime = durationInSeconds;
    }
}
