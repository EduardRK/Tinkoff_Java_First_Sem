package edu.hw4;

import edu.hw4.Tasks.Task5;
import java.util.List;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Task5Test {
    private static final Animal KIK = new Animal("Kik", Animal.Type.DOG, Animal.Sex.M, 10, 70, 50, true);
    private static final Animal MALE_DOG = new Animal("Doggy", Animal.Type.DOG, Animal.Sex.M, 12, 30, 50, false);
    private static final Animal MALE_FISH = new Animal("Fisheron", Animal.Type.FISH, Animal.Sex.M, 19, 100, 101, true);
    private static final Animal SAM = new Animal("Sam", Animal.Type.CAT, Animal.Sex.M, 7, 49, 12, true);
    private static final Animal OZ = new Animal("Oz", Animal.Type.BIRD, Animal.Sex.M, 21, 30, 8, false);
    private static final Animal BROODA = new Animal("BroodMother", Animal.Type.SPIDER, Animal.Sex.F, 56, 150, 40, true);
    private static final Animal KOKOMI = new Animal("Kokomi", Animal.Type.FISH, Animal.Sex.F, 17, 160, 45, false);
    private static final Animal SNEGOK = new Animal("Snegok", Animal.Type.CAT, Animal.Sex.M, 3, 24, 6, false);
    private static final Animal MALE_SHARK = new Animal("Acula", Animal.Type.FISH, Animal.Sex.M, 14, 121, 50, true);
    private static final Animal CHICKEN = new Animal("Chicka", Animal.Type.BIRD, Animal.Sex.F, 2, 30, 4, false);
    private static final Animal FEMALE_SPIDER = new Animal("Kate", Animal.Type.SPIDER, Animal.Sex.F, 3, 30, 4, true);
    private static final Animal BUKA = new Animal("Buka", Animal.Type.SPIDER, Animal.Sex.F, 1, 12, 2, true);
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
                MALE_DOG,
                MALE_FISH,
                OZ,
                BROODA,
                KOKOMI,
                LIZA,
                VERY_BIG_NAME,
                SMALL_BIRD,
                SNEGOK,
                MALE_SHARK
            ), Animal.Sex.M),
            Arguments.of(List.of(
                KIK,
                SAM,
                CHICKEN,
                FEMALE_SPIDER,
                BUKA,
                MALE_DOG,
                MALE_FISH,
                OZ,
                BROODA,
                KOKOMI,
                LIZA,
                VERY_BIG_NAME,
                SMALL_BIRD,
                SNEGOK,
                MALE_SHARK
            ), Animal.Sex.F),
            Arguments.of(List.of(
                KIK,
                SAM,
                CHICKEN,
                FEMALE_SPIDER,
                BUKA,
                MALE_DOG,
                MALE_FISH,
                OZ,
                BROODA,
                KOKOMI,
                LIZA,
                SMALL_BIRD,
                SNEGOK,
                MALE_SHARK
            ), Animal.Sex.M)
        };
    }

    @ParameterizedTest
    @MethodSource(value = "getArguments")
    @DisplayName("Test compare count male and female")
    public void compareCountMaleAndFemale(List<Animal> animals, Animal.Sex expected) {
        Assertions.assertEquals(expected, Task5.whatSexIsMore(animals));
    }
}
