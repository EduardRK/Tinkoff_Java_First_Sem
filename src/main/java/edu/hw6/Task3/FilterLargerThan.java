package edu.hw6.Task3;

import java.io.IOException;
import java.nio.file.Path;

public class FilterLargerThan implements AbstractFilter {
    private final int size;

    public FilterLargerThan(int size) {
        this.size = size;
    }

    @Override
    public boolean accept(Path entry) throws IOException {
        return entry.toFile().length() > size;
    }
}
