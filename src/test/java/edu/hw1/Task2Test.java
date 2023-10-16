package edu.hw1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Task2Test {

    @Test
    @DisplayName("Positive number")
    void positiveNumber()
    {
        int actual = Task2.countDigits(564);
        int expected = 3;
        Assertions.assertEquals(expected, actual);

        actual = Task2.countDigits(3587214);
        expected = 7;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Zero")
    void zero()
    {
        int actual = Task2.countDigits(0);
        int expected = 1;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Negative number")
    void negativeNumber()
    {
        int actual = Task2.countDigits(-89);
        int expected = 2;
        Assertions.assertEquals(expected, actual);

        actual = Task2.countDigits(-9999999);
        expected = 7;
        Assertions.assertEquals(expected, actual);
    }
}
