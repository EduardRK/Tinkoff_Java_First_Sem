package edu.hw1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Task6Test {

    @Test
    @DisplayName("Four digit number")
    void fourDigitNumber() {
        int actual = Task6.countK(6174);
        int expected = 0;
        Assertions.assertEquals(expected, actual);

        actual = Task6.countK(3524);
        expected = 3;
        Assertions.assertEquals(expected, actual);

        actual = Task6.countK(6621);
        expected = 5;
        Assertions.assertEquals(expected, actual);

        actual = Task6.countK(6554);
        expected = 4;
        Assertions.assertEquals(expected, actual);

        actual = Task6.countK(1234);
        expected = 3;
        Assertions.assertEquals(expected, actual);

        actual = Task6.countK(2222);
        expected = -1;
        Assertions.assertEquals(expected, actual);

        actual = Task6.countK(2221);
        expected = 5;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Not four digit number")
    void nonFourDigitNumber() {
        int actual = Task6.countK(132);
        int expected = -1;
        Assertions.assertEquals(expected, actual);

        actual = Task6.countK(0);
        expected = -1;
        Assertions.assertEquals(expected, actual);

        actual = Task6.countK(1245156);
        expected = -1;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Negative number")
    void negativeNumber() {
        int actual = Task6.countK(-1224);
        int expected = -1;
        Assertions.assertEquals(expected, actual);

        actual = Task6.countK(-9912);
        expected = -1;
        Assertions.assertEquals(expected, actual);

        actual = Task6.countK(-6174);
        expected = -1;
        Assertions.assertEquals(expected, actual);
    }
}
