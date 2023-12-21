package edu.hw3;

import edu.hw3.task2.Task2;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

public class Task2Test {
    @Contract(" -> new")
    private static Arguments @NotNull [] getTestData() {
        return new Arguments[] {
            Arguments.of("()()()", new ArrayList<>(List.of("()", "()", "()"))),
            Arguments.of("((()))", new ArrayList<>(List.of("((()))"))),
            Arguments.of("((()))(())()()(()())", new ArrayList<>(List.of("((()))", "(())", "()", "()", "(()())"))),
            Arguments.of("((())())(()(()()))", new ArrayList<>(List.of("((())())", "(()(()()))")))
        };
    }

    @ParameterizedTest
    @MethodSource(value = "getTestData")
    @DisplayName("Example tests")
    public void exampleTests(String brackets, List<String> clusterizeBrackets) {
        Assertions.assertEquals(clusterizeBrackets, Task2.clusterize(brackets));
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("Null and empty string")
    public void emptyString(String brackets) {
        Assertions.assertEquals(brackets, Task2.clusterize(brackets).getFirst());
    }

    @ParameterizedTest
    @CsvSource(value = {
        "((12))",
        "(()()))()"
    })
    @DisplayName("Invalid string")
    public void invalidString(String brackets) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> Task2.clusterize(brackets));
    }
}
