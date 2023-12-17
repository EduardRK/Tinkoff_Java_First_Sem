package edu.hw11.Task3;

public final class FibonacciCounterExample {
    private FibonacciCounterExample() {
    }

    public static long fib(int n) {
        if (n == 0) {
            return n;
        }

        int x = 1;
        int y = 1;

        for (int i = 2; i < n; ++i) {
            y = x + y;
            x = y - x;
        }

        return y;
    }
}
