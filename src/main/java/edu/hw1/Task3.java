package edu.hw1;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public final class Task3 {
    private Task3() {
    }

    public static boolean isNestable(int[] firstArray, int[] secondArray) {
        if (firstArray == null || secondArray == null) {
            return false;
        }

        if (secondArray.length == 0) {
            return false;
        }
        if (firstArray.length == 0) {
            return true;
        }

        return (min(firstArray) > min(secondArray))
            && (max(firstArray) < max(secondArray));

    }

    @Contract(pure = true)
    private static int max(int @NotNull [] array) {
        int max = array[0];
        for (int a : array) {
            max = Math.max(a, max);
        }
        return max;
    }

    @Contract(pure = true)
    private static int min(int @NotNull [] array) {
        int min = array[0];
        for (int a : array) {
            min = Math.min(a, min);
        }
        return min;
    }
}
