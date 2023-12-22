package edu.hw4;

import edu.hw4.Tasks.Task20;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Task20Test {
    private static final Animal KIK = new Animal("Kik", Animal.Type.DOG, Animal.Sex.M, 10, 70, 60, true);
    private static final Animal DOGGY = new Animal("Doggy", Animal.Type.DOG, Animal.Sex.M, 12, 30, 50, false);
    private static final Animal FISHERON = new Animal("Fisheron", Animal.Type.FISH, Animal.Sex.M, 19, 100, 101, true);
    private static final Animal SAM = new Animal("Sam", Animal.Type.CAT, Animal.Sex.M, 7, 49, 12, true);
    private static final Animal OZ = new Animal("Oz", Animal.Type.BIRD, Animal.Sex.M, 21, 30, 8, false);
    private static final Animal BROODA =
        new Animal("Brood Mother", Animal.Type.SPIDER, Animal.Sex.F, 56, 150, 40, true);
    private static final Animal A = new Animal("A", Animal.Type.FISH, Animal.Sex.M, 0, 0, 90, true);
    private static final Animal JADE_BIRD =
        new Animal("Jade Bird", Animal.Type.BIRD, Animal.Sex.F, 19, 3_000, 9_000, false);
    private static final Animal LADY_CAT = new Animal("Lady Cat", Animal.Type.CAT, Animal.Sex.F, 3_000, -12, 90, false);
    private static final Animal FISHKA = new Animal("Fishka", Animal.Type.FISH, Animal.Sex.F, 10_000, 0, 0, true);
    private static final Animal SPIDER123 =
        new Animal("Spider 123", Animal.Type.SPIDER, Animal.Sex.M, 0, -90, 90_000, false);

    @Contract(" -> new")
    private static Arguments @NotNull [] getArguments() {
        return new Arguments[] {
            Arguments.of(List.of(
                KIK,
                DOGGY,
                FISHERON,
                SAM,
                OZ,
                BROODA,
                A,
                JADE_BIRD,
                LADY_CAT,
                FISHKA,
                SPIDER123
            ), Map.of(
                "A", "AgeHeightName",
                "Brood Mother", "HeightWeight",
                "Lady Cat", "AgeHeight",
                "Jade Bird", "HeightWeight",
                "Spider 123", "AgeHeightWeightName",
                "Fishka", "AgeHeightWeight"
            )),
            Arguments.of(List.of(
                KIK,
                DOGGY,
                FISHERON,
                SAM,
                OZ
            ), new HashMap<>())
        };
    }

    @ParameterizedTest
    @MethodSource(value = "getArguments")
    @DisplayName("Animals with errors string")
    public void animalsWithErrorsString(List<Animal> animals, Map<String, String> expected) {
        Assertions.assertEquals(expected, Task20.animalsWithErrorsString(animals));
    }
}
