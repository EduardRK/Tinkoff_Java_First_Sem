package edu.hw4.Tasks;

import edu.hw4.Animal;
import java.util.List;
import java.util.stream.Collectors;
import org.jetbrains.annotations.NotNull;

public final class Task10 {
    private Task10() {
    }

    public static List<Animal> animalsWhoseAgeNotEqualPaws(@NotNull List<Animal> animals) {
        return animals.stream()
            .filter(animal -> animal.paws() != animal.age())
            .collect(Collectors.toList());
    }
}
