package edu.hw6.Task3;

import java.io.IOException;
import java.nio.file.Path;

public class FilterLessThan implements AbstractFilter {
    private final int size;

    public FilterLessThan(int size) {
        this.size = size;
    }

    @Override
    public boolean accept(Path entry) throws IOException {
        return entry.toFile().length() < size;
    }
}
