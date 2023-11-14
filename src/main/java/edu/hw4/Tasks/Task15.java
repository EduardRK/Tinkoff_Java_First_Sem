package edu.hw4.Tasks;

import edu.hw4.Animal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Task15 {
    private Task15() {
    }

    public static Map<Animal.Type, Integer> totalWeightOfAnimalEachTypeAgedFromKtoL(
        List<Animal> animals,
        int k,
        int l
    ) {
        return animals.stream()
            .filter(animal -> (animal.age() >= k && animal.age() <= l))
            .collect(Collectors.toMap(Animal::type, Animal::weight, Integer::sum));
    }
}

