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
public class ScienceQuestionTest {

    @Test
    public void testMolarMassQuestion() {
        ScienceQuestion question = new ScienceQuestion();
        if (question.getQuestionText().contains("molar mass")) {
            String questionText = question.getQuestionText();
            String[] parts = questionText.split("grams and the molar mass of the substance is ");
            int mass = Integer.parseInt(parts[0].replaceAll("\\D+",""));
            parts = parts[1].split(" grams per mole");
            int molarMass = Integer.parseInt(parts[0].replaceAll("\\D+",""));
            double expectedMoles = (double) mass / molarMass;
            assertEquals(expectedMoles, question.getCorrectAnswer(), 0.01);
        }
    }

    @Test
    public void testForceQuestion() {
        ScienceQuestion question = new ScienceQuestion();
        if (question.getQuestionText().contains("force")) {
            String questionText = question.getQuestionText();
            String[] parts = questionText.split("mass of ");
            int mass = Integer.parseInt(parts[1].split(" kilograms")[0].replaceAll("\\D+",""));
            int acceleration = Integer.parseInt(parts[1].split("acceleration of ")[1].split(" meters")[0].replaceAll("\\D+",""));
            double expectedForce = mass * acceleration;
            assertEquals(expectedForce, question.getCorrectAnswer(), 0.01);
        }
    }

    @Test
    public void testNmolesQuestion() {
        ScienceQuestion question = new ScienceQuestion();
        if (question.getQuestionText().contains("moles of solute")) {
            String questionText = question.getQuestionText();
            String[] parts = questionText.split("Calculate the number of moles of solute present in ");
            int volume = Integer.parseInt(parts[1].split(" mL")[0].replaceAll("\\D+",""));
            double concentration = Double.parseDouble(parts[1].split("of a ")[1].split(" M")[0]);
            double expectedNMoles = concentration * volume / 1000.0;
            assertEquals(expectedNMoles, question.getCorrectAnswer(), 0.01);
        }
    }

}
