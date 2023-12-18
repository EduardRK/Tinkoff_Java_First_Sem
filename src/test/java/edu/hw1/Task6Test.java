package edu.hw1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class Task6Test {
    private static final int ERROR_CODE = -1;

    @ParameterizedTest
    @CsvSource(value = {
        "6174, 0",
        "3524, 3",
        "6621, 5",
        "6554, 4",
        "1234, 3",
        "2221, 5",
    })
    @DisplayName("Four digit numbers")
    public void fourDigitNumber(int number, int expected) {
        Assertions.assertEquals(expected, Task6.countK(number));
    }

    @ParameterizedTest
    @CsvSource(value = {
        "132",
        "0",
        "1247123",
        "1111",
        "9999"
    })
    @DisplayName("Wrong numbers")
    public void nonFourDigitNumber(int number) {
        Assertions.assertEquals(ERROR_CODE, Task6.countK(number));
    }

    @ParameterizedTest
    @CsvSource(value = {
        "-1234",
        "-12",
        "-6174"
    })
    @DisplayName("Negative numbers")
    public void negativeNumber(int number) {
        Assertions.assertEquals(ERROR_CODE, Task6.countK(number));
    }
}
