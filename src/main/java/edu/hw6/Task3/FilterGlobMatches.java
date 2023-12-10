package edu.hw6.Task3;

import java.io.IOException;
import java.nio.file.Path;
import java.util.regex.Pattern;

public class FilterGlobMatches implements AbstractFilter {
    private final String extension;

    public FilterGlobMatches(String extension) {
        this.extension = extension;
    }

    @Override
    public boolean accept(Path entry) throws IOException {
        String regex = "^.*(" + Pattern.quote(extension.substring(1)) + ")$";
        return Pattern.matches(regex, entry.toString());
    }
}
