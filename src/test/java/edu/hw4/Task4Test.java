package edu.hw4;

import edu.hw4.Tasks.Task4;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.MethodSource;

public class Task4Test {
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

    @Contract(value = " -> new", pure = true)
    private static Arguments @NotNull [] getArguments() {
        return new Arguments[] {
            Arguments.of(ANIMAL_LIST, VERY_BIG_NAME)
        };
    }

    @ParameterizedTest
    @MethodSource(value = "getArguments")
    @DisplayName("Animal with longest name")
    public void animalWithLongestName(List<Animal> animals, Animal expected) {
        Assertions.assertEquals(expected, Task4.animalWithLongestName(animals));
    }

    @ParameterizedTest
    @EmptySource
    @DisplayName("Empty list")
    public void emptyList(List<Animal> animals) {
        Assertions.assertNull(Task4.animalWithLongestName(animals));
    }
}
