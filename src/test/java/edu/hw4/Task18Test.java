package edu.hw4;

import edu.hw4.Tasks.Task18;
import java.util.List;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Task18Test {
    private static final Animal KIK = new Animal("Kik", Animal.Type.DOG, Animal.Sex.M, 10, 70, 60, true);
    private static final Animal DOGGY = new Animal("Doggy", Animal.Type.DOG, Animal.Sex.M, 12, 30, 50, false);
    private static final Animal FISHERON = new Animal("Fisheron", Animal.Type.FISH, Animal.Sex.M, 19, 100, 101, true);
    private static final Animal SAM = new Animal("Sam", Animal.Type.CAT, Animal.Sex.M, 7, 49, 12, true);
    private static final Animal OZ = new Animal("Oz", Animal.Type.BIRD, Animal.Sex.M, 21, 30, 8, false);
    private static final Animal BROODA = new Animal("BroodMother", Animal.Type.SPIDER, Animal.Sex.F, 56, 150, 40, true);
    private static final Animal KOKOMI = new Animal("Kokomi", Animal.Type.FISH, Animal.Sex.F, 17, 160, 45, false);
    private static final Animal SNEGOK = new Animal("Snegok", Animal.Type.CAT, Animal.Sex.M, 3, 24, 6, false);
    private static final Animal ACULA = new Animal("Acula", Animal.Type.FISH, Animal.Sex.M, 14, 121, 50, true);
    private static final Animal CHICKA = new Animal("Chicka", Animal.Type.BIRD, Animal.Sex.F, 2, 30, 4, false);
    private static final Animal KATE = new Animal("Kate", Animal.Type.SPIDER, Animal.Sex.F, 3, 30, 4, true);
    private static final Animal BUKA = new Animal("Buka", Animal.Type.SPIDER, Animal.Sex.F, 1, 12, 2, true);
    private static final Animal LIZA = new Animal("Liza", Animal.Type.DOG, Animal.Sex.F, 1, 30, 4, true);
    private static final Animal VERY_BIG_NAME =
        new Animal("Very Big Name Animal", Animal.Type.CAT, Animal.Sex.F, 6, 64, 8, true);
    private static final Animal SMALL_BIRD = new Animal("SmallBird", Animal.Type.BIRD, Animal.Sex.F, 3, 10, 1, false);
    private static final Animal BIG_JADE_SPIDER =
        new Animal("Big Jade Spider", Animal.Type.SPIDER, Animal.Sex.M, 9, 90, 85, true);
    private static final Animal VERY_VERY_BIG_FISH =
        new Animal("Very Very Big Fish", Animal.Type.FISH, Animal.Sex.M, 120, 300, 800, false);
    private static final Animal ANOTHER_DOG =
        new Animal("Another Dog", Animal.Type.DOG, Animal.Sex.M, 12, 30, 21, true);
    private static final Animal ANOTHER_FISH =
        new Animal("Another Fish", Animal.Type.FISH, Animal.Sex.M, 3, 45, 90, false);
    private static final Animal ANOTHER_SPIDER =
        new Animal("Another Spider", Animal.Type.SPIDER, Animal.Sex.F, 7, 15, 2, false);

    @Contract(" -> new")
    private static Arguments @NotNull [] getArguments() {
        return new Arguments[] {
            Arguments.of(List.of(
                KIK,
                DOGGY,
                ACULA,
                CHICKA,
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
                SNEGOK,
                BIG_JADE_SPIDER
            ), List.of(
                VERY_VERY_BIG_FISH,
                ANOTHER_DOG,
                ANOTHER_FISH,
                ANOTHER_SPIDER
            ), VERY_VERY_BIG_FISH),
            Arguments.of(List.of(
                KIK,
                DOGGY,
                CHICKA,
                KATE,
                SAM,
                BUKA,
                OZ,
                BROODA,
                LIZA,
                VERY_BIG_NAME,
                SMALL_BIRD,
                SNEGOK,
                BIG_JADE_SPIDER
            ), List.of(
                ANOTHER_DOG,
                ANOTHER_SPIDER
            ), null),
            Arguments.of(List.of(
                KIK,
                DOGGY,
                ACULA,
                CHICKA,
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
                SNEGOK,
                BIG_JADE_SPIDER
            ), List.of(
                ANOTHER_DOG,
                ANOTHER_SPIDER
            ), FISHERON)
        };
    }

    @ParameterizedTest
    @MethodSource(value = "getArguments")
    @DisplayName("Heaviest fish in several lists")
    public void heaviestFishInSeveralLists(List<Animal> firstAnimals, List<Animal> secondAnimals, Animal expected) {
        Assertions.assertEquals(expected, Task18.heaviestFishInSeveralLists(firstAnimals, secondAnimals));
    }
}
