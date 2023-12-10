package edu.hw6.Task3;

import java.io.IOException;
import java.nio.file.Path;
import java.util.regex.Pattern;

public class FilterRegexContains implements AbstractFilter {
    private final String subString;

    public FilterRegexContains(String subString) {
        this.subString = subString;
    }

    @Override
    public boolean accept(Path entry) throws IOException {
        String regex = "^.*(" + Pattern.quote(subString) + ").*$";
        return Pattern.matches(regex, entry.toString());
    }
}
