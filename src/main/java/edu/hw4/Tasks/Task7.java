package edu.hw4.Tasks;

import edu.hw4.Animal;
import java.util.Comparator;
import java.util.List;

public final class Task7 {
    private Task7() {
    }

    public static Animal kOldestAnimal(List<Animal> animals, int k) {
        if (k <= 0 || k > animals.size()) {
            throw new IllegalArgumentException();
        }

        return animals.stream()
            .sorted(Comparator.comparingInt(Animal::age).reversed())
            .skip(k - 1)
            .findFirst()
            .orElse(null);
    }
}
