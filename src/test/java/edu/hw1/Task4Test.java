package edu.hw1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

public class Task4Test {

    @ParameterizedTest
    @CsvSource(value = {
        "QWERTY, WQREYT",
        "09, 90",
        "1, 1",
        "hTsii  s aimex dpus rtni.g, This is a mixed up string.",
        "123456, 214365",
        "badce, abcde"
    })
    @DisplayName("Test fix string")
    public void notNullString(String toFix, String expected) {
        Assertions.assertEquals(expected, Task4.fixString(toFix));
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("Empty string")
    public void nullString(String toFix) {
        Assertions.assertEquals(toFix, Task4.fixString(toFix));
    }
}
