package edu.hw1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Task5Test {

    @Test
    @DisplayName("Even length")
    void evenLength() {
        int number = 11211230;
        Assertions.assertTrue(Task5.isPalindromeDescendant(number));

        number = 13001120;
        Assertions.assertTrue(Task5.isPalindromeDescendant(number));

        number = 23336014;
        Assertions.assertTrue(Task5.isPalindromeDescendant(number));

        number = 11;
        Assertions.assertTrue(Task5.isPalindromeDescendant(number));

        number = 275368;
        Assertions.assertFalse(Task5.isPalindromeDescendant(number));

        number = 666666;
        Assertions.assertTrue(Task5.isPalindromeDescendant(number));

        number = 5675;
        Assertions.assertFalse(Task5.isPalindromeDescendant(number));
    }

    @Test
    @DisplayName("Odd length")
    void oddLength() {
        int number = 19123;
        Assertions.assertFalse(Task5.isPalindromeDescendant(number));

        number = 17223;
        Assertions.assertTrue(Task5.isPalindromeDescendant(number));

        number = 18239;
        Assertions.assertTrue(Task5.isPalindromeDescendant(number));

        number = 113;
        Assertions.assertFalse(Task5.isPalindromeDescendant(number));

        number = 12321;
        Assertions.assertTrue(Task5.isPalindromeDescendant(number));

        number = 9918901;
        Assertions.assertFalse(Task5.isPalindromeDescendant(number));

        number = 1;
        Assertions.assertTrue(Task5.isPalindromeDescendant(number));
    }

    @Test
    @DisplayName("Negative number")
    void negativeNumber() {
        int number = -111;
        Assertions.assertFalse(Task5.isPalindromeDescendant(number));

        number = -1;
        Assertions.assertFalse(Task5.isPalindromeDescendant(number));
    }
}
