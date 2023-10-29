package edu.hw4.Tasks;

import edu.hw4.Animal;
import java.util.List;
import java.util.stream.Collectors;

public class Task13 {
    private Task13() {
    }

    public static List<Animal> animalsWhoseNameMoreThanTwoWords(List<Animal> animals) {
        return animals.stream()
            .filter(animal -> (animal.name().split(" ").length) > 2)
            .collect(Collectors.toList());
    }
}
