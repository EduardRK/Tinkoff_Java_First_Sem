package edu.hw6;

import edu.hw6.Task2.Task2;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Task2Test {
    private static final Path DIR_PATH = Path.of("src/main/resources/hw6_TestsDirectory/Task2Test");
    private static final Path FILE_PATH = Path.of(DIR_PATH + "\\" + "Tinkoff Bank Biggest Secret.txt");
    private static final String SECRET = "This is a very, very big secret that no one should ever know";

    @Test
    @DisplayName("Creation new file")
    public void creationNewFile() throws IOException {
        Assertions.assertTrue(Files.notExists(FILE_PATH));
        Task2.cloneFile(FILE_PATH);
        try (PrintWriter printWriter = new PrintWriter(FILE_PATH.toFile())) {
            printWriter.write(SECRET);
        }
        Assertions.assertTrue(Files.exists(FILE_PATH));

        Files.delete(FILE_PATH);
    }

    @Test
    @DisplayName("Creation 3 new copy")
    public void creation3NewCopy() throws IOException {
        Task2.cloneFile(FILE_PATH);
        try (PrintWriter printWriter = new PrintWriter(FILE_PATH.toFile())) {
            printWriter.write(SECRET);
        }

        Path firstCopy = Path.of(DIR_PATH + "\\" + "Tinkoff Bank Biggest Secret — копия.txt");
        Assertions.assertTrue(Files.notExists(firstCopy));
        Task2.cloneFile(FILE_PATH);
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(firstCopy.toFile()))) {
            Assertions.assertEquals(SECRET, bufferedReader.readLine());
        }
        Assertions.assertTrue(Files.exists(firstCopy));

        Path secondCopy = Path.of(DIR_PATH + "\\" + "Tinkoff Bank Biggest Secret — копия (2).txt");
        Assertions.assertTrue(Files.notExists(secondCopy));
        Task2.cloneFile(FILE_PATH);
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(secondCopy.toFile()))) {
            Assertions.assertEquals(SECRET, bufferedReader.readLine());
        }
        Assertions.assertTrue(Files.exists(secondCopy));

        Path thirdCopy = Path.of(DIR_PATH + "\\" + "Tinkoff Bank Biggest Secret — копия (3).txt");
        Assertions.assertTrue(Files.notExists(thirdCopy));
        Task2.cloneFile(FILE_PATH);
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(thirdCopy.toFile()))) {
            Assertions.assertEquals(SECRET, bufferedReader.readLine());
        }
        Assertions.assertTrue(Files.exists(thirdCopy));

        Files.delete(FILE_PATH);
        Files.delete(firstCopy);
        Files.delete(secondCopy);
        Files.delete(thirdCopy);
    }

    @Test
    @DisplayName("Directory has one of copy file")
    public void directoryHasOneOfCopyFile() throws IOException {
        new File(DIR_PATH + "\\" + "Tinkoff Bank Biggest Secret — копия (5).txt").createNewFile();

        Task2.cloneFile(FILE_PATH);
        try (PrintWriter printWriter = new PrintWriter(FILE_PATH.toFile())) {
            printWriter.write(SECRET);
        }

        final int countCopy = 6;
        for (int i = 0; i < countCopy; ++i) {
            Task2.cloneFile(FILE_PATH);
        }

        Assertions.assertTrue(Files.exists(FILE_PATH));
        Assertions.assertTrue(Files.exists(Path.of(DIR_PATH + "\\" + "Tinkoff Bank Biggest Secret — копия.txt")));
        for (int i = 2; i < countCopy + 2; ++i) {
            Path path = Path.of(DIR_PATH + "\\" + "Tinkoff Bank Biggest Secret — копия (" + i + ").txt");
            Assertions.assertTrue(Files.exists(path));

            if (i != 5) {
                try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path.toFile()))) {
                    Assertions.assertEquals(SECRET, bufferedReader.readLine());
                }
            }
        }

        Files.delete(FILE_PATH);
        Files.delete(Path.of(DIR_PATH + "\\" + "Tinkoff Bank Biggest Secret — копия.txt"));
        for (int i = 2; i < countCopy + 2; ++i) {
            Files.delete(Path.of(DIR_PATH + "\\" + "Tinkoff Bank Biggest Secret — копия (" + i + ").txt"));
        }
    }
}
