package edu.hw10.Task1.Classes;

import edu.hw10.Task1.Annotations.Max;
import edu.hw10.Task1.Annotations.Min;
import edu.hw10.Task1.Annotations.NotNull;

public class MyClass {
    private static final int MAX_VALUE = 5_000;
    private static final int MIN_VALUE = -1_000;
    private static final String DEFAULT = "DEFAULT";
    private final String name;
    private final int value;

    public MyClass(@Max(MAX_VALUE) @Min(MIN_VALUE) int value, @NotNull String name) {
        this.value = value;
        this.name = name;
    }

    public MyClass(@Max(MAX_VALUE) @Min(MIN_VALUE) int value) {
        this.value = value;
        this.name = DEFAULT;
    }

    public MyClass(@NotNull String name) {
        this.value = MIN_VALUE;
        this.name = name;
    }

    public MyClass() {
        this.value = MAX_VALUE;
        this.name = DEFAULT;
    }

    public static MyClass create(@Max(MAX_VALUE) @Min(MIN_VALUE) int value, @NotNull String name) {
        return new MyClass(value, name);
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }
}
