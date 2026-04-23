package org.howard.edu.lsp.finalexam.question3;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class GradeCalculatorTest {

    private final GradeCalculator calc = new GradeCalculator();

    @Test
    void average_returnsCorrectMean() {
        assertEquals(80.0, calc.average(70, 80, 90), 0.0001);
    }

    @Test
    void letterGrade_returnsB() {
        assertEquals("B", calc.letterGrade(85.0));
    }

    @Test
    void isPassing_returnsTrue() {
        assertTrue(calc.isPassing(75.0));
    }

    @Test
    void letterGrade_boundaryAt90() {
        assertEquals("A", calc.letterGrade(90.0));
    }

    @Test
    void isPassing_boundaryAt60() {
        assertTrue(calc.isPassing(60.0));
    }

    @Test
    void average_throwsForNegativeScore() {
        assertThrows(IllegalArgumentException.class,
                () -> calc.average(-1, 50, 50));
    }

    @Test
    void average_throwsForScoreAboveHundred() {
        assertThrows(IllegalArgumentException.class,
                () -> calc.average(50, 101, 50));
    }
}