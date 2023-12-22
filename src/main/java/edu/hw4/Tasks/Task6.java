package edu.hw4.Tasks;

import edu.hw4.Animal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.jetbrains.annotations.NotNull;

public final class Task6 {
    private Task6() {
    }

    public static Map<Animal.Type, Animal> heaviestAnimalEachType(@NotNull List<Animal> animals) {
        return animals.stream()
            .collect(Collectors.toMap(
                Animal::type,
                animal -> animal,
                (animal1, animal2) -> animal1.weight() > animal2.weight() ? animal1 : animal2
            ));
    }
}
