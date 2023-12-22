package edu.hw2;

import edu.hw2.task2.Rectangle;
import edu.hw2.task2.Square;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task2Test {
    @Contract(" -> new")
    private static Arguments @NotNull [] rectangles() {
        return new Arguments[] {
            Arguments.of(new Rectangle(90, 10)),
            Arguments.of(new Square(30))
        };
    }

    @ParameterizedTest
    @MethodSource("rectangles")
    public void rectangleArea(@NotNull Rectangle rect) {
        assertThat(rect.area()).isEqualTo(900.0);
    }
}
