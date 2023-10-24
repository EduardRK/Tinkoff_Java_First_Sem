package edu.hw3;

import java.util.ArrayList;

public class Validator {
    private Validator() {
    }

    public static boolean isStringEmpty(String string) {
        return (string == null) || string.isEmpty();
    }

    public static boolean isArrayEmpty(Object[] array) {
        return (array.length == 0);
    }

    public static boolean isArrayEmpty(ArrayList<String> array) {
        return array.isEmpty();
    }

    public static boolean isArrayNull(Object[] array) {
        return (array == null);
    }

    public static boolean isArrayNull(ArrayList<String> array) {
        return array == null;
    }

    public static boolean isPositiveNumber(int number) {
        return (number > 0);
    }

}
