package edu.hw4.Tasks;

import edu.hw4.Animal;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public final class Task9 {
    private Task9() {
    }

    public static @NotNull Integer numberOfAllPaws(@NotNull List<Animal> animals) {
        return animals.stream()
            .mapToInt(Animal::paws)
            .sum();
    }
}

