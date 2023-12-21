package edu.hw4.Tasks;

import edu.hw4.Animal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public final class Task18 {
    private Task18() {
    }

    @SafeVarargs
    public static Animal heaviestFishInSeveralLists(List<Animal>... animalsLists) {
        return Arrays.stream(animalsLists)
            .map(animals -> animals.stream()
                .filter(animal -> animal.type() == Animal.Type.FISH)
                .max(Comparator.comparingInt(Animal::weight))
                .orElse(null))
            .filter(Objects::nonNull)
            .max(Comparator.comparingInt(Animal::weight))
            .orElse(null);
    }
}
