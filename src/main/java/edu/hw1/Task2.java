package edu.hw1;

public final class Task2 {
    private Task2() {
    }

    public static int countDigits(int number) {
        return number != 0 ? (int) Math.floor(Math.log10(Math.abs(number))) + 1 : 1;
    }
}
