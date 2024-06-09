/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package MathQuizV5;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author adida
 */
public class BasicQuestionTest {

    
    //Test case for verifying the correct answer for addition questions.
     
    @Test
    public void testBasicQuestionAddition() {
        BasicQuestion question = new BasicQuestion();
        if (question.getQuestionText().contains(" + ")) {
            String[] parts = question.getQuestionText().split(" \\+ ");
            int num1 = Integer.parseInt(parts[0].trim());
            int num2 = Integer.parseInt(parts[1].trim());
            assertEquals(num1 + num2, question.getCorrectAnswer(), 0.01);
        }
    }

    
    //Test case for verifying the correct answer for subtraction questions.
    
    @Test
    public void testBasicQuestionSubtraction() {
        BasicQuestion question = new BasicQuestion();
        if (question.getQuestionText().contains(" - ")) {
            String[] parts = question.getQuestionText().split(" - ");
            int num1 = Integer.parseInt(parts[0].trim());
            int num2 = Integer.parseInt(parts[1].trim());
            assertEquals(num1 - num2, question.getCorrectAnswer(), 0.01);
        }
    }

    
    //Test case for verifying the correct answer for multiplication questions.
    
    @Test
    public void testBasicQuestionMultiplication() {
        BasicQuestion question = new BasicQuestion();
        if (question.getQuestionText().contains(" * ")) {
            String[] parts = question.getQuestionText().split(" \\* ");
            int num1 = Integer.parseInt(parts[0].trim());
            int num2 = Integer.parseInt(parts[1].trim());
            assertEquals(num1 * num2, question.getCorrectAnswer(), 0.01);
        }
    }

    
    //Test case for verifying the correct answer for division questions.
   
    @Test
    public void testBasicQuestionDivision() {
        BasicQuestion question = new BasicQuestion();
        if (question.getQuestionText().contains(" / ")) {
            String[] parts = question.getQuestionText().split(" / ");
            int num1 = Integer.parseInt(parts[0].trim());
            int num2 = Integer.parseInt(parts[1].trim());
            assertEquals(1d * num1 / num2, question.getCorrectAnswer(), 0.01);
        }
    }
}
