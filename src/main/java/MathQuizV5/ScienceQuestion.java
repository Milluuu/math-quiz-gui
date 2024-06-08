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
        switch(generateNumber(3)){
            case 0:
                generateNmolesQuestion();
                break;
            case 1:
                generateForceQuestion();
                break;
            case 2:
                generateMolarMassQuestion();
                break;
            default:
                System.out.println("Invalid operation!");
                break;
        }
    }
    
    private void generateMolarMassQuestion() { 
        // n = m / M
        int mass = generateNumber(100) + 1; // mass in grams
        int molarMass = generateNumber(200) + 1; // molar mass in grams per mole
        double moles = (double) mass / molarMass;  

        this.questionText = "<html>You are working in a chemistry lab and need to calculate the number of moles of a substance.<br>"
                + "You have a sample with a mass of " + mass + " grams and the molar mass of the substance is " 
                + molarMass + " grams per mole.<br>"
                + "Calculate the number of moles in the sample.</html>"; 
        this.correctAnswer = moles; 
    }
    
    private void generateForceQuestion(){ 
        // F = m * a
        int mass = generateNumber(100) + 1; 
        int acceleration = generateNumber(20) + 1; 
        double force = mass * acceleration;  

        this.questionText = "<html>In a physics experiment, you are analyzing the motion of objects under various forces.<br>"
                + "You have an object with a mass of " + mass + " kilograms that is experiencing an acceleration of " 
                + acceleration + " meters per second squared.<br>"
                + "Calculate the force acting on this object.</html>"; 
        this.correctAnswer = force; 
    }
    
    private void generateNmolesQuestion(){
        //n = c * v
        double concentration = generateNumber(1) / 10.0;
        int volume = generateNumber(10) + 1;
        double nMoles = concentration * volume / 1000.0;
        
        this.questionText = "Calculate the number of moles of solute present in " + volume + " mL of a " + concentration + " M "
                + generateCompound() + " solution.";
        this.correctAnswer = nMoles;
    }
    
    private String generateCompound(){
        String compound = "";
        switch(generateNumber(4)){
            case 0:
                compound = "NaCl";
                break;
            case 1:
                compound = "KOH";
                break;
            case 2:
                compound = "CH3OH";
                break;
            case 3:
                compound = "CH4";
                break;
        }
        return compound;
    }
    
    
    
    private int generateNumber(int range) { 
        return (int) (Math.random() * range); 
    } 
} 
