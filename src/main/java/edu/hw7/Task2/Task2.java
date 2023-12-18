package edu.hw7.Task2;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public final class Task2 {
    private Task2() {
    }

    public static BigInteger factorialParallel(int number) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= number; ++i) {
            list.add(i);
        }
        return list.parallelStream()
            .map(BigInteger::valueOf)
            .reduce(BigInteger.valueOf(1), BigInteger::multiply);
    }

    public static BigInteger factorialNotParallel(int number) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= number; ++i) {
            list.add(i);
        }
        return list.stream()
            .map(BigInteger::valueOf)
            .reduce(BigInteger.valueOf(1), BigInteger::multiply);
    }
}
