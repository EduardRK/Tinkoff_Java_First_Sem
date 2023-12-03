package edu.hw9.Task2;

import java.nio.file.Path;
import java.util.List;

public interface Finder<T> {
    List<Path> find(T filter);
}
