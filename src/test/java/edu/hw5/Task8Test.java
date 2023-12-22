package edu.hw5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;

public class Task8Test {
    @ParameterizedTest
    @CsvSource(value = {
        "01010110101010111",
        "1",
        "101",
        "110110111011110110101110101"
    })
    @DisplayName("String odd length (valid)")
    public void stringOddLengthValid(String string) {
        Assertions.assertTrue(Task8.isOddLength(string));
    }

    @ParameterizedTest
    @CsvSource(value = {
        "0101011010101011",
        "10",
        "1101101110111101101011101011",
        "1213213123"
    })
    @EmptySource
    @DisplayName("String odd length (invalid)")
    public void stringOddLengthInvalid(String string) {
        Assertions.assertFalse(Task8.isOddLength(string));
    }

    @ParameterizedTest
    @CsvSource(value = {
        "0101111111111",
        "101010111110",
        "01011",
        "0",
        "10"
    })
    @DisplayName("String starts from 0 and odd length or starts from 1 and even length (valid)")
    public void isStartsFrom0AndOddLengthOrStartsFrom1AndEvenLengthValid(String string) {
        Assertions.assertTrue(Task8.isStartsFrom0AndOddLengthOrStartsFrom1AndEvenLength(string));
    }

    @ParameterizedTest
    @CsvSource(value = {
        "0101011110101011",
        "01",
        "11011101110111101101011101011",
        "1213213123"
    })
    @EmptySource
    @DisplayName("String starts from 0 and odd length or starts from 1 and even length (invalid)")
    public void isStartsFrom0AndOddLengthOrStartsFrom1AndEvenLengthInvalid(String string) {
        Assertions.assertFalse(Task8.isStartsFrom0AndOddLengthOrStartsFrom1AndEvenLength(string));
    }

    @ParameterizedTest
    @CsvSource(value = {
        "000",
        "11111111111111111111111110001111111111111111111111",
        "1011111101111110011111110111110",
        "00000111111111110",
        "101010101010101010101010101010",
    })
    @EmptySource
    @DisplayName("String count 0 multiple of 3 (valid)")
    public void isCount0MultipleOf3Valid(String string) {
        Assertions.assertTrue(Task8.isCount0MultipleOf3(string));
    }

    @ParameterizedTest
    @CsvSource(value = {
        "010",
        "1111111111111011111111111100011111111111101111111111",
        "101111110111111001111111011111",
        "00",
        "0",
        "123712313019274129030"
    })
    @DisplayName("String count 0 multiple of 3 (invalid)")
    public void isCount0MultipleOf3Invalid(String string) {
        Assertions.assertFalse(Task8.isCount0MultipleOf3(string));
    }

    @ParameterizedTest
    @CsvSource(value = {
        "1",
        "0",
        "110",
        "101",
        "1110",
        "1111",
        "10111111"
    })
    @EmptySource
    @DisplayName("String not 11 or 111 (valid)")
    public void isNot11Or111Valid(String string) {
        Assertions.assertTrue(Task8.isNot11Or111(string));
    }

    @ParameterizedTest
    @CsvSource(value = {
        "11",
        "111",
        "819236812831283"
    })
    @DisplayName("String not 11 or 111 (invalid)")
    public void isNot11Or111Invalid(String string) {
        Assertions.assertFalse(Task8.isNot11Or111(string));
    }

    @ParameterizedTest
    @CsvSource(value = {
        "1",
        "101010101",
        "101111111",
        "111111111111",
        "1010"
    })
    @DisplayName("String every odd symbol 1 (valid)")
    public void isEveryOddSymbol1Valid(String string) {
        Assertions.assertTrue(Task8.isEveryOddSymbol1(string));
    }

    @ParameterizedTest
    @CsvSource(value = {
        "0101",
        "101000000",
        "1010101010101000",
        "100",
        "1212674126"
    })
    @EmptySource
    @DisplayName("String every odd symbol 1 (invalid)")
    public void isEveryOddSymbol1Invalid(String string) {
        Assertions.assertFalse(Task8.isEveryOddSymbol1(string));
    }

    @ParameterizedTest
    @CsvSource(value = {
        "100",
        "00",
        "001",
        "010",
        "100000000000000000000000",
        "00000000000000000000000100",
        "00000000000000000000000000000000000000"
    })
    @DisplayName("String contains at least two 0 and no more one 1 (valid)")
    public void isContainsAtLeastTwo0AndNoMoreOne1Valid(String string) {
        Assertions.assertTrue(Task8.isContainsAtLeastTwo0AndNoMoreOne1(string));
    }

    @ParameterizedTest
    @CsvSource(value = {
        "1",
        "01",
        "100001000000000000000000",
        "11111111111111111111111",
        "18396214"
    })
    @EmptySource
    @DisplayName("String contains at least two 0 and no more one 1 (invalid)")
    public void isContainsAtLeastTwo0AndNoMoreOne1Invalid(String string) {
        Assertions.assertFalse(Task8.isContainsAtLeastTwo0AndNoMoreOne1(string));
    }

    @ParameterizedTest
    @CsvSource(value = {
        "1",
        "01",
        "10",
        "101",
        "0000000000000000000",
        "1010101010101010"
    })
    @EmptySource
    @DisplayName("String no consecutive 1 (valid)")
    public void isNoConsecutive1Valid(String string) {
        Assertions.assertTrue(Task8.isNoConsecutive1(string));
    }

    @ParameterizedTest
    @CsvSource(value = {
        "11",
        "10000011",
        "1111111",
        "01010110101010101",
        "27386521234"
    })
    @DisplayName("String no consecutive 1 (invalid)")
    public void isNoConsecutive1Invalid(String string) {
        Assertions.assertFalse(Task8.isNoConsecutive1(string));
    }
}
