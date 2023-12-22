package edu.hw4.Tasks;

import edu.hw4.Animal;
import java.util.Comparator;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public final class Task1 {
    private Task1() {

    }

    public static void sortAnimalsHeight(@NotNull List<Animal> animals) {
        animals.sort(Comparator.comparingInt(Animal::height));
    }
}
