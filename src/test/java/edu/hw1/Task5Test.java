package edu.hw1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class Task5Test {

    @ParameterizedTest
    @CsvSource(value = {
        "11211230",
        "13001120",
        "23336014",
        "11",
        "666666"
    })
    @DisplayName("Even length (true)")
    public void evenLengthTrue(int number) {
        Assertions.assertTrue(Task5.isPalindromeDescendant(number));
    }

    @ParameterizedTest
    @CsvSource(value = {
        "275368",
        "5675"
    })
    @DisplayName("Even length (false)")
    public void evenLengthFalse(int number) {
        Assertions.assertFalse(Task5.isPalindromeDescendant(number));
    }

    @ParameterizedTest
    @CsvSource(value = {
        "17223",
        "18239",
        "12321",
        "1"
    })
    @DisplayName("Odd length (True)")
    public void oddLengthTrue(int number) {
        Assertions.assertTrue(Task5.isPalindromeDescendant(number));
    }

    @ParameterizedTest
    @CsvSource(value = {
        "19123",
        "113",
        "9918901"
    })
    @DisplayName("Odd length (False)")
    public void oddLengthFalse(int number) {
        Assertions.assertFalse(Task5.isPalindromeDescendant(number));
    }

    @ParameterizedTest
    @CsvSource(value = {
        "-111",
        "-1"
    })
    @DisplayName("Negative number")
    public void negativeNumber(int number) {
        Assertions.assertFalse(Task5.isPalindromeDescendant(number));
    }
}
