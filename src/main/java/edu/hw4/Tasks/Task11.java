package edu.hw4.Tasks;

import edu.hw4.Animal;
import java.util.List;
import java.util.stream.Collectors;

public class Task11 {
    private static final int HEIGHT_FROM_CONDITION = 100;

    private Task11() {
    }

    public static List<Animal> animalsThatCanBiteAndHeightMore100(List<Animal> animals) {
        return animals.stream()
            .filter(animal -> (animal.bites() && (animal.height() > HEIGHT_FROM_CONDITION)))
            .collect(Collectors.toList());
    }
}
