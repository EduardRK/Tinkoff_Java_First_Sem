package edu.hw5;

import java.util.regex.Pattern;

public final class Task7 {
    private static final String REGEX_CONTAINS_AT_LEAST_THREE_CHARACTERS_AND_THIRD_ZERO = "[01]{2}0[01]*";
    private static final String REGEX_STARTS_AND_ENDS_WITH_SAME_CHARACTER = "^[01]?$|^(0[01]*0)$|^(1[01]*1)$";
    private static final String REGEX_CONTAINS_AT_LEAST_ONE_AND_NO_MORE_THREE_CHARACTERS = "[01]{1,3}";

    private Task7() {
    }

    public static boolean isContainsAtLeastThreeCharactersAndThirdZero(String string) {
        return Pattern.matches(REGEX_CONTAINS_AT_LEAST_THREE_CHARACTERS_AND_THIRD_ZERO, string);
    }

    public static boolean isStartsAndEndsWithSameCharacter(String string) {
        return Pattern.matches(REGEX_STARTS_AND_ENDS_WITH_SAME_CHARACTER, string);
    }

    public static boolean isContainsAtLeastOneAndNoMoreThreeCharacters(String string) {
        return Pattern.matches(REGEX_CONTAINS_AT_LEAST_ONE_AND_NO_MORE_THREE_CHARACTERS, string);
    }
}
