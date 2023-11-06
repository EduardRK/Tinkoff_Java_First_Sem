package edu.hw3;

import java.util.List;

public class Validator {
    private Validator() {
    }

    public static boolean isStringNull(String string) {
        return (string == null);
    }

    public static boolean isArrayEmpty(Object[] array) {
        return (array.length == 0);
    }

    public static boolean isArrayNull(Object[] array) {
        return (array == null);
    }

    public static boolean isListNull(List<String> array) {
        return (array == null);
    }

    public static boolean isPositiveNumber(int number) {
        return (number > 0);
    }

}
