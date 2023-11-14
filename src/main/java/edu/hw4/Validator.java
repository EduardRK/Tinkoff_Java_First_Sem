package edu.hw4;

import java.util.List;

public class Validator {
    private Validator() {

    }

    public static boolean isNumberNegative(int number) {
        return (number < 0);
    }

    public static boolean isAbsKLessOrEqualsThanCountAnimals(List<Animal> animals, int k) {
        return (Math.abs(k) <= animals.size());
    }

    public static boolean isZero(int number) {
        return (number == 0);
    }
}
