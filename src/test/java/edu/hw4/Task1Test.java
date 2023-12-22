package edu.hw4;

import edu.hw4.Tasks.Task1;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Task1Test {
    private static final Animal KIK = new Animal("Kik", Animal.Type.DOG, Animal.Sex.M, 10, 70, 50, true);
    private static final Animal SAM = new Animal("Sam", Animal.Type.CAT, Animal.Sex.M, 7, 49, 12, true);
    private static final Animal OZ = new Animal("Oz", Animal.Type.BIRD, Animal.Sex.M, 21, 30, 8, false);
    private static final Animal BROODA = new Animal("Brooda", Animal.Type.SPIDER, Animal.Sex.F, 56, 150, 40, true);
    private static final Animal KOKOMI = new Animal("Kokomi", Animal.Type.FISH, Animal.Sex.F, 17, 160, 45, false);
    private static final Animal LIZA = new Animal("Liza", Animal.Type.DOG, Animal.Sex.F, 1, 30, 4, true);
    private static final Animal VERY_BIG_NAME =
        new Animal("VeryBigNameAnimal", Animal.Type.CAT, Animal.Sex.F, 6, 64, 8, true);
    private static final Animal SMALL_BIRD = new Animal("SmallBird", Animal.Type.BIRD, Animal.Sex.F, 3, 10, 1, false);

    @Contract(" -> new")
    private static Arguments @NotNull [] getArguments() {
        return new Arguments[] {
            Arguments.of(List.of(
                KIK,
                SAM,
                OZ,
                BROODA,
                KOKOMI,
                LIZA,
                VERY_BIG_NAME,
                SMALL_BIRD
            ), List.of(
                SMALL_BIRD,
                OZ,
                LIZA,
                SAM,
                VERY_BIG_NAME,
                KIK,
                BROODA,
                KOKOMI
            ))
        };
    }

    @ParameterizedTest
    @MethodSource(value = "getArguments")
    @DisplayName("Sort animals by height")
    public void sortAnimalsByHeight(List<Animal> animals, List<Animal> expected) {
        List<Animal> temporaryAnimals = new ArrayList<>(animals);
        Task1.sortAnimalsHeight(temporaryAnimals);
        Assertions.assertEquals(expected, temporaryAnimals);
    }
}
