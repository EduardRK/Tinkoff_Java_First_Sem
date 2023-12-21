package edu.hw4.Tasks;

import edu.hw4.Animal;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public final class Task2 {
    private Task2() {
    }

    public static List<Animal> takeKHeaviest(List<Animal> animals, int k) {
        if (k < 0 || k > animals.size()) {
            throw new IllegalArgumentException();
        }

        return animals.stream()
            .sorted(Comparator.comparingInt(Animal::weight).reversed())
            .limit(k)
            .collect(Collectors.toList());

    }
}
