package edu.hw9;

import edu.hw9.Task2.DirectoryFinder;
import edu.hw9.Task2.FileFinder;
import edu.hw9.Task2.Finder;
import java.io.File;
import java.nio.file.Path;
import java.util.List;
import java.util.function.Predicate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class Task2Test {
    @Nested
    @DisplayName("Directories find")
    public class DirectoriesFind {
        @ParameterizedTest
        @CsvSource(value = {
            "src/main/resources/hw9_TestsDirectory/Task2Test/Directory1, 1, 5",
            "src/main/resources/hw9_TestsDirectory/Task2Test/Directory1, 14, 2",
            "src/main/resources/hw9_TestsDirectory/Task2Test/Directory1/Directory3, 10, 2",
            "src/main/resources/hw9_TestsDirectory/Task2Test/Directory1/Directory2/Directory4/DirectoryEmpty, 1, 0"
        })
        public void testFinder(String directory, int n, int expectedSize) {
            Path path = Path.of(directory);
            Finder<Integer> finder = new DirectoryFinder(path);
            List<Path> actual = finder.find(n);
            Assertions.assertEquals(expectedSize, actual.size());
        }
    }

    @Nested
    @DisplayName("Files find")
    public class FilesFind {
        @Test
        @DisplayName("Test file size")
        public void testFileSize() {
            Predicate<File> filter = (file -> file.length() > 50);
            Path path = Path.of("src/main/resources/hw9_TestsDirectory/Task2Test/Directory1");
            Finder<Predicate<File>> finder = new FileFinder(path);
            List<Path> actual = finder.find(filter);
            Assertions.assertEquals(20, actual.size());
        }

        @Test
        @DisplayName("Test file is readable")
        public void testFileIsReadable() {
            Predicate<File> filter = (File::canRead);
            Path path = Path.of("src/main/resources/hw9_TestsDirectory/Task2Test/Directory1");
            Finder<Predicate<File>> finder = new FileFinder(path);
            List<Path> actual = finder.find(filter);
            Assertions.assertEquals(61, actual.size());
        }
    }
}
