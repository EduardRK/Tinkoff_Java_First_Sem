package edu.hw4.Tasks;

import edu.hw4.Animal;
import java.util.List;

public class Task14 {
    private Task14() {
    }

    public static boolean isAnimalsHasDogWhoseHeightGreaterThanK(List<Animal> animals, int k) {
        return animals.stream()
            .anyMatch(animal -> (animal.type() == Animal.Type.DOG && animal.height() > k));
    }
}
