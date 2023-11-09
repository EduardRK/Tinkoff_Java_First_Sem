package edu.hw5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Task7Test {
    @Test
    @DisplayName("String contains at least three characters and third zero (valid)")
    public void isContainsAtLeastThreeCharactersAndThirdZeroValid() {
        String actual = "110";
        Assertions.assertTrue(Task7.isContainsAtLeastThreeCharactersAndThirdZero(actual));

        actual = "1101111111";
        Assertions.assertTrue(Task7.isContainsAtLeastThreeCharactersAndThirdZero(actual));

        actual = "000000000";
        Assertions.assertTrue(Task7.isContainsAtLeastThreeCharactersAndThirdZero(actual));
    }

    @Test
    @DisplayName("String contains at least three characters and third zero (invalid)")
    public void isContainsAtLeastThreeCharactersAndThirdZeroInvalid() {
        String actual = "111";
        Assertions.assertFalse(Task7.isContainsAtLeastThreeCharactersAndThirdZero(actual));

        actual = "1";
        Assertions.assertFalse(Task7.isContainsAtLeastThreeCharactersAndThirdZero(actual));

        actual = "00";
        Assertions.assertFalse(Task7.isContainsAtLeastThreeCharactersAndThirdZero(actual));

        actual = "11111111111111111";
        Assertions.assertFalse(Task7.isContainsAtLeastThreeCharactersAndThirdZero(actual));

        actual = "001000000000";
        Assertions.assertFalse(Task7.isContainsAtLeastThreeCharactersAndThirdZero(actual));

        actual = "";
        Assertions.assertFalse(Task7.isContainsAtLeastThreeCharactersAndThirdZero(actual));

        actual = "1476385923";
        Assertions.assertFalse(Task7.isContainsAtLeastThreeCharactersAndThirdZero(actual));
    }

    @Test
    @DisplayName("String starts and ends with same character (valid)")
    public void isStartsAndEndsWithSameCharacterValid() {
        String actual = "00";
        Assertions.assertTrue(Task7.isStartsAndEndsWithSameCharacter(actual));

        actual = "1";
        Assertions.assertTrue(Task7.isStartsAndEndsWithSameCharacter(actual));

        actual = "0";
        Assertions.assertTrue(Task7.isStartsAndEndsWithSameCharacter(actual));

        actual = "11";
        Assertions.assertTrue(Task7.isStartsAndEndsWithSameCharacter(actual));

        actual = "01010101010000101001010101010";
        Assertions.assertTrue(Task7.isStartsAndEndsWithSameCharacter(actual));

        actual = "";
        Assertions.assertTrue(Task7.isStartsAndEndsWithSameCharacter(actual));
    }

    @Test
    @DisplayName("String starts and ends with same character (invalid)")
    public void isStartsAndEndsWithSameCharacterInvalid() {
        String actual = "10";
        Assertions.assertFalse(Task7.isStartsAndEndsWithSameCharacter(actual));

        actual = "10";
        Assertions.assertFalse(Task7.isStartsAndEndsWithSameCharacter(actual));

        actual = "001010100101011";
        Assertions.assertFalse(Task7.isStartsAndEndsWithSameCharacter(actual));

        actual = "00101010101011";
        Assertions.assertFalse(Task7.isStartsAndEndsWithSameCharacter(actual));

        actual = "000000000000000000000000000001";
        Assertions.assertFalse(Task7.isStartsAndEndsWithSameCharacter(actual));

        actual = "425762351234072354";
        Assertions.assertFalse(Task7.isStartsAndEndsWithSameCharacter(actual));
    }

    @Test
    @DisplayName("String contains at least one and no more three characters (valid)")
    public void isContainsAtLeastOneAndNoMoreThreeCharactersValid() {
        String actual = "1";
        Assertions.assertTrue(Task7.isContainsAtLeastOneAndNoMoreThreeCharacters(actual));

        actual = "10";
        Assertions.assertTrue(Task7.isContainsAtLeastOneAndNoMoreThreeCharacters(actual));

        actual = "01";
        Assertions.assertTrue(Task7.isContainsAtLeastOneAndNoMoreThreeCharacters(actual));

        actual = "111";
        Assertions.assertTrue(Task7.isContainsAtLeastOneAndNoMoreThreeCharacters(actual));

        actual = "101";
        Assertions.assertTrue(Task7.isContainsAtLeastOneAndNoMoreThreeCharacters(actual));

        actual = "011";
        Assertions.assertTrue(Task7.isContainsAtLeastOneAndNoMoreThreeCharacters(actual));
    }

    @Test
    @DisplayName("String contains at least one and no more three characters (invalid)")
    public void isContainsAtLeastOneAndNoMoreThreeCharactersInvalid() {
        String actual = "1111";
        Assertions.assertFalse(Task7.isContainsAtLeastOneAndNoMoreThreeCharacters(actual));

        actual = "010100010";
        Assertions.assertFalse(Task7.isContainsAtLeastOneAndNoMoreThreeCharacters(actual));

        actual = "";
        Assertions.assertFalse(Task7.isContainsAtLeastOneAndNoMoreThreeCharacters(actual));

        actual = "1010100001010";
        Assertions.assertFalse(Task7.isContainsAtLeastOneAndNoMoreThreeCharacters(actual));
    }
}
