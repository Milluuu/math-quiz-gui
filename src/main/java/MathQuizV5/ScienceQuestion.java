/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MathQuizV5;

/**
 *
 * @author adida
 */
public class ScienceQuestion extends Question{ 
    public ScienceQuestion() { 
        super("", 0); 
        generateSpeedQuestion();
    } 

    private synchronized void generateSpeedQuestion(){ //Remove synchronized if needed
        int distance = generateNumber(60); 
        int time = generateNumber(5); 
        double speed = distance / time;  

        this.questionText = "<html>Assume you are monitoring your running performance while preparing for a<br>" 
                + "marathon. You made the decision to run a certain route in order to gauge your speed <br>" 
                + "on a given training day. In " + time + ", you covered a distance of " + distance + " kilom" 
                + "eters on foot.</html>"; 
        this.correctAnswer = speed; 
    } 
    
    private int generateNumber(int range) { 
        return (int) (Math.random() * range); 
    } 
} 
