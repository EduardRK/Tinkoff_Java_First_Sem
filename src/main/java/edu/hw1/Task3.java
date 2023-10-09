package edu.hw1;

public final class Task3 {
    private Task3() {
    }

    public static boolean isNestable(int[] firstArray, int[] secondArray) {
        if (Validator.isArrayEmpty(secondArray)) {
            return false;
        }
        if (Validator.isArrayEmpty(firstArray)) {
            return true;
        } else {
            return (Utility.min(firstArray) > Utility.min(secondArray))
                && (Utility.max(firstArray) < Utility.max(secondArray));
        }

    }
}
