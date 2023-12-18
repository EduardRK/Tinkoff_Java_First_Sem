package edu.hw8.Task3;

import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Unmodifiable;

public final class Parser {
    private Parser() {
    }

    public static @Unmodifiable List<String> parse(@NotNull String string) {
        return List.of(string.split("\\s+"));
    }
}
