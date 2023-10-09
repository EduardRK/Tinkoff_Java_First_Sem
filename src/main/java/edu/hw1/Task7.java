package edu.hw1;

public final class Task7 {
    private Task7() {
    }

    private static boolean isPositiveNumber(int number) {
        return number > 0;
    }

    private static boolean isShiftNegative(int shift) {
        return shift < 0;
    }

    public static int rotateRight(int number, int shift) {
        if (!isPositiveNumber(number)) {
            return -1;
        }
        if (isShiftNegative(shift)) {
            return rotateLeft(number, -shift);
        }
        int countDigitInBinary = Utility.countDigitInBinaryNumber(number);
        int bitMask = (int) (Math.pow(2, countDigitInBinary) - 1);
        int remainsShift = (shift % countDigitInBinary);
        int modifiedNumber = (number >> remainsShift) | (number << (countDigitInBinary - remainsShift));
        return modifiedNumber & bitMask;
    }

    public static int rotateLeft(int number, int shift) {
        if (!isPositiveNumber(number)) {
            return -1;
        }
        if (isShiftNegative(shift)) {
            return rotateRight(number, -shift);
        }
        int countDigitInBinary = Utility.countDigitInBinaryNumber(number);
        int bitMask = (int) (Math.pow(2, countDigitInBinary) - 1);
        int remainsShift = (shift % countDigitInBinary);
        int modifiedNumber = (number << remainsShift) | (number >> (countDigitInBinary - remainsShift));
        return modifiedNumber & bitMask;
    }
}
