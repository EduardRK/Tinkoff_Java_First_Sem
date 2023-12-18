package edu.hw1;

import org.jetbrains.annotations.NotNull;

public final class Task4 {
    private Task4() {
    }

    public static String fixString(String brokeStr) {
        if (brokeStr == null || brokeStr.isEmpty()) {
            return brokeStr;
        }

        char[] brokeStrArray = brokeStr.toCharArray();
        for (int i = 1; i < brokeStrArray.length; i += 2) {
            swap(brokeStrArray, i - 1, i);
        }

        return new String(brokeStrArray);
    }

    private static void swap(char @NotNull [] array, int firstIndex, int secondIndex) {
        char temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
    }
}
