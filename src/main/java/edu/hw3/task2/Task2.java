package edu.hw3.task2;

import edu.hw3.Validator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Task2 {
    private Task2() {
    }

    public static List<String> clusterize(String stringOfBrackets)
        throws InvalidBracketsSequence {
        if (Validator.isStringNull(stringOfBrackets) || stringOfBrackets.isEmpty()) {
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
                    throw new InvalidBracketsSequence();
                } else {
                    buildCluster.append(bracket);
                    openBrackets--;
                }
            }
            if (openBrackets == 0) {
                arrayOfClusters.add(String.valueOf(buildCluster));
                buildCluster = new StringBuilder();
            }
        }
        return arrayOfClusters;
    }

    private static boolean isCorrectString(String string) {
        char[] elementsString = string.toCharArray();
        for (var element : elementsString) {
            if ((element != ')') && (element != '(')) {
                return false;
            }
        }
        return true;
    }
}