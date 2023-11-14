package edu.hw4.Tasks;

import edu.hw4.Animal;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Task8 {
    private Task8() {
    }

    public static Optional<Animal> heaviestAnimalBelowK(List<Animal> animals, int k) {
        return animals.stream()
            .filter(animal -> animal.height() <= k)
            .max(Comparator.comparingInt(Animal::weight));
    }
}
