package edu.hw5;

import java.util.regex.Pattern;

public class Task7 {
    private Task7() {
    }

    public static boolean isContainsAtLeastThreeCharactersAndThirdZero(String string) {
        String regex = "[01]{2}0[01]*";
        return Pattern.matches(regex, string);
    }

    public static boolean isStartsAndEndsWithSameCharacter(String string) {
        String regex = "^[01]$|^0.*0$|^1.*1$";
        return Pattern.matches(regex, string);
    }

    public static boolean isContainsAtLeastOneAndNoMoreThreeCharacters(String string) {
        String regex = "[01]{1,3}";
        return Pattern.matches(regex, string);
    }
}
