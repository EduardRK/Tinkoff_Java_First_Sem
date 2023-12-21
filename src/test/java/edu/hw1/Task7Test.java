package edu.hw1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class Task7Test {
    private static final int ERROR_CODE = -1;

    @ParameterizedTest
    @CsvSource(value = {
        "8, 1, 4",
        "34, 1, 17",
        "0, 3, 0"
    })
    @DisplayName("Positive shift (right)")
    public void positiveShiftRight(int number, int shift, int expected) {
        Assertions.assertEquals(expected, Task7.rotateRight(number, shift));
    }

    @ParameterizedTest
    @CsvSource(value = {
        "16, 1, 1",
        "17, 2, 6",
        "17, 4, 24",
        "34, 1, 5",
        "900, 4, 78"
    })
    @DisplayName("Positive shift (left)")
    public void positiveShiftLeft(int number, int shift, int expected) {
        Assertions.assertEquals(expected, Task7.rotateLeft(number, shift));
    }

    @ParameterizedTest
    @CsvSource(value = {
        "10, -9, 5",
        "5, -9, 5"
    })
    @DisplayName("Negative shift (right)")
    public void negativeShiftRight(int number, int shift, int expected) {
        Assertions.assertEquals(expected, Task7.rotateRight(number, shift));
    }

    @ParameterizedTest
    @CsvSource(value = {
        "17, -4, 3",
        "12, -1, 6",
        "0, -1, 0"
    })
    @DisplayName("Negative shift (left)")
    public void negativeShiftLeft(int number, int shift, int expected) {
        Assertions.assertEquals(expected, Task7.rotateLeft(number, shift));
    }

    @ParameterizedTest
    @CsvSource(value = {
        "-10, -9",
        "-12, 5"
    })
    @DisplayName("Negative number")
    public void negativeNumber(int number, int shift) {
        Assertions.assertEquals(ERROR_CODE, Task7.rotateRight(number, shift));
        Assertions.assertEquals(ERROR_CODE, Task7.rotateLeft(number, shift));
    }
}
