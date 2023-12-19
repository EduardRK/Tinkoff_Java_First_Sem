package edu.hw3;

import edu.hw3.task3.Task3;
import java.util.HashMap;
import java.util.Map;
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
    private static Arguments @NotNull [] getArguments() {
        return new Arguments[] {
            Arguments.of(new String[] {"a", "bb", "a", "bb"}, new HashMap<>(Map.of(
                "bb", 2,
                "a", 2
            ))),
            Arguments.of(new String[] {"this", "and", "that", "and"}, new HashMap<>(Map.of(
                "that", 1,
                "and", 2,
                "this", 1
            ))),
            Arguments.of(new String[] {"код", "код", "код", "bug"}, new HashMap<>(Map.of(
                "код", 3,
                "bug", 1
            ))),
            Arguments.of(new Integer[] {1, 1, 2, 2}, new HashMap<>(Map.of(
                1, 2,
                2, 2
            ))),
            Arguments.of(new Double[] {1.3, 2.3, 3.3, 4.3, 1.3, 10D}, new HashMap<>(Map.of(
                1.3, 2,
                2.3, 1,
                3.3, 1,
                4.3, 1,
                10D, 1
            ))),
            Arguments.of(new Float[] {1F, 1F, 1F, 1F, 1F, 1F, 1F, 1F, 1F, 1F, 1F, 1F}, new HashMap<>(Map.of(
                1F, 12
            )))
        };
    }

    @ParameterizedTest
    @MethodSource(value = "getArguments")
    @DisplayName("Test create freq dictionary")
    public void exampleTests(Object[] data, Map<Object, Integer> freqDict) {
        Assertions.assertEquals(freqDict, Task3.freqDict(data));
    }

    @ParameterizedTest
    @EmptySource
    @DisplayName("Empty array")
    public void emptyArray(Object[] data) {
        Assertions.assertEquals(new HashMap<>(), Task3.freqDict(data));
    }

    @ParameterizedTest
    @NullSource
    @DisplayName("Null array")
    public void nullArray(Object[] data) {
        Assertions.assertNull(Task3.freqDict(data));
    }
}
