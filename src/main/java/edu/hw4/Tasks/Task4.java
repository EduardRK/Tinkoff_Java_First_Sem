package edu.hw4.Tasks;

import edu.hw4.Animal;
import java.util.Comparator;
import java.util.List;

public class Task4 {
    private Task4() {
    }

    public static Animal animalWithLongestName(List<Animal> animals) {
        return animals.stream()
            .max(Comparator.comparingInt(o -> o.name().length()))
            .orElse(null);
    }
}
