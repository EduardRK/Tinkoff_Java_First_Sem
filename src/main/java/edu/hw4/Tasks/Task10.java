package edu.hw4.Tasks;

import edu.hw4.Animal;
import java.util.List;
import java.util.stream.Collectors;

public class Task10 {
    private Task10() {
    }

    public static List<Animal> animalsWhoseAgeNotEqualPaws(List<Animal> animals) {
        return animals.stream()
            .filter(animal -> animal.paws() != animal.age())
            .collect(Collectors.toList());
    }
}
