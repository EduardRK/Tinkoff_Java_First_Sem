package edu.hw1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Task4Test {

    @Test
    @DisplayName("Not null string")
    void notNullString() {
        String actual = Task4.fixString("QWERTY");
        String expected = "WQREYT";
        Assertions.assertEquals(expected, actual);

        actual = Task4.fixString("09");
        expected = "90";
        Assertions.assertEquals(expected, actual);

        actual = Task4.fixString("1");
        expected = "1";
        Assertions.assertEquals(expected, actual);

        actual = Task4.fixString("hTsii  s aimex dpus rtni.g");
        expected = "This is a mixed up string.";
        Assertions.assertEquals(expected, actual);

        actual = Task4.fixString("123456");
        expected = "214365";
        Assertions.assertEquals(expected, actual);

        actual = Task4.fixString("badce");
        expected = "abcde";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Null string")
    void nullString() {
        String actual = Task4.fixString(null);
        Assertions.assertNull(actual);

        actual = Task4.fixString("");
        String expected = "";
        Assertions.assertEquals(expected, actual);
    }
}
