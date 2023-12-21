package edu.hw4.Tasks;

import edu.hw4.Animal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.jetbrains.annotations.NotNull;

public final class Task3 {
    private Task3() {
    }

    public static Map<Animal.Type, Integer> animalsOfEachType(@NotNull List<Animal> animals) {
        return animals.stream()
            .collect(Collectors.toMap(
                Animal::type,
                count -> 1,
                Integer::sum
            ));
    }
}
