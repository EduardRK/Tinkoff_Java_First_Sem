package edu.hw1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Task1Test {

    @Test
    @DisplayName("Inputs minutes and seconds")
    void minutesAndSeconds() {
        int actual = Task1.minutesToSeconds("01:00");
        int expected = 60;
        Assertions.assertEquals(expected, actual);

        actual = Task1.minutesToSeconds("13:56");
        expected = 836;
        Assertions.assertEquals(expected, actual);

        actual = Task1.minutesToSeconds("3:59");
        expected = 239;
        Assertions.assertEquals(expected, actual);

        actual = Task1.minutesToSeconds("123:10");
        expected = 7390;
        Assertions.assertEquals(expected, actual);

        actual = Task1.minutesToSeconds("0:0");
        expected = 0;
        Assertions.assertEquals(expected, actual);

        actual = Task1.minutesToSeconds("0:21");
        expected = 21;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Inputs negative minutes or seconds")
    void negativeValues() {
        int actual = Task1.minutesToSeconds("-01:00");
        int expected = -1;
        Assertions.assertEquals(expected, actual);

        actual = Task1.minutesToSeconds("13:-56");
        expected = -1;
        Assertions.assertEquals(expected, actual);

        actual = Task1.minutesToSeconds("-3:-59");
        expected = -1;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Inputs incorrect minutes or seconds")
    void incorrectValues() {
        int actual = Task1.minutesToSeconds("01:90");
        int expected = -1;
        Assertions.assertEquals(expected, actual);

        actual = Task1.minutesToSeconds("13:1500");
        expected = -1;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Inputs incorrect string")
    void incorrectString() {
        int actual = Task1.minutesToSeconds("0sd1:90");
        int expected = -1;
        Assertions.assertEquals(expected, actual);

        actual = Task1.minutesToSeconds("131500");
        expected = -1;
        Assertions.assertEquals(expected, actual);

        actual = Task1.minutesToSeconds("01:9:0");
        expected = -1;
        Assertions.assertEquals(expected, actual);

        actual = Task1.minutesToSeconds("1dsa3:1500");
        expected = -1;
        Assertions.assertEquals(expected, actual);

        actual = Task1.minutesToSeconds("dogfood");
        expected = -1;
        Assertions.assertEquals(expected, actual);

        actual = Task1.minutesToSeconds("13:sdlj");
        expected = -1;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Inputs null string")
    void nullString() {
        int actual = Task1.minutesToSeconds("");
        int expected = -1;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Inputs string with whitespace")
    void stringWithWhitespace() {
        int actual = Task1.minutesToSeconds("18:00 ");
        int expected = -1;
        Assertions.assertEquals(expected, actual);

        actual = Task1.minutesToSeconds("  1315:00 ");
        expected = -1;
        Assertions.assertEquals(expected, actual);
    }
}
