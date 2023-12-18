package edu.hw1;

public final class Task7 {
    private Task7() {
    }

    public static int rotateRight(int number, int shift) {
        if (isNegativeNumber(number)) {
            return -1;
        }

        if (isShiftNegative(shift)) {
            return rotateLeft(number, -shift);
        }

        int countDigitInBinary = countDigitInBinaryNumber(number);
        int bitMask = (int) (Math.pow(2, countDigitInBinary) - 1);
        int remainsShift = (shift % countDigitInBinary);
        int modifiedNumber = (number >> remainsShift) | (number << (countDigitInBinary - remainsShift));

        return modifiedNumber & bitMask;
    }

    public static int rotateLeft(int number, int shift) {
        if (isNegativeNumber(number)) {
            return -1;
        }

        if (isShiftNegative(shift)) {
            return rotateRight(number, -shift);
        }

        int countDigitInBinary = countDigitInBinaryNumber(number);

        return rotateRight(number, countDigitInBinary - shift);
    }

    private static int countDigitInBinaryNumber(int number) {
        if (number != 0) {
            int powerOfTwo = (int) Math.floor(Math.log(Math.abs(number)) / Math.log(2));
            return powerOfTwo + 1;
        } else {
            return 1;
        }
    }

    private static boolean isNegativeNumber(int number) {
        return number < 0;
    }

    private static boolean isShiftNegative(int shift) {
        return shift < 0;
    }
}
