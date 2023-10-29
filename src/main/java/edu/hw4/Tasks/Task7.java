package edu.hw4.Tasks;

import edu.hw4.Animal;
import edu.hw4.Validator;
import java.util.Comparator;
import java.util.List;

public class Task7 {
    private Task7() {
    }

    public static Animal kOldestAnimal(List<Animal> animals, int k) {
        if (Validator.isZero(k)) {
            throw new IllegalArgumentException();
        }
        if (!Validator.isAbsKLessOrEqualsThanCountAnimals(animals, k)) {
            throw new IllegalArgumentException();
        }

        if (Validator.isNumberNegative(k)) {
            return animals.stream()
                .sorted(Comparator.comparingInt(Animal::age))
                .skip((-k) - 1)
                .findFirst()
                .orElse(null);
        } else {
            return animals.stream()
                .sorted((o1, o2) -> o2.age() - o1.age())
                .skip(k - 1)
                .findFirst()
                .orElse(null);
        }
    }
}
