package edu.hw6.Task3;

import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Pattern;

@FunctionalInterface
public interface AbstractFilter extends DirectoryStream.Filter<Path> {
    int BASE_HEXADECIMAL = 16;
    String REGEX_START = "^.*(";

    static AbstractFilter globMatches(String extension) {
        String regex = REGEX_START + Pattern.quote(extension.substring(1)) + ")$";
        return path -> (Pattern.matches(regex, path.toString()));
    }

    static AbstractFilter regexContains(String subString) {
        String regex = REGEX_START + subString + ").*$";
        return path -> (Pattern.matches(regex, path.toString()));
    }

    static AbstractFilter magicNumber(int... magicNumbers) {
        return path -> {
            byte[] bytes = Files.readAllBytes(path);
            if (bytes.length < magicNumbers.length) {
                return false;
            }
            for (int i = 0; i < magicNumbers.length; ++i) {
                if (Integer.parseInt(String.format("%02x", bytes[i]), BASE_HEXADECIMAL) != magicNumbers[i]) {
                    return false;
                }
            }
            return true;
        };
    }

    static AbstractFilter largerThan(int size) {
        return path -> (path.toFile().length() > size);
    }

    static AbstractFilter lessThan(int size) {
        return path -> (path.toFile().length() < size);
    }

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
