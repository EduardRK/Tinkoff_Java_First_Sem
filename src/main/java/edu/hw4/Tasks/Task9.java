package edu.hw4.Tasks;

import edu.hw4.Animal;
import java.util.List;

public class Task9 {
    private Task9() {
    }

    public static Integer numberOfAllPaws(List<Animal> animals) {
        return animals.stream()
            .mapToInt(Animal::paws)
            .sum();
    }
}

