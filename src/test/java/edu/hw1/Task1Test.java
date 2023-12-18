package edu.hw1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

public class Task1Test {
    private static final int ERROR_CODE = -1;

    @ParameterizedTest
    @CsvSource(value = {
        "01:00, 60",
        "13:56, 836",
        "3:59, 239",
        "123:10, 7390",
        "0:0, 0",
        "0:21, 21"
    })
    @DisplayName("Inputs minutes and seconds")
    public void minutesAndSeconds(String timestamp, int expected) {
        Assertions.assertEquals(expected, Task1.minutesToSeconds(timestamp));
    }

    @ParameterizedTest
    @CsvSource(value = {
        "-01:00",
        "13:-56",
        "-3:-59"
    })
    @DisplayName("Inputs negative minutes or seconds")
    public void negativeValues(String timestamp) {
        Assertions.assertEquals(ERROR_CODE, Task1.minutesToSeconds(timestamp));
    }

    @ParameterizedTest
    @CsvSource(value = {
        "01:90",
        "13:1500"
    })
    @DisplayName("Inputs incorrect minutes or seconds")
    public void incorrectValues(String timestamp) {
        Assertions.assertEquals(ERROR_CODE, Task1.minutesToSeconds(timestamp));
    }

    @ParameterizedTest
    @CsvSource(value = {
        "0sd1:90",
        "131500",
        "01:9:0",
        "1dsa3:1500",
        "dogfood",
        "13:sdlj"
    })
    @DisplayName("Inputs incorrect string")
    public void incorrectString(String timestamp) {
        Assertions.assertEquals(ERROR_CODE, Task1.minutesToSeconds(timestamp));
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("Inputs empty and null string")
    public void nullString(String timestamp) {
        Assertions.assertEquals(ERROR_CODE, Task1.minutesToSeconds(timestamp));
    }

    @ParameterizedTest
    @CsvSource(value = {
        "18:00 , 1080",
        "  1315:00 , 78900"
    })
    @DisplayName("Inputs string with whitespace")
    public void stringWithWhitespace(String timestamp, int expected) {
        Assertions.assertEquals(expected, Task1.minutesToSeconds(timestamp));
    }
}
