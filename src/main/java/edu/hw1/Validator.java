package edu.hw1;

public final class Validator {
    private Validator() {
    }

    public static boolean isStringEmpty(String timestamp) {
        return (timestamp == null) || timestamp.isEmpty();
    }

    public static boolean isArrayEmpty(int[] array) {
        return array.length == 0;
    }

}
