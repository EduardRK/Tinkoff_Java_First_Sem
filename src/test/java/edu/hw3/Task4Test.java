package edu.hw3;

import edu.hw3.task4.InvalidArgumentException;
import edu.hw3.task4.Task4;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Task4Test {

    @Test
    @DisplayName("Example test")
    public void exampleTest() throws InvalidArgumentException {
        String actual = Task4.convertToRoman(2);
        String expected = "II";
        Assertions.assertEquals(expected, actual);

        actual = Task4.convertToRoman(12);
        expected = "XII";
        Assertions.assertEquals(expected, actual);

        actual = Task4.convertToRoman(16);
        expected = "XVI";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("More complex cases #1")
    public void moreComplexCases1() throws InvalidArgumentException {
        String actual = Task4.convertToRoman(341);
        String expected = "CCCXLI";
        Assertions.assertEquals(expected, actual);

        actual = Task4.convertToRoman(620);
        expected = "DCXX";
        Assertions.assertEquals(expected, actual);

        actual = Task4.convertToRoman(948);
        expected = "CMXLVIII";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("More complex cases #2")
    public void moreComplexCases2() throws InvalidArgumentException {
        String actual = Task4.convertToRoman(2389);
        String expected = "MMCCCLXXXIX";
        Assertions.assertEquals(expected, actual);

        actual = Task4.convertToRoman(2619);
        expected = "MMDCXIX";
        Assertions.assertEquals(expected, actual);

        actual = Task4.convertToRoman(3989);
        expected = "MMMCMLXXXIX";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Negative number")
    public void negativeNumber() {
        Assertions.assertThrows(InvalidArgumentException.class, () -> {
            String actual = Task4.convertToRoman(-19);
        });
    }

    @Test
    @DisplayName("Zero number")
    public void zeroNumber() {
        Assertions.assertThrows(InvalidArgumentException.class, () -> {
            String actual = Task4.convertToRoman(0);
        });
    }
}
