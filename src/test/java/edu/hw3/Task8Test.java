package edu.hw3;

import edu.hw3.task8.BackwardIterator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Task8Test {
    @Contract(value = " -> new", pure = true)
    private static Arguments @NotNull [] getArguments() {
        return new Arguments[] {
            Arguments.of(
                List.of(1, 2, 3, 4, 5, 6, 7, 8).iterator(),
                new BackwardIterator<>(List.of(8, 7, 6, 5, 4, 3, 2, 1))
            ),
            Arguments.of(
                List.of(23, 42, 21, 0, -21, 100, 90, 90, 12).iterator(),
                new BackwardIterator<>(List.of(12, 90, 90, 100, -21, 0, 21, 42, 23))
            ),
            Arguments.of(
                List.of("a", "b", "c", "d", "e").iterator(),
                new BackwardIterator<>(List.of("e", "d", "c", "b", "a"))
            )
        };
    }

    private static @NotNull List<Object> getList(@NotNull Iterator<Object> iterator) {
        List<Object> objectList = new ArrayList<>();

        while (iterator.hasNext()) {
            objectList.add(iterator.next());
        }

        return objectList;
    }

    @ParameterizedTest
    @MethodSource(value = "getArguments")
    @DisplayName("Example test")
    public void exampleTest(Iterator<Object> actual, @NotNull Iterator<Object> expected) {
        Assertions.assertEquals(getList(expected), getList(actual));
    }
}
