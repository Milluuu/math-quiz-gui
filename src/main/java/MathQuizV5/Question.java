/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MathQuizV5;

import java.util.Random;

/**
 *
 * @author Milu
 */
public class Question {
    
    public String questionText;
    public double correctAnswer;
    
    public Question(String questionText, double correctAnswer) 
    {
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
    }
    
    public String getQuestionText() 
    {
        return questionText;
    }
    
    
    public void setQuestionText(String questionText)
    {
        this.questionText = questionText;
    }
    
    public double getCorrectAnswer() 
    {
        return correctAnswer;
    }
    
    public void setCorrectAnswer(double correctAnswer) 
    {
        this.correctAnswer = correctAnswer;
    }
    
    
    
            
}
