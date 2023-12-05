package edu.hw5;

import java.util.regex.Pattern;

public final class Task4 {
    private static final String REGEX = ".*[~!@#$%^&*|].*";

    private Task4() {
    }

    public static boolean isValidPassword(String password) {
        return Pattern.matches(REGEX, password);
    }
}
