package edu.hw5;

import java.util.regex.Pattern;

public class Task8 {
    private Task8() {
    }

    public static boolean isOddLength(String string) {
        String regex = "^([01]{2})*[01]$";
        return Pattern.matches(regex, string);
    }

    public static boolean isStartsFrom0AndOddLengthOrStartsFrom1AndEvenLength(String string) {
        String regex = "^(0([01]{2})*)$|^(1[01]([01]{2})*)$";
        return Pattern.matches(regex, string);
    }

    public static boolean isCount0MultipleOf3(String string) {
        String regex = "^((1*(01*){2}0)*1*)*$";
        return Pattern.matches(regex, string);
    }

    public static boolean isEveryOddSymbol1(String string) {
        String regex = "^(1(|[01])){1,}$";
        return Pattern.matches(regex, string);
    }

    public static boolean isNoConsecutive1(String string) {
        String regex = "^(1?(?!1)|0)*$";
        return Pattern.matches(regex, string);
    }

    public static boolean isContainsAtLeastTwo0AndNoMoreOne1(String string) {
        String regex = "^(1?0{2,})$|^(0{2,}1?0*)$|^(01?0+)$";
        return Pattern.matches(regex, string);
    }

    public static boolean isNot11Or111(String string) {
        String regex = "(^0[01]*?$)|(^(1?)$|^(10[01]*?)$|^(110[01]*?)$|^(111[01]+?)$)";
        return Pattern.matches(regex, string);
    }
}
