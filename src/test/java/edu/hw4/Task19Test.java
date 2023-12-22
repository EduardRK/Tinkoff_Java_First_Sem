package edu.hw4;

import edu.hw4.Tasks.Task19;
import edu.hw4.ValidationError.ValidationError;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Task19Test {
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
    private static final ValidationError AGE_ERROR = new ValidationError("Age");
    private static final ValidationError HEIGHT_ERROR = new ValidationError("Height");
    private static final ValidationError WEIGHT_ERROR = new ValidationError("Weight");
    private static final ValidationError NAME_ERROR = new ValidationError("Name");

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
                "A", Set.of(AGE_ERROR, HEIGHT_ERROR, NAME_ERROR),
                "Brood Mother", Set.of(HEIGHT_ERROR, WEIGHT_ERROR),
                "Lady Cat", Set.of(AGE_ERROR, HEIGHT_ERROR),
                "Jade Bird", Set.of(HEIGHT_ERROR, WEIGHT_ERROR),
                "Spider 123", Set.of(AGE_ERROR, HEIGHT_ERROR, WEIGHT_ERROR, NAME_ERROR),
                "Fishka", Set.of(AGE_ERROR, HEIGHT_ERROR, WEIGHT_ERROR)
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
    @DisplayName("Some animals with error")
    public void someAnimalsWithError(List<Animal> animals, Map<String, Set<ValidationError>> expected) {
        Assertions.assertEquals(expected, Task19.animalsWithErrors(animals));
    }
}
