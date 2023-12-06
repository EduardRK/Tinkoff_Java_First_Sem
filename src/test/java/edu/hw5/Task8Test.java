package edu.hw5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Task8Test {
    @Test
    @DisplayName("String odd length (valid)")
    public void stringOddLengthValid() {
        String actual = "01010110101010111";
        Assertions.assertTrue(Task8.isOddLength(actual));

        actual = "1";
        Assertions.assertTrue(Task8.isOddLength(actual));

        actual = "101";
        Assertions.assertTrue(Task8.isOddLength(actual));

        actual = "110110111011110110101110101";
        Assertions.assertTrue(Task8.isOddLength(actual));
    }

    @Test
    @DisplayName("String odd length (invalid)")
    public void stringOddLengthInvalid() {
        String actual = "0101011010101011";
        Assertions.assertFalse(Task8.isOddLength(actual));

        actual = "";
        Assertions.assertFalse(Task8.isOddLength(actual));

        actual = "10";
        Assertions.assertFalse(Task8.isOddLength(actual));

        actual = "1101101110111101101011101011";
        Assertions.assertFalse(Task8.isOddLength(actual));

        actual = "1213213123";
        Assertions.assertFalse(Task8.isOddLength(actual));
    }

    @Test
    @DisplayName("String starts from 0 and odd length or starts from 1 and even length (valid)")
    public void isStartsFrom0AndOddLengthOrStartsFrom1AndEvenLengthValid() {
        String actual = "0101111111111";
        Assertions.assertTrue(Task8.isStartsFrom0AndOddLengthOrStartsFrom1AndEvenLength(actual));

        actual = "101010111110";
        Assertions.assertTrue(Task8.isStartsFrom0AndOddLengthOrStartsFrom1AndEvenLength(actual));

        actual = "01011";
        Assertions.assertTrue(Task8.isStartsFrom0AndOddLengthOrStartsFrom1AndEvenLength(actual));

        actual = "0";
        Assertions.assertTrue(Task8.isStartsFrom0AndOddLengthOrStartsFrom1AndEvenLength(actual));

        actual = "10";
        Assertions.assertTrue(Task8.isStartsFrom0AndOddLengthOrStartsFrom1AndEvenLength(actual));
    }

    @Test
    @DisplayName("String starts from 0 and odd length or starts from 1 and even length (invalid)")
    public void isStartsFrom0AndOddLengthOrStartsFrom1AndEvenLengthInvalid() {
        String actual = "0101011110101011";
        Assertions.assertFalse(Task8.isStartsFrom0AndOddLengthOrStartsFrom1AndEvenLength(actual));

        actual = "";
        Assertions.assertFalse(Task8.isStartsFrom0AndOddLengthOrStartsFrom1AndEvenLength(actual));

        actual = "01";
        Assertions.assertFalse(Task8.isStartsFrom0AndOddLengthOrStartsFrom1AndEvenLength(actual));

        actual = "11011101110111101101011101011";
        Assertions.assertFalse(Task8.isStartsFrom0AndOddLengthOrStartsFrom1AndEvenLength(actual));

        actual = "1213213123";
        Assertions.assertFalse(Task8.isStartsFrom0AndOddLengthOrStartsFrom1AndEvenLength(actual));
    }

    @Test
    @DisplayName("String count 0 multiple of 3 (valid)")
    public void isCount0MultipleOf3Valid() {
        String actual = "000";
        Assertions.assertTrue(Task8.isCount0MultipleOf3(actual));

        actual = "11111111111111111111111110001111111111111111111111";
        Assertions.assertTrue(Task8.isCount0MultipleOf3(actual));

        actual = "1011111101111110011111110111110";
        Assertions.assertTrue(Task8.isCount0MultipleOf3(actual));

        actual = "00000111111111110";
        Assertions.assertTrue(Task8.isCount0MultipleOf3(actual));

        actual = "101010101010101010101010101010";
        Assertions.assertTrue(Task8.isCount0MultipleOf3(actual));

        actual = "";
        Assertions.assertTrue(Task8.isCount0MultipleOf3(actual));
    }

    @Test
    @DisplayName("String count 0 multiple of 3 (invalid)")
    public void isCount0MultipleOf3Invalid() {
        String actual = "010";
        Assertions.assertFalse(Task8.isCount0MultipleOf3(actual));

        actual = "1111111111111011111111111100011111111111101111111111";
        Assertions.assertFalse(Task8.isCount0MultipleOf3(actual));

        actual = "101111110111111001111111011111";
        Assertions.assertFalse(Task8.isCount0MultipleOf3(actual));

        actual = "00";
        Assertions.assertFalse(Task8.isCount0MultipleOf3(actual));

        actual = "0";
        Assertions.assertFalse(Task8.isCount0MultipleOf3(actual));

        actual = "123712313019274129030";
        Assertions.assertFalse(Task8.isCount0MultipleOf3(actual));
    }

    @Test
    @DisplayName("String not 11 or 111 (valid)")
    public void isNot11Or111Valid() {
        String actual = "";
        Assertions.assertTrue(Task8.isNot11Or111(actual));

        actual = "1";
        Assertions.assertTrue(Task8.isNot11Or111(actual));

        actual = "0";
        Assertions.assertTrue(Task8.isNot11Or111(actual));

        actual = "110";
        Assertions.assertTrue(Task8.isNot11Or111(actual));

        actual = "101";
        Assertions.assertTrue(Task8.isNot11Or111(actual));

        actual = "1110";
        Assertions.assertTrue(Task8.isNot11Or111(actual));

        actual = "1111";
        Assertions.assertTrue(Task8.isNot11Or111(actual));

        actual = "10111111";
        Assertions.assertTrue(Task8.isNot11Or111(actual));
    }

    @Test
    @DisplayName("String not 11 or 111 (invalid)")
    public void isNot11Or111Invalid() {
        String actual = "11";
        Assertions.assertFalse(Task8.isNot11Or111(actual));

        actual = "111";
        Assertions.assertFalse(Task8.isNot11Or111(actual));

        actual = "819236812831283";
        Assertions.assertFalse(Task8.isNot11Or111(actual));
    }

    @Test
    @DisplayName("String every odd symbol 1 (valid)")
    public void isEveryOddSymbol1Valid() {
        String actual = "1";
        Assertions.assertTrue(Task8.isEveryOddSymbol1(actual));

        actual = "101010101";
        Assertions.assertTrue(Task8.isEveryOddSymbol1(actual));

        actual = "101111111";
        Assertions.assertTrue(Task8.isEveryOddSymbol1(actual));

        actual = "111111111111";
        Assertions.assertTrue(Task8.isEveryOddSymbol1(actual));

        actual = "1010";
        Assertions.assertTrue(Task8.isEveryOddSymbol1(actual));
    }

    @Test
    @DisplayName("String every odd symbol 1 (invalid)")
    public void isEveryOddSymbol1Invalid() {
        String actual = "";
        Assertions.assertFalse(Task8.isEveryOddSymbol1(actual));

        actual = "0101";
        Assertions.assertFalse(Task8.isEveryOddSymbol1(actual));

        actual = "101000000";
        Assertions.assertFalse(Task8.isEveryOddSymbol1(actual));

        actual = "1010101010101000";
        Assertions.assertFalse(Task8.isEveryOddSymbol1(actual));

        actual = "100";
        Assertions.assertFalse(Task8.isEveryOddSymbol1(actual));

        actual = "1212674126";
        Assertions.assertFalse(Task8.isEveryOddSymbol1(actual));
    }

    @Test
    @DisplayName("String contains at least two 0 and no more one 1 (valid)")
    public void isContainsAtLeastTwo0AndNoMoreOne1Valid() {
        String actual = "100";
        Assertions.assertTrue(Task8.isContainsAtLeastTwo0AndNoMoreOne1(actual));

        actual = "00";
        Assertions.assertTrue(Task8.isContainsAtLeastTwo0AndNoMoreOne1(actual));

        actual = "001";
        Assertions.assertTrue(Task8.isContainsAtLeastTwo0AndNoMoreOne1(actual));

        actual = "010";
        Assertions.assertTrue(Task8.isContainsAtLeastTwo0AndNoMoreOne1(actual));

        actual = "100000000000000000000000";
        Assertions.assertTrue(Task8.isContainsAtLeastTwo0AndNoMoreOne1(actual));

        actual = "00000000000000000000000100";
        Assertions.assertTrue(Task8.isContainsAtLeastTwo0AndNoMoreOne1(actual));

        actual = "00000000000000000000000000000000000000";
        Assertions.assertTrue(Task8.isContainsAtLeastTwo0AndNoMoreOne1(actual));
    }

    @Test
    @DisplayName("String contains at least two 0 and no more one 1 (invalid)")
    public void isContainsAtLeastTwo0AndNoMoreOne1Invalid() {
        String actual = "";
        Assertions.assertFalse(Task8.isContainsAtLeastTwo0AndNoMoreOne1(actual));

        actual = "1";
        Assertions.assertFalse(Task8.isContainsAtLeastTwo0AndNoMoreOne1(actual));

        actual = "01";
        Assertions.assertFalse(Task8.isContainsAtLeastTwo0AndNoMoreOne1(actual));

        actual = "100001000000000000000000";
        Assertions.assertFalse(Task8.isContainsAtLeastTwo0AndNoMoreOne1(actual));

        actual = "11111111111111111111111";
        Assertions.assertFalse(Task8.isContainsAtLeastTwo0AndNoMoreOne1(actual));
    }

    @Test
    @DisplayName("String no consecutive 1 (valid)")
    public void isNoConsecutive1Valid() {
        String actual = "";
        Assertions.assertTrue(Task8.isNoConsecutive1(actual));

        actual = "1";
        Assertions.assertTrue(Task8.isNoConsecutive1(actual));

        actual = "01";
        Assertions.assertTrue(Task8.isNoConsecutive1(actual));

        actual = "10";
        Assertions.assertTrue(Task8.isNoConsecutive1(actual));

        actual = "101";
        Assertions.assertTrue(Task8.isNoConsecutive1(actual));

        actual = "0000000000000000000";
        Assertions.assertTrue(Task8.isNoConsecutive1(actual));

        actual = "1010101010101010";
        Assertions.assertTrue(Task8.isNoConsecutive1(actual));
    }

    @Test
    @DisplayName("String no consecutive 1 (invalid)")
    public void isNoConsecutive1Invalid() {
        String actual = "11";
        Assertions.assertFalse(Task8.isNoConsecutive1(actual));

        actual = "10000011";
        Assertions.assertFalse(Task8.isNoConsecutive1(actual));

        actual = "1111111";
        Assertions.assertFalse(Task8.isNoConsecutive1(actual));

        actual = "01010110101010101";
        Assertions.assertFalse(Task8.isNoConsecutive1(actual));
    }
}
