package edu.hw10.Task1.Classes;

import edu.hw10.Task1.Annotations.Max;
import edu.hw10.Task1.Annotations.Min;
import edu.hw10.Task1.Annotations.NotNull;

public record MyRecord(
    @Min(MIN_VALUE) @Max(MAX_VALUE) int valueFirst,
    @Min(MIN_VALUE) @Max(MAX_VALUE) int valueSecond,
    @NotNull String string) {
    private static final int MIN_VALUE = -10_000;
    private static final int MAX_VALUE = 10_000;

    public MyRecord(@Min(MIN_VALUE) @Max(MAX_VALUE) int value) {
        this(value, value, String.valueOf(value));
    }
}
