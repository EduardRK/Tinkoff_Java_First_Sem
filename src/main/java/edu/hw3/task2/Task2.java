package edu.hw3.task2;

import edu.hw3.Validator;
import java.util.ArrayList;

public class Task2 {
    private Task2() {
    }

    public static ArrayList<String> clusterize(String stringOfBrackets)
        throws InvalidArgumentException, InvalidBracketsSequence {
        if (Validator.isStringEmpty(stringOfBrackets)) {
            return new ArrayList<>() {{
                add(stringOfBrackets);
            }};
        }

        if (!isCorrectString(stringOfBrackets)) {
            throw new InvalidArgumentException();
        }

        char[] stringOfBracketsArray = stringOfBrackets.toCharArray();
        int openBrackets = 0;
        StringBuilder buildCluster = new StringBuilder();
        ArrayList<String> arrayOfClusters = new ArrayList<>();
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
