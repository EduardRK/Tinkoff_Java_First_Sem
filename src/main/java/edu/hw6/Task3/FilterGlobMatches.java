package edu.hw6.Task3;

import java.nio.file.Path;
import java.util.regex.Pattern;
import org.jetbrains.annotations.NotNull;

public class FilterGlobMatches implements AbstractFilter {
    private final String extension;

    public FilterGlobMatches(String extension) {
        this.extension = extension;
    }

    @Override
    public boolean accept(@NotNull Path entry) {
        String regex = "^.*(" + Pattern.quote(extension.substring(1)) + ")$";
        return Pattern.matches(regex, entry.toString());
    }
}
