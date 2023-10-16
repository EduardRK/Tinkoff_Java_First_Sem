package edu.hw1;

public final class Task2 {
    private Task2() {
    }

    public static int countDigits(int number) {
        if (number != 0) {
            return (int) Math.floor(Math.log10(Math.abs(number))) + 1;
        } else {
            return 1;
        }
    }
}
