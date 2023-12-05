package edu.hw5;

import java.util.regex.Pattern;

public final class Task8 {
    private static final String REGEX_ODD_LENGTH = "^([01]{2})*[01]$";
    private static final String REGEX_STARTS_FROM_0_AND_ODD_LENGTH_OR_STARS_FROM_1_AND_EVEN_LENGTH =
        "^(0([01]{2})*)$|^(1[01]([01]{2})*)$";
    private static final String REGEX_COUNT_0_MULTIPLE_OF_3 = "^((1*(01*){2}0)*1*)*$";
    private static final String REGEX_EVERY_ODD_SYMBOL_1 = "^(1(|[01])){1,}$";
    private static final String REGEX_NO_CONSECUTIVE_1 = "^(1?(?!1)|0)*$";
    private static final String REGEX_CONTAINS_AT_LEAST_TWO_0_AND_NO_MORE_ONE_1 = "^(1?0{2,})$|^(0{2,}1?0*)$|^(01?0+)$";
    private static final String REGEX_NOT_11_OR_111 = "(^0[01]*?$)|(^(1?)$|^(10[01]*?)$|^(110[01]*?)$|^(111[01]+?)$)";

    private Task8() {
    }

    public static boolean isOddLength(String string) {
        return Pattern.matches(REGEX_ODD_LENGTH, string);
    }

    public static boolean isStartsFrom0AndOddLengthOrStartsFrom1AndEvenLength(String string) {
        return Pattern.matches(REGEX_STARTS_FROM_0_AND_ODD_LENGTH_OR_STARS_FROM_1_AND_EVEN_LENGTH, string);
    }

    public static boolean isCount0MultipleOf3(String string) {
        return Pattern.matches(REGEX_COUNT_0_MULTIPLE_OF_3, string);
    }

    public static boolean isEveryOddSymbol1(String string) {
        return Pattern.matches(REGEX_EVERY_ODD_SYMBOL_1, string);
    }

    public static boolean isNoConsecutive1(String string) {
        return Pattern.matches(REGEX_NO_CONSECUTIVE_1, string);
    }

    public static boolean isContainsAtLeastTwo0AndNoMoreOne1(String string) {
        return Pattern.matches(REGEX_CONTAINS_AT_LEAST_TWO_0_AND_NO_MORE_ONE_1, string);
    }

    public static boolean isNot11Or111(String string) {
        return Pattern.matches(REGEX_NOT_11_OR_111, string);
    }
}
