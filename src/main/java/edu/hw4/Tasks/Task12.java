package edu.hw4.Tasks;

import edu.hw4.Animal;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public final class Task12 {
    private Task12() {
    }

    public static @NotNull Integer countOfAnimalsWhoseWeightGreaterThanHeight(@NotNull List<Animal> animals) {
        return Math.toIntExact(animals.stream()
            .filter(animal -> animal.weight() > animal.height())
            .count());
    }
}
