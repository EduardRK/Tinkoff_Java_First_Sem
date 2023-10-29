package edu.hw4.Tasks;

import edu.hw4.Animal;
import java.util.List;

public class Task12 {
    private Task12() {
    }

    public static Integer countOfAnimalsWhoseWeightGreaterThanHeight(List<Animal> animals) {
        return Math.toIntExact(animals.stream()
            .filter(animal -> animal.weight() > animal.height())
            .count());
    }
}
