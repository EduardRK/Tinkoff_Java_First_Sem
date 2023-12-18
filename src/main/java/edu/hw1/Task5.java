package edu.hw1;

import org.jetbrains.annotations.NotNull;

public final class Task5 {
    private static final int BASE_DECIMAL_SYSTEM = 10;

    private Task5() {
    }

    public static boolean isPalindromeDescendant(int number) {
        if (isNumberPalindrome(number)) {
            return true;
        }

        int descendant = createDescendant(number);
        int countDigitInDescendant = countDigits(descendant);

        while (countDigitInDescendant >= 2) {
            if (isNumberPalindrome(descendant)) {
                return true;
            }

            descendant = createDescendant(descendant);
            countDigitInDescendant = countDigits(descendant);
        }

        return false;
    }

    private static int createDescendant(int number) {
        int[] digits = splitIntoNumbers(number);
        int sumDigits;
        int descendant = 0;

        for (int i = 1; i < digits.length; i += 2) {
            sumDigits = digits[i - 1] + digits[i];
            descendant = (int) (descendant * Math.pow(BASE_DECIMAL_SYSTEM, countDigits(sumDigits)) + sumDigits);
        }

        if (digits.length % 2 != 0) {
            descendant = descendant * BASE_DECIMAL_SYSTEM + digits[digits.length - 1];
        }

        return descendant;
    }

    private static int countDigits(int number) {
        return number != 0 ? (int) Math.floor(Math.log10(Math.abs(number))) + 1 : 1;
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

    private static boolean isNumberPalindrome(int number) {
        int reverseNumber = 0;
        int tempNumber = number;
        int lastDigit;

        for (; tempNumber > 0; tempNumber /= BASE_DECIMAL_SYSTEM) {
            lastDigit = tempNumber % BASE_DECIMAL_SYSTEM;
            reverseNumber = reverseNumber * BASE_DECIMAL_SYSTEM + lastDigit;
        }

        return number == reverseNumber;
    }
}
