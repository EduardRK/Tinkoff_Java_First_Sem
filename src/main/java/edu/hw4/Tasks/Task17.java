package edu.hw4.Tasks;

import edu.hw4.Animal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.jetbrains.annotations.NotNull;

public final class Task17 {
    private Task17() {
    }

    public static boolean isSpidersBiteOftenDogs(@NotNull List<Animal> animals) {
        Map<Animal.Type, Integer> countDogsAndSpiders = animals.stream()
            .filter(animal -> animal.type() == Animal.Type.DOG || animal.type() == Animal.Type.SPIDER)
            .collect(Collectors.toMap(Animal::type, animal -> 1, Integer::sum));

        Map<Animal.Type, Integer> countBitingDogsAndSpiders = animals.stream()
            .filter(animal -> (animal.type() == Animal.Type.DOG || animal.type() == Animal.Type.SPIDER)
                && animal.bites())
            .collect(Collectors.toMap(Animal::type, animal -> 1, Integer::sum));

        if (countDogsAndSpiders.get(Animal.Type.DOG) == null || countDogsAndSpiders.get(Animal.Type.SPIDER) == null) {
            return false;
        }

        return
            (double) (countBitingDogsAndSpiders.get(Animal.Type.SPIDER) / countDogsAndSpiders.get(Animal.Type.SPIDER))
                > (double) (countBitingDogsAndSpiders.get(Animal.Type.DOG) / countDogsAndSpiders.get(Animal.Type.DOG));
    }
}
