package edu.hw6.Task3;

import java.nio.file.DirectoryStream;
import java.nio.file.Path;

@FunctionalInterface
public interface AbstractFilter extends DirectoryStream.Filter<Path> {
    default AbstractFilter and(AbstractFilter filter) {
        return path -> this.accept(path) && filter.accept(path);
    }

    default AbstractFilter or(AbstractFilter filter) {
        return path -> this.accept(path) || filter.accept(path);
    }

    default AbstractFilter not(AbstractFilter filter) {
        return path -> !filter.accept(path);
    }
}
