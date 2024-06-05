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
    private final int DURATION = 10; // 10 seconds

    public GameTimer(Runnable onTimeUp) {
        this.remainingTime = DURATION;
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
        timer.start();
        System.out.println("Time started at " + remainingTime);
    }

    public void stop() {
        timer.stop();
        System.out.println("Time stopped at " + remainingTime);
    }

    public int getRemainingTime() {
        return remainingTime;
    }

    public boolean isRunning() {
        return timer.isRunning();
    }
}
