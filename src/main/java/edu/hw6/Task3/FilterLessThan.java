package edu.hw6.Task3;

import java.nio.file.Path;
import org.jetbrains.annotations.NotNull;

public class FilterLessThan implements AbstractFilter {
    private final int size;

    public FilterLessThan(int size) {
        this.size = size;
    }

    @Override
    public boolean accept(@NotNull Path entry) {
        return entry.toFile().length() < size;
    }
}
