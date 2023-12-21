package edu.hw5;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.List;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Task1Test {
    @Contract(" -> new")
    private static Arguments @NotNull [] getArgumentsValid() {
        return new Arguments[] {
            Arguments.of(List.of(
                "2022-03-12, 20:20 - 2022-03-12, 23:50",
                "2022-04-01, 21:30 - 2022-04-02, 01:20"
            ), Duration.of(220, ChronoUnit.MINUTES)),
            Arguments.of(List.of(
                "2022-03-12, 20:30 - 2022-03-12, 23:30",
                "2022-04-01, 21:30 - 2022-04-01, 22:30",
                "2022-07-22, 23:00 - 2022-07-23, 02:00",
                "2000-01-02, 02:00 - 2000-01-02, 02:00",
                "2022-03-12, 19:20 - 2022-03-12, 23:20",
                "2007-12-31, 23:00 - 2008-01-01, 02:00",
                "1987-02-02, 01:00 - 1987-02-02, 01:00"
            ), Duration.of(2, ChronoUnit.HOURS)),
            Arguments.of(List.of(
                "2022-03-12, 20:20 - 2022-03-12, 23:50",
                "2022-04-01, 14:23 - 2022-04-01, 17:21",
                "2022-04-01, 15:34 - 2022-04-01, 19:59",
                "2022-04-01, 02:17 - 2022-04-01, 10:00"
            ), Duration.of(16740, ChronoUnit.SECONDS))
        };
    }

    @Contract(" -> new")
    private static Arguments @NotNull [] getArgumentsInvalid() {
        return new Arguments[] {
            Arguments.of(List.of(
                "2022-03-12, 20:30 - 2022-03-12, 23:30",
                "2022-04-01, 21:30 - 2022-04-01, 22:30",
                "2022-07-22, 23:00 - 2022-07-23, 02:00",
                "2000-01-02, 02:00 - 2000-01-02, 02:00",
                "2022-03-12, 19:20 - 2022-03-12, 23:20",
                "2007-12-31 - 2008-01-01, 02:00",
                "1987-02-02, 01:00 - 1987-02-02, 01:00"
            )),
            Arguments.of(List.of(
                "2022-03-12, 20:30 - 2022-03-12, 23:30",
                "2022-04-01, 21:30 - 2022-04-01, 22:30",
                "712854195194671",
                "2000-01-02, 02:00 - 2000-01-02, 02:00",
                "2022-03-12, 19:20 - 2022-03-12, 23:20",
                "2007-12-31, 23:00 - 2008-01-01, 02:00",
                "1987-02-02, 01:00 - 1987-02-02, 01:00"
            )),
            Arguments.of(List.of(
                "2022-03-12, 20:30 - 2022-03-12, 23:30",
                "2022-04-01, 21:30 - 2022-04-01, 22:30",
                "2022-07-22, 23:002022-07-23, 02:00",
                "2000-01-02, 02:00 - 2000-01-02, 02:00",
                "2022-03-12, 19:20 - 2022-03-12, 23:20",
                "2007-12-31, 23:00 - 2008-01-01, 02:00",
                "1987-02-02, 01:00 - 1987-02-02, 01:00"
            )),
            Arguments.of(List.of(
                "2022-13-12, 20:30 - 2022-03-12, 23:30",
                "2022-04-01, 21:30 - 2022-04-01, 22:30",
                "2022-07-22, 23:00 - 2022-07-23, 02:00",
                "2000-01-02, 02:00 - 2000-01-02, 02:00",
                "2022-03-12, 19:20 - 2022-03-12, 23:20",
                "2007-12-31, 23:00 - 2008-01-01, 02:00",
                "1987-02-02, 01:00 - 1987-02-02, 01:00"
            )),
            Arguments.of(List.of(
                "2022-03-12, 20:30 - 2022-03-12, 23:30",
                "2022-04-01, 21:30 - 2022-04-01, 22:30",
                "2022-07-22, 23:00 - 2022-07-23, 02:00",
                "2000-01-02, 02:00 - 2000-01-02, 02:00",
                "2022-03-41, 19:20 - 2022-03-12, 23:20",
                "2007-12-31, 23:00 - 2008-01-01, 02:00",
                "1987-02-02, 01:00 - 1987-02-02, 01:00"
            )),
            Arguments.of(List.of(
                "2022-03-12, 20:30 - 2022-03-12, 23:30",
                "2022-04-01, 21:30 - 2022-04-01, 22:30",
                "2022-07-22, 23:00 - 2022-07-23, 02:00",
                "2000-01-02, 02:00 - 2000-01-02, 02:00",
                "2022-03-12, 19:20 - 2022-03-12, 15:20",
                "2007-12-31, 23:00 - 2008-01-01, 02:00",
                "1987-02-02, 01:00 - 1987-02-02, 01:00"
            ))
        };
    }

    @ParameterizedTest
    @MethodSource(value = "getArgumentsValid")
    @DisplayName("Valid sessions")
    public void exampleTest(List<String> sessions, Duration expected) {
        Assertions.assertEquals(expected, Task1.averageSession(sessions));
    }

    @ParameterizedTest
    @MethodSource(value = "getArgumentsInvalid")
    @DisplayName("Invalid sessions")
    public void invalidSessions(List<String> sessions) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> Task1.averageSession(sessions));
    }
}
