package edu.hw1;

import java.util.Arrays;

public final class Task6 {
    private Task6() {
    }

    private static final int KAPREKAR_CONSTANT = 6174;
    private static final int BASE_DECIMAL_SYSTEM = 10;
    private static final int MIN_FOUR_DIGIT_NUMBER = 1000;
    private static final int MAX_FOUR_DIGIT_NUMBER = 9999;
    private static final int MIN_THREE_DIGIT_NUMBER = 100;
    private static final int MAX_THREE_DIGIT_NUMBER = 999;
    private static final int LAST_INDEX_OF_ARRAY_FOUR_DIGIT_NUMBER = 3;

    private static boolean isCorrectFourDigitNumber(int number) {
        return (number > MIN_FOUR_DIGIT_NUMBER) && (number <= MAX_FOUR_DIGIT_NUMBER);
    }

    private static boolean isThreeDigitNumber(int number) {
        return (number >= MIN_THREE_DIGIT_NUMBER) && (number <= MAX_THREE_DIGIT_NUMBER);
    }

    private static boolean digitsAreSame(int[] number) {
        int countSameDigit = 0;
        int sameDigit = number[0];
        for (int i : number) {
            if (i != sameDigit) {
                return false;
            }
        }
        return true;
    }

    public static int countK(int number) {
        if (!isCorrectFourDigitNumber(number)) {
            return -1;
        }

        if (number == KAPREKAR_CONSTANT) {
            return 0;
        }

        int[] arrayDigits;
        arrayDigits = Utility.splitIntoNumbers(number);

        if (digitsAreSame(arrayDigits)) {
            return -1;
        }

        int arrayDigitsLength = arrayDigits.length;
        Arrays.sort(arrayDigits);
        int modifiedNumber = 0;
        for (int i = 0, j = MIN_FOUR_DIGIT_NUMBER; i < arrayDigitsLength; ++i, j /= BASE_DECIMAL_SYSTEM) {
            modifiedNumber += (arrayDigits[LAST_INDEX_OF_ARRAY_FOUR_DIGIT_NUMBER - i] - arrayDigits[i]) * j;
        }
        if (isThreeDigitNumber(modifiedNumber)) {
            modifiedNumber *= BASE_DECIMAL_SYSTEM;
        }
        return 1 + countK(modifiedNumber);
    }
}
