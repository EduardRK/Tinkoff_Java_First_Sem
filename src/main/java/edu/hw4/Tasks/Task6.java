package edu.hw4.Tasks;

import edu.hw4.Animal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Task6 {
    private Task6() {
    }

    public static Map<Animal.Type, Animal> heaviestAnimalEachType(List<Animal> animals) {
        return animals.stream()
            .collect(Collectors.toMap(
                Animal::type,
                animal -> animal,
                (o1, o2) -> o1.weight() > o2.weight() ? o1 : o2
            ));
    }
}
