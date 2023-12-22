package edu.hw1;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;

public class Task3Test {
    @Contract(" -> new")
    private static Arguments @NotNull [] getNestableArguments() {
        return new Arguments[] {
            Arguments.of(new int[] {2, 3, 4}, new int[] {1, 2, 3, 5}),
            Arguments.of(new int[] {1, 2, 9, 12}, new int[] {-100, 100})
        };
    }

    @Contract(" -> new")
    private static Arguments @NotNull [] getNotNestableArguments() {
        return new Arguments[] {
            Arguments.of(new int[] {1}, new int[] {9}),
            Arguments.of(new int[] {2, 3}, new int[] {2, 3}),
            Arguments.of(new int[] {1, 3, 90, 100}, new int[] {40, 49, 100, 101})
        };
    }

    @ParameterizedTest
    @MethodSource(value = "getNestableArguments")
    @DisplayName("Nestable")
    public void nestable(int[] firstArray, int[] secondArray) {
        Assertions.assertTrue(Task3.isNestable(firstArray, secondArray));
        Assertions.assertTrue(Task3.isNestable(firstArray, secondArray));
    }

    @ParameterizedTest
    @MethodSource(value = "getNotNestableArguments")
    @DisplayName("Not nestable")
    public void notNestable(int[] firstArray, int[] secondArray) {
        Assertions.assertFalse(Task3.isNestable(firstArray, secondArray));
        Assertions.assertFalse(Task3.isNestable(firstArray, secondArray));
        Assertions.assertFalse(Task3.isNestable(firstArray, secondArray));
    }

    @ParameterizedTest
    @EmptySource
    @DisplayName("Empty arrays")
    public void emptyArrays(int[] emptyArray) {
        Assertions.assertTrue(Task3.isNestable(emptyArray, new int[] {1, 2, 3, 4}));
        Assertions.assertFalse(Task3.isNestable(new int[] {1, 2, 3, 4}, emptyArray));
        Assertions.assertFalse(Task3.isNestable(emptyArray, emptyArray));
    }

    @ParameterizedTest
    @NullSource
    @DisplayName("Null arrays")
    public void nullArrays(int[] nullArray) {
        Assertions.assertFalse(Task3.isNestable(nullArray, new int[] {1, 2, 3, 4}));
        Assertions.assertFalse(Task3.isNestable(new int[] {1, 2, 3, 4}, nullArray));
        Assertions.assertFalse(Task3.isNestable(null, null));
    }
}
