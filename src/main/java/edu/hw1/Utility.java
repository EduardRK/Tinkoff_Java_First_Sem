package edu.hw1;

public final class Utility {
    private static final int BASE_DECIMAL_SYSTEM = 10;

    private Utility() {
    }

    public static int countDigits(int number) {
        if (number != 0) {
            return (int) Math.floor(Math.log10(Math.abs(number))) + 1;
        } else {
            return 1;
        }
    }

    public static int countDigitInBinaryNumber(int number) {
        if (number != 0) {
            int powerOfTwo = (int) Math.floor(Math.log(Math.abs(number)) / Math.log(2));
            return powerOfTwo + 1;
        } else {
            return 1;
        }
    }

    public static void swap(char[] array, int firstIndex, int secondIndex) {
        char temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
    }

    public static int max(int[] array) {
        int max = array[0];
        for (int a : array) {
            max = Math.max(a, max);
        }
        return max;
    }

    public static int min(int[] array) {
        int min = array[0];
        for (int a : array) {
            min = Math.min(a, min);
        }
        return min;
    }

    public static boolean isNumberPalindrome(int number) {
        int reverseNumber = 0;
        int tempNumber = number;
        int lastDigit;

        for (; tempNumber > 0; tempNumber /= BASE_DECIMAL_SYSTEM) {
            lastDigit = tempNumber % BASE_DECIMAL_SYSTEM;
            reverseNumber = reverseNumber * BASE_DECIMAL_SYSTEM + lastDigit;
        }

        return number == reverseNumber;
    }

    public static int[] splitIntoNumbers(int number) {
        int[] arrayDigit = new int[countDigits(number)];
        int tempNumber = number;
        for (int i = 0; tempNumber > 0; tempNumber /= BASE_DECIMAL_SYSTEM, ++i) {
            arrayDigit[i] = tempNumber % BASE_DECIMAL_SYSTEM;
        }
        int arrayDigitLength = arrayDigit.length;
        int temp;
        for (int i = 0; i < arrayDigitLength / 2; i++) {
            temp = arrayDigit[i];
            arrayDigit[i] = arrayDigit[arrayDigitLength - i - 1];
            arrayDigit[arrayDigitLength - i - 1] = temp;
        }
        return arrayDigit;
    }
}
