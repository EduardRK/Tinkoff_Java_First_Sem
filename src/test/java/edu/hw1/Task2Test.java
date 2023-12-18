package edu.hw1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class Task2Test {
    @ParameterizedTest
    @CsvSource(value = {
        "564, 3",
        "3587214, 7"
    })
    @DisplayName("Positive number")
    public void positiveNumber(int number, int expected) {
        Assertions.assertEquals(expected, Task2.countDigits(number));
    }

    @ParameterizedTest
    @CsvSource(value = "0, 1")
    @DisplayName("Zero")
    public void zero(int number, int expected) {
        Assertions.assertEquals(expected, Task2.countDigits(number));
    }

    @ParameterizedTest
    @CsvSource(value = {
        "-89, 2",
        "-9999999, 7"
    })
    @DisplayName("Negative number")
    public void negativeNumber(int number, int expected) {
        Assertions.assertEquals(expected, Task2.countDigits(number));
    }
}
