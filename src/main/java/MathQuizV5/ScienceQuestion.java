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
        randomiseQuestion();
    } 
    
    private void randomiseQuestion(){
        switch(generateNumber(2)){
            case 0:
                generateSpeedQuestion();
                break;
            case 1:
                generateNmolesQuestion();
                break;
            default:
                System.out.println("Invalid operation!");
                break;
        }
    }

    private void generateSpeedQuestion(){ //Remove synchronized if needed
        //s = d / deltaTime
        int distance = generateNumber(60) + 1; 
        int time = generateNumber(5) + 1; 
        double speed = distance / time;  

        this.questionText = "<html>Assume you are monitoring your running performance while preparing for a<br>" 
                + "marathon. You made the decision to run a certain route in order to gauge your speed <br>" 
                + "on a given training day. In " + time + ", you covered a distance of " + distance + " kilom" 
                + "eters on foot.</html>"; 
        this.correctAnswer = speed; 
    } 
    
    private void generateNmolesQuestion(){
        //n = c * v
        double concentration = generateNumber(1) / 10.0;
        int volume = generateNumber(10) + 1;
        double nMoles = concentration * volume;
        
        this.questionText = "Calculate the number of moles of solute present in " + volume + " mL of a " + concentration + " M NaCl solution.";
        this.correctAnswer = nMoles;
    }
    
    private int generateNumber(int range) { 
        return (int) (Math.random() * range); 
    } 
} 
