package edu.hw6.Task3;

import java.nio.file.Path;
import java.util.regex.Pattern;
import org.jetbrains.annotations.NotNull;

public class FilterRegexContains implements AbstractFilter {
    private final String subString;

    public FilterRegexContains(String subString) {
        this.subString = subString;
    }

    @Override
    public boolean accept(@NotNull Path entry) {
        String regex = "^.*(" + Pattern.quote(subString) + ").*$";
        return Pattern.matches(regex, entry.toString());
    }
}
