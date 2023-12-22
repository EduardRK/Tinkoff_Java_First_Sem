package edu.hw4.Tasks;

import edu.hw4.Animal;
import java.util.List;
import java.util.stream.Collectors;
import org.jetbrains.annotations.NotNull;

public final class Task13 {
    private Task13() {
    }

    public static List<Animal> animalsWhoseNameMoreThanTwoWords(@NotNull List<Animal> animals) {
        return animals.stream()
            .filter(animal -> (animal.name().split("\\s+").length) > 2)
            .collect(Collectors.toList());
    }
}
