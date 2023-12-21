package edu.hw4.Tasks;

import edu.hw4.Animal;
import java.util.Comparator;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public final class Task4 {
    private Task4() {
    }

    public static Animal animalWithLongestName(@NotNull List<Animal> animals) {
        return animals.stream()
            .max(Comparator.comparingInt(animal -> animal.name().length()))
            .orElse(null);
    }
}
