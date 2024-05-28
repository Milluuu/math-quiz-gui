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
        switch(generateNumber(2)){ 
            case 0: 
                generateSpeedQuestion(); 
                break; 
            case 1: 
                generateMolarMassQuestion(); 
                break; 
            default: 
                System.out.println("Invalid input"); 
                break; 
        } 
    } 

    private void generateSpeedQuestion(){ 
        int distance = generateNumber(60); 
        int time = generateNumber(5); 
        double speed = distance / time;  

        this.questionText = "<html>Assume you are monitoring your running performance while preparing for a<br>" 
                + "marathon. You made the decision to run a certain route in order to gauge your speed <br>" 
                + "on a given training day. In " + time + ", you covered a distance of " + distance + " kilom" 
                + "eters on foot.</html>"; 
        this.correctAnswer = speed; 
    } 

    private void generateMolarMassQuestion(){ 
        int volume = generateNumber(10); 
        int concentration = generateNumber(10); 
        double molarMass = concentration / volume; 

        this.questionText = "<html>You are working on an experiment in a chemical lab to find the mass of a solute <br>" 
                + "required to produce a particular concentration of a solution. You are informed that the needed <br>" 
                + "volume (v) of the solution is " + volume + "liters (L), and that the concentration (c) of the solution should \n" 
                + "be "+ concentration + " grams per liter (g/L).<html>"; 
        this.correctAnswer = molarMass; 
    } 
    
    private int generateNumber(int range) { 
        return (int) (Math.random() * range); 
    } 
} 
