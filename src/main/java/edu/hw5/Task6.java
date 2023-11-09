package edu.hw5;

import java.util.regex.Pattern;

public class Task6 {
    private Task6() {
    }

    public static boolean isStringContainsSubstring(String string, String substring) {
        String regex = "^.*(" + Pattern.quote(substring) + ")+.*$";
        return Pattern.matches(regex, string);
    }
}
