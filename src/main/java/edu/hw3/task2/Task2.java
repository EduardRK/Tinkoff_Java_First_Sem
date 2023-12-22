package edu.hw3.task2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public final class Task2 {
    private Task2() {
    }

    public static @NotNull List<String> clusterize(String stringOfBrackets) {
        if (stringOfBrackets == null || stringOfBrackets.isEmpty()) {
            return Collections.singletonList(stringOfBrackets);
        }

        if (!isCorrectString(stringOfBrackets)) {
            throw new IllegalArgumentException();
        }

        char[] stringOfBracketsArray = stringOfBrackets.toCharArray();
        int openBrackets = 0;

        StringBuilder buildCluster = new StringBuilder();
        List<String> arrayOfClusters = new ArrayList<>();

        for (char bracket : stringOfBracketsArray) {
            if (bracket == '(') {
                buildCluster.append(bracket);
                openBrackets++;
            } else {
                if (openBrackets == 0) {
                    throw new IllegalArgumentException();
                } else {
                    buildCluster.append(bracket);
                    openBrackets--;
                }
            }

            if (openBrackets == 0) {
                arrayOfClusters.add(buildCluster.toString());
                buildCluster = new StringBuilder();
            }
        }

        return arrayOfClusters;
    }

    @Contract(pure = true)
    private static boolean isCorrectString(@NotNull String string) {
        char[] elementsString = string.toCharArray();

        for (var element : elementsString) {
            if (element != ')' && element != '(') {
                return false;
            }
        }

        return true;
    }
}
