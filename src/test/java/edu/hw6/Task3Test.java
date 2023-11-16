package edu.hw6;

import edu.hw6.Task3.AbstractFilter;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Task3Test {
    private static final Path DIR_PATH = Path.of("hw6_TestsDirectory\\Task3Test");

    @Test
    @DisplayName("Find readable and regular txt")
    public void readableAndRegularTXT() {
        final AbstractFilter readable = Files::isReadable;
        final AbstractFilter regular = Files::isRegularFile;

        DirectoryStream.Filter<Path> filter = regular
            .and(readable)
            .and(AbstractFilter.globMatches("*.txt"));

        List<Path> filesAfterFilter = new ArrayList<>();
        try (DirectoryStream<Path> entries = Files.newDirectoryStream(DIR_PATH, filter)) {
            for (Path entry : entries) {
                filesAfterFilter.add(entry);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        List<Path> expected = new ArrayList<>(List.of(
            Path.of("hw6_TestsDirectory/Task3Test/EmptyTxt.txt"),
            Path.of("hw6_TestsDirectory/Task3Test/SmallTxt.txt"),
            Path.of("hw6_TestsDirectory/Task3Test/VeryBigTxt.txt")
        ));
        Assertions.assertTrue(expected.containsAll(filesAfterFilter));
    }

    @Test
    @DisplayName("Find readable and regular png")
    public void readableAndPNG() {
        final AbstractFilter readable = Files::isReadable;
        final AbstractFilter regular = Files::isRegularFile;

        DirectoryStream.Filter<Path> filter = readable
            .and(regular)
            .and(AbstractFilter.magicNumber(0x89, 'P', 'N', 'G'))
            .and(AbstractFilter.globMatches("*.png"));

        List<Path> filesAfterFilter = new ArrayList<>();
        try (DirectoryStream<Path> entries = Files.newDirectoryStream(DIR_PATH, filter)) {
            for (Path entry : entries) {
                filesAfterFilter.add(entry);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        List<Path> expected = new ArrayList<>(List.of(
            Path.of("hw6_TestsDirectory/Task3Test/PNG.png")
        ));
        Assertions.assertTrue(expected.containsAll(filesAfterFilter));
    }

    @Test
    @DisplayName("Find readable and regular txt or pdf")
    public void readableAndRegularTXTorPDF() {
        final AbstractFilter readable = Files::isReadable;
        final AbstractFilter regular = Files::isRegularFile;

        DirectoryStream.Filter<Path> filter = regular
            .and(readable)
            .and(AbstractFilter.globMatches("*.txt"))
            .or(AbstractFilter.globMatches("*.pdf"));

        List<Path> filesAfterFilter = new ArrayList<>();
        try (DirectoryStream<Path> entries = Files.newDirectoryStream(DIR_PATH, filter)) {
            for (Path entry : entries) {
                filesAfterFilter.add(entry);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        List<Path> expected = new ArrayList<>(List.of(
            Path.of("hw6_TestsDirectory/Task3Test/EmptyTxt.txt"),
            Path.of("hw6_TestsDirectory/Task3Test/SmallTxt.txt"),
            Path.of("hw6_TestsDirectory/Task3Test/VeryBigTxt.txt"),
            Path.of("hw6_TestsDirectory/Task3Test/File.pdf")
        ));
        Assertions.assertTrue(expected.containsAll(filesAfterFilter));
    }

    @Test
    @DisplayName("Find files larger 2000 bytes")
    public void readableAndRegularFilesLarger2000Bytes() {
        final AbstractFilter readable = Files::isReadable;
        final AbstractFilter regular = Files::isRegularFile;

        DirectoryStream.Filter<Path> filter = regular
            .and(readable)
            .and(AbstractFilter.largerThan(2000));

        List<Path> filesAfterFilter = new ArrayList<>();
        try (DirectoryStream<Path> entries = Files.newDirectoryStream(DIR_PATH, filter)) {
            for (Path entry : entries) {
                filesAfterFilter.add(entry);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        List<Path> expected = new ArrayList<>(List.of(
            Path.of("hw6_TestsDirectory/Task3Test/VeryBigTxt.txt")
        ));
        Assertions.assertTrue(expected.containsAll(filesAfterFilter));
    }

    @Test
    @DisplayName("Find files less than 200 bytes")
    public void readableAndRegularFilesLess200Bytes() {
        final AbstractFilter readable = Files::isReadable;
        final AbstractFilter regular = Files::isRegularFile;

        DirectoryStream.Filter<Path> filter = regular
            .and(readable)
            .and(AbstractFilter.lessThan(200));

        List<Path> filesAfterFilter = new ArrayList<>();
        try (DirectoryStream<Path> entries = Files.newDirectoryStream(DIR_PATH, filter)) {
            for (Path entry : entries) {
                filesAfterFilter.add(entry);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        List<Path> expected = new ArrayList<>(List.of(
            Path.of("hw6_TestsDirectory/Task3Test/SmallTxt.txt"),
            Path.of("hw6_TestsDirectory/Task3Test/EmptyTxt.txt"),
            Path.of("hw6_TestsDirectory/Task3Test/File.pdf"),
            Path.of("hw6_TestsDirectory/Task3Test/File_Name.java")
        ));
        Assertions.assertTrue(expected.containsAll(filesAfterFilter));
    }

    @Test
    @DisplayName("Find not regular file")
    public void notRegularFile() {
        final AbstractFilter regular = Files::isRegularFile;
        final AbstractFilter readable = Files::isReadable;

        DirectoryStream.Filter<Path> filter = readable
            .not(regular);

        List<Path> filesAfterFilter = new ArrayList<>();
        try (DirectoryStream<Path> entries = Files.newDirectoryStream(DIR_PATH, filter)) {
            for (Path entry : entries) {
                filesAfterFilter.add(entry);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        List<Path> expected = new ArrayList<>(List.of(
            Path.of("hw6_TestsDirectory/Task3Test/Directory")
        ));
        Assertions.assertTrue(expected.containsAll(filesAfterFilter));
    }

    @Test
    @DisplayName("Find file name contains -")
    public void fileNameContainsDash() {
        final AbstractFilter regular = Files::isRegularFile;
        final AbstractFilter readable = Files::isReadable;

        DirectoryStream.Filter<Path> filter = readable
            .or(regular)
            .and(AbstractFilter.regexContains("[-]"));

        List<Path> filesAfterFilter = new ArrayList<>();
        try (DirectoryStream<Path> entries = Files.newDirectoryStream(DIR_PATH, filter)) {
            for (Path entry : entries) {
                filesAfterFilter.add(entry);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        List<Path> expected = new ArrayList<>(List.of(
            Path.of("hw6_TestsDirectory/Task3Test/File_Name.java")
        ));
        Assertions.assertTrue(expected.containsAll(filesAfterFilter));
    }
}
