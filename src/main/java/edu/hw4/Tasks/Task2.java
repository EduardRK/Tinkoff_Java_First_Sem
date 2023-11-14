package edu.hw4.Tasks;

import edu.hw4.Animal;
import edu.hw4.Validator;
import java.util.List;
import java.util.stream.Collectors;

public class Task2 {
    private Task2() {
    }

    public static List<Animal> takeKHeaviest(List<Animal> animals, int k) {
        if (!Validator.isAbsKLessOrEqualsThanCountAnimals(animals, k) || Validator.isNumberNegative(k)) {
            throw new IllegalArgumentException();
        }
        return animals.stream()
            .sorted((o1, o2) -> o2.weight() - o1.weight())
            .limit(k)
            .collect(Collectors.toList());

    }
}
