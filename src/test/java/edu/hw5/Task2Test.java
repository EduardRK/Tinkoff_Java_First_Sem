package edu.hw5;

import java.time.LocalDate;
import java.util.List;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Task2Test {
    @Contract(" -> new")
    private static Arguments @NotNull [] getArgumentsForAllFridays() {
        return new Arguments[] {
            Arguments.of(1925, List.of(
                LocalDate.of(1925, 2, 13),
                LocalDate.of(1925, 3, 13),
                LocalDate.of(1925, 11, 13)
            )),
            Arguments.of(2024, List.of(
                LocalDate.of(2024, 9, 13),
                LocalDate.of(2024, 12, 13)
            )),
            Arguments.of(2000, List.of(
                LocalDate.of(2000, 10, 13)
            )),
            Arguments.of(1826, List.of(
                LocalDate.of(1826, 1, 13),
                LocalDate.of(1826, 10, 13)
            ))
        };
    }

    @Contract(" -> new")
    private static Arguments @NotNull [] getArgumentsForNextFriday() {
        return new Arguments[] {
            Arguments.of(LocalDate.of(2024, 11, 17), LocalDate.of(2024, 12, 13)),
            Arguments.of(LocalDate.of(2000, 1, 1), LocalDate.of(2000, 10, 13)),
            Arguments.of(LocalDate.of(2024, 9, 13), LocalDate.of(2024, 12, 13))
        };
    }

    @ParameterizedTest
    @MethodSource(value = "getArgumentsForAllFridays")
    @DisplayName("All fridays are the 13th of the year")
    public void allFridaysThirteenThisYear(int year, List<LocalDate> expected) {
        Assertions.assertEquals(expected, Task2.allFridaysThirteenThisYear(year));
    }

    @ParameterizedTest
    @MethodSource(value = "getArgumentsForNextFriday")
    @DisplayName("Next friday are 13th")
    public void nextFridayThirteenth(LocalDate actual, LocalDate expected) {
        Assertions.assertEquals(expected, Task2.nextFridayThirteenth(actual));
    }
}
