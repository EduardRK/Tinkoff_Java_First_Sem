package edu.hw4;

import edu.hw4.Tasks.Task7;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Task7Test {
    private static final Animal KIK = new Animal("Kik", Animal.Type.DOG, Animal.Sex.M, 10, 70, 60, true);
    private static final Animal DOGGY = new Animal("Doggy", Animal.Type.DOG, Animal.Sex.M, 12, 30, 50, false);
    private static final Animal FISHERON = new Animal("Fisheron", Animal.Type.FISH, Animal.Sex.M, 19, 100, 101, true);
    private static final Animal SAM = new Animal("Sam", Animal.Type.CAT, Animal.Sex.M, 7, 49, 12, true);
    private static final Animal OZ = new Animal("Oz", Animal.Type.BIRD, Animal.Sex.M, 21, 30, 8, false);
    private static final Animal BROODA =
        new Animal("BroodMother", Animal.Type.SPIDER, Animal.Sex.F, 56, 150, 40, true);
    private static final Animal KOKOMI = new Animal("Kokomi", Animal.Type.FISH, Animal.Sex.F, 17, 160, 45, false);
    private static final Animal SNEGOK = new Animal("Snegok", Animal.Type.CAT, Animal.Sex.M, 3, 24, 6, false);
    private static final Animal ACULA = new Animal("Acula", Animal.Type.FISH, Animal.Sex.M, 14, 121, 50, true);
    private static final Animal CHICKEN = new Animal("Chicka", Animal.Type.BIRD, Animal.Sex.F, 2, 30, 4, false);
    private static final Animal KATE = new Animal("Kate", Animal.Type.SPIDER, Animal.Sex.F, 3, 30, 4, true);
    private static final Animal BUKA = new Animal("Buka", Animal.Type.SPIDER, Animal.Sex.F, 1, 12, 2, true);
    private static final Animal LIZA = new Animal("Liza", Animal.Type.DOG, Animal.Sex.F, 1, 30, 4, true);
    private static final Animal VERY_BIG_NAME =
        new Animal("VeryBigNameAnimal", Animal.Type.CAT, Animal.Sex.F, 6, 64, 8, true);
    private static final Animal SMALL_BIRD = new Animal("SmallBird", Animal.Type.BIRD, Animal.Sex.F, 3, 10, 1, false);
    private static final List<Animal> ANIMAL_LIST = new ArrayList<>(List.of(
        KIK,
        DOGGY,
        ACULA,
        CHICKEN,
        KATE,
        SAM,
        BUKA,
        OZ,
        BROODA,
        FISHERON,
        KOKOMI,
        LIZA,
        VERY_BIG_NAME,
        SMALL_BIRD,
        SNEGOK
    ));

    @Contract(value = " -> new", pure = true)
    private static Arguments @NotNull [] getArgumentsValid() {
        return new Arguments[] {
            Arguments.of(4, ANIMAL_LIST, KOKOMI)
        };
    }

    @Contract(value = " -> new", pure = true)
    private static Arguments @NotNull [] getArgumentsInvalid() {
        return new Arguments[] {
            Arguments.of(-10, ANIMAL_LIST),
            Arguments.of(40, ANIMAL_LIST),
            Arguments.of(0, ANIMAL_LIST),
            Arguments.of(-10, ANIMAL_LIST),
        };
    }

    @ParameterizedTest
    @MethodSource(value = "getArgumentsValid")
    @DisplayName("Valid K")
    public void kOldestAnimal(int k, List<Animal> animals, Animal expected) {
        Assertions.assertEquals(expected, Task7.kOldestAnimal(animals, 4));
    }

    @ParameterizedTest
    @MethodSource(value = "getArgumentsInvalid")
    @DisplayName("Invalid K")
    public void invalidK(int k, List<Animal> animals) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> Task7.kOldestAnimal(animals, k));
    }
}
