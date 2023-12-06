package edu.hw5;

import java.util.regex.Pattern;

public final class Task6 {
    private Task6() {
    }

    public static boolean isStringContainsSubsequence(String string, String subsequence) {
        if (string == null || subsequence == null) {
            return false;
        }
        String regex = createRegex(subsequence);
        return Pattern.matches(regex, string);
    }

    private static String createRegex(String subsequence) {
        char[] subsequenceArray = subsequence.toCharArray();
        StringBuilder stringBuilder = new StringBuilder().append("^");
        for (char c : subsequenceArray) {
            stringBuilder.append(".*")
                .append("(")
                .append(Pattern.quote(String.valueOf(c)))
                .append(")");
        }
        stringBuilder.append(".*")
            .append("$");
        return stringBuilder.toString();
    }
}

