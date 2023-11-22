package edu.hw1;

public final class Task5 {
    private static final int BASE_DECIMAL_SYSTEM = 10;

    private Task5() {
    }

    private static int createDescendant(int number) {
        int[] digits = Utility.splitIntoNumbers(number);
        int digitsLength = digits.length;
        int sumDigits;
        int descendant = 0;
        for (int i = 1; i < digitsLength; i += 2) {
            sumDigits = digits[i - 1] + digits[i];
            descendant = (int) (descendant * Math.pow(BASE_DECIMAL_SYSTEM, Utility.countDigits(sumDigits)) + sumDigits);
        }
        if (digitsLength % 2 != 0) {
            descendant = descendant * BASE_DECIMAL_SYSTEM + digits[digitsLength - 1];
        }
        return descendant;
    }

    public static boolean isPalindromeDescendant(int number) {
        if (Utility.isNumberPalindrome(number)) {
            return true;
        }

        int descendant = createDescendant(number);
        int countDigitInDescendant = Utility.countDigits(descendant);
        while (countDigitInDescendant >= 2) {
            if (Utility.isNumberPalindrome(descendant)) {
                return true;
            }
            descendant = createDescendant(descendant);
            countDigitInDescendant = Utility.countDigits(descendant);
        }
        return false;
    }
}
