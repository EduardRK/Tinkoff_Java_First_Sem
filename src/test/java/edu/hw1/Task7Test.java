package edu.hw1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Task7Test {

    @Test
    @DisplayName("Positive shift")
    void positiveShift() {
        int actual = Task7.rotateRight(8, 1);
        int expected = 4;
        Assertions.assertEquals(expected, actual);

        actual = Task7.rotateLeft(16, 1);
        expected = 1;
        Assertions.assertEquals(expected, actual);

        actual = Task7.rotateLeft(17, 2);
        expected = 6;
        Assertions.assertEquals(expected, actual);

        actual = Task7.rotateLeft(17, 4);
        expected = 24;
        Assertions.assertEquals(expected, actual);

        actual = Task7.rotateLeft(34, 1);
        expected = 5;
        Assertions.assertEquals(expected, actual);

        actual = Task7.rotateRight(34, 1);
        expected = 17;
        Assertions.assertEquals(expected, actual);

        actual = Task7.rotateLeft(900, 4);
        expected = 78;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Negative shift")
    void negativeShift() {
        int actual = Task7.rotateRight(10, -9);
        int expected = 5;
        Assertions.assertEquals(expected, actual);

        actual = Task7.rotateLeft(17, -4);
        expected = 3;
        Assertions.assertEquals(expected, actual);

        actual = Task7.rotateLeft(12, -1);
        expected = 6;
        Assertions.assertEquals(expected, actual);

        actual = Task7.rotateRight(5, -9);
        expected = 5;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Zero")
    void zero() {
        int actual = Task7.rotateRight(0, 2);
        int expected = 0;
        Assertions.assertEquals(expected, actual);

        actual = Task7.rotateLeft(0, -1);
        expected = 0;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Negative number")
    void negativeNumber() {
        int actual = Task7.rotateRight(-10, -9);
        int expected = -1;
        Assertions.assertEquals(expected, actual);

        actual = Task7.rotateLeft(-12, 5);
        expected = -1;
        Assertions.assertEquals(expected, actual);
    }
}
