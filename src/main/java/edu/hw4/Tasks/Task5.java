package edu.hw4.Tasks;

import edu.hw4.Animal;
import java.util.List;

public class Task5 {
    private Task5() {
    }

    public static Animal.Sex whatSexIsMore(List<Animal> animals) {
        return (animals.stream()
            .mapToInt(animal -> animal.sex() == Animal.Sex.M ? 1 : -1)
            .sum() >= 0) ? Animal.Sex.M : Animal.Sex.F;
    }
}
