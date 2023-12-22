package edu.hw4;

import edu.hw4.Tasks.Task3;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Task3Test {
    private static final Animal KIK = new Animal("Kik", Animal.Type.DOG, Animal.Sex.M, 10, 70, 50, true);
    private static final Animal SAM = new Animal("Sam", Animal.Type.CAT, Animal.Sex.M, 7, 49, 12, true);
    private static final Animal OZ = new Animal("Oz", Animal.Type.BIRD, Animal.Sex.M, 21, 30, 8, false);
    private static final Animal BROODA = new Animal("Brooda", Animal.Type.SPIDER, Animal.Sex.F, 56, 150, 40, true);
    private static final Animal KOKOMI = new Animal("Kokomi", Animal.Type.FISH, Animal.Sex.F, 17, 160, 45, false);
    private static final Animal LIZA = new Animal("Liza", Animal.Type.DOG, Animal.Sex.F, 1, 30, 4, true);
    private static final Animal VERY_BIG_NAME =
        new Animal("VeryBigNameAnimal", Animal.Type.CAT, Animal.Sex.F, 6, 64, 8, true);
    private static final Animal SMALL_BIRD = new Animal("SmallBird", Animal.Type.BIRD, Animal.Sex.F, 3, 10, 1, false);

    private static final List<Animal> ANIMAL_LIST = new ArrayList<>(List.of(
        KIK,
        SAM,
        OZ,
        BROODA,
        KOKOMI,
        LIZA,
        VERY_BIG_NAME,
        SMALL_BIRD
    ));

    @Contract(" -> new")
    private static Arguments @NotNull [] getArguments() {
        return new Arguments[] {
            Arguments.of(ANIMAL_LIST, Map.of(
                Animal.Type.SPIDER, 1,
                Animal.Type.DOG, 2,
                Animal.Type.CAT, 2,
                Animal.Type.BIRD, 2,
                Animal.Type.FISH, 1
            )),
            Arguments.of(List.of(
                KIK,
                OZ,
                KOKOMI,
                LIZA,
                SMALL_BIRD
            ), Map.of(
                Animal.Type.DOG, 2,
                Animal.Type.BIRD, 2,
                Animal.Type.FISH, 1
            ))
        };
    }

    @ParameterizedTest
    @MethodSource(value = "getArguments")
    @DisplayName("Counting the number of animals of each type")
    public void animalsOfEachType(List<Animal> animals, Map<Animal.Type, Integer> expected) {
        Assertions.assertEquals(expected, Task3.animalsOfEachType(animals));
    }
}
