package edu.hw1;

import java.util.Arrays;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public final class Task6 {
    private static final int KAPREKAR_CONSTANT = 6174;
    private static final int BASE_DECIMAL_SYSTEM = 10;
    private static final int MIN_FOUR_DIGIT_NUMBER = 1000;
    private static final int MAX_FOUR_DIGIT_NUMBER = 9999;
    private static final int MIN_THREE_DIGIT_NUMBER = 100;
    private static final int MAX_THREE_DIGIT_NUMBER = 999;
    private static final int LAST_INDEX_OF_ARRAY_FOUR_DIGIT_NUMBER = 3;

    private Task6() {
    }

    public static int countK(int number) {
        if (number == KAPREKAR_CONSTANT) {
            return 0;
        }

        if (!isCorrectFourDigitNumber(number)) {
            return -1;
        }

        int[] arrayDigits;
        arrayDigits = splitIntoNumbers(number);

        if (digitsAreSame(arrayDigits)) {
            return -1;
        }

        Arrays.sort(arrayDigits);
        int modifiedNumber = 0;

        for (int i = 0, j = MIN_FOUR_DIGIT_NUMBER; i < arrayDigits.length; ++i, j /= BASE_DECIMAL_SYSTEM) {
            modifiedNumber += (arrayDigits[LAST_INDEX_OF_ARRAY_FOUR_DIGIT_NUMBER - i] - arrayDigits[i]) * j;
        }

        if (isThreeDigitNumber(modifiedNumber)) {
            modifiedNumber *= BASE_DECIMAL_SYSTEM;
        }

        return 1 + countK(modifiedNumber);
    }

    private static boolean isCorrectFourDigitNumber(int number) {
        return (number > MIN_FOUR_DIGIT_NUMBER) && (number <= MAX_FOUR_DIGIT_NUMBER);
    }

    private static boolean isThreeDigitNumber(int number) {
        return (number >= MIN_THREE_DIGIT_NUMBER) && (number <= MAX_THREE_DIGIT_NUMBER);
    }

    @Contract(pure = true)
    private static boolean digitsAreSame(int @NotNull [] number) {
        int sameDigit = number[0];
        for (int i : number) {
            if (i != sameDigit) {
                return false;
            }
        }
        return true;
    }

    private static int @NotNull [] splitIntoNumbers(int number) {
        int[] arrayDigit = new int[countDigits(number)];
        int tempNumber = number;

        for (int i = 0; tempNumber > 0; tempNumber /= BASE_DECIMAL_SYSTEM, ++i) {
            arrayDigit[i] = tempNumber % BASE_DECIMAL_SYSTEM;
        }

        int temp;
        for (int i = 0; i < arrayDigit.length / 2; i++) {
            temp = arrayDigit[i];
            arrayDigit[i] = arrayDigit[arrayDigit.length - i - 1];
            arrayDigit[arrayDigit.length - i - 1] = temp;
        }

        return arrayDigit;
    }

    private static int countDigits(int number) {
        return number != 0 ? (int) Math.floor(Math.log10(Math.abs(number))) + 1 : 1;
    }
}
