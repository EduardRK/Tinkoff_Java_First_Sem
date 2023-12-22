package edu.hw5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;

public class Task7Test {
    @ParameterizedTest
    @CsvSource(value = {
        "110",
        "1101111111",
        "000000000"
    })
    @DisplayName("String contains at least three characters and third zero (valid)")
    public void isContainsAtLeastThreeCharactersAndThirdZeroValid(String string) {
        Assertions.assertTrue(Task7.isContainsAtLeastThreeCharactersAndThirdZero(string));
    }

    @ParameterizedTest
    @CsvSource(value = {
        "111",
        "1",
        "00",
        "11111111111111111",
        "001000000000",
        "1476385923"
    })
    @EmptySource
    @DisplayName("String contains at least three characters and third zero (invalid)")
    public void isContainsAtLeastThreeCharactersAndThirdZeroInvalid(String string) {
        Assertions.assertFalse(Task7.isContainsAtLeastThreeCharactersAndThirdZero(string));
    }

    @ParameterizedTest
    @CsvSource(value = {
        "00",
        "1",
        "0",
        "11",
        "01010101010000101001010101010"
    })
    @EmptySource
    @DisplayName("String starts and ends with same character (valid)")
    public void isStartsAndEndsWithSameCharacterValid(String string) {
        Assertions.assertTrue(Task7.isStartsAndEndsWithSameCharacter(string));
    }

    @ParameterizedTest
    @CsvSource(value = {
        "10",
        "001010100101011",
        "00101010101011",
        "000000000000000000000000000001",
        "425762351234072354"
    })
    @DisplayName("String starts and ends with same character (invalid)")
    public void isStartsAndEndsWithSameCharacterInvalid(String string) {
        Assertions.assertFalse(Task7.isStartsAndEndsWithSameCharacter(string));
    }

    @ParameterizedTest
    @CsvSource(value = {
        "1",
        "10",
        "01",
        "111",
        "101",
        "011"
    })
    @DisplayName("String contains at least one and no more three characters (valid)")
    public void isContainsAtLeastOneAndNoMoreThreeCharactersValid(String string) {
        Assertions.assertTrue(Task7.isContainsAtLeastOneAndNoMoreThreeCharacters(string));
    }

    @ParameterizedTest
    @CsvSource(value = {
        "1111",
        "010100010",
        "1010100001010",
        "278521423"
    })
    @EmptySource
    @DisplayName("String contains at least one and no more three characters (invalid)")
    public void isContainsAtLeastOneAndNoMoreThreeCharactersInvalid(String string) {
        Assertions.assertFalse(Task7.isContainsAtLeastOneAndNoMoreThreeCharacters(string));
    }
}
