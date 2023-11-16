package edu.hw6;

import edu.hw6.Task2.Task2;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.CleanupMode;
import org.junit.jupiter.api.io.TempDir;

public class Task2Test {
    private static final String SECRET = "This is very very secret information that no one should ever know";

    @Test
    @DisplayName("Creating new file")
    public void creatingNewFile(@TempDir(cleanup = CleanupMode.ALWAYS) Path dir) {
        Path filePath = Path.of(dir + File.separator + "Tinkoff Bank Biggest Secret.txt");
        Assertions.assertTrue(Files.notExists(filePath));
        Task2.cloneFile(filePath);
        Assertions.assertTrue(Files.exists(filePath));
    }

    @Test
    @DisplayName("Creating some copy")
    public void creatingSomeCopyFile(@TempDir(cleanup = CleanupMode.ALWAYS) Path dir) throws IOException {
        Path filePath = Path.of(dir + File.separator + "Tinkoff Bank Biggest Secret.txt");
        Task2.cloneFile(filePath);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath.toFile()))) {
            bufferedWriter.write(SECRET);
            bufferedWriter.flush();
        }

        for (int i = 0; i < 4; i++) {
            Task2.cloneFile(filePath);
        }

        Path firstCopyPath = Path.of(dir + File.separator + "Tinkoff Bank Biggest Secret — копия.txt");
        Path secondCopyPath = Path.of(dir + File.separator + "Tinkoff Bank Biggest Secret — копия (2).txt");
        Path thirdCopyPath = Path.of(dir + File.separator + "Tinkoff Bank Biggest Secret — копия (3).txt");
        Path fourthCopyPath = Path.of(dir + File.separator + "Tinkoff Bank Biggest Secret — копия (4).txt");
        List<Path> list =
            new ArrayList<>(List.of(filePath, firstCopyPath, secondCopyPath, thirdCopyPath, fourthCopyPath));

        for (Path path : list) {
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path.toFile()))) {
                Assertions.assertEquals(SECRET, bufferedReader.readLine());
            }
        }
    }

    @Test
    @DisplayName("Directory has one copy file")
    public void directoryHasOneCopyFile(@TempDir(cleanup = CleanupMode.ALWAYS) Path dir) throws IOException {
        Path otherCopy = Path.of(dir + File.separator + "Tinkoff Bank Biggest Secret — копия (3).txt");
        otherCopy.toFile().createNewFile();
        Path filePath = Path.of(dir + File.separator + "Tinkoff Bank Biggest Secret.txt");
        Task2.cloneFile(filePath);
        try (BufferedWriter bufferedWriter = new BufferedWriter((new FileWriter(filePath.toFile())))) {
            bufferedWriter.write(SECRET);
            bufferedWriter.flush();
        }

        for (int i = 0; i < 4; i++) {
            Task2.cloneFile(filePath);
        }

        Path firstCopyPath = Path.of(dir + File.separator + "Tinkoff Bank Biggest Secret — копия.txt");
        Path secondCopyPath = Path.of(dir + File.separator + "Tinkoff Bank Biggest Secret — копия (2).txt");
        Path thirdCopyPath = Path.of(dir + File.separator + "Tinkoff Bank Biggest Secret — копия (3).txt");
        Path fourthCopyPath = Path.of(dir + File.separator + "Tinkoff Bank Biggest Secret — копия (4).txt");
        Path fifthCopyPath = Path.of(dir + File.separator + "Tinkoff Bank Biggest Secret — копия (5).txt");
        List<Path> list = new ArrayList<>(List.of(
            fifthCopyPath,
            secondCopyPath,
            firstCopyPath,
            thirdCopyPath,
            fourthCopyPath,
            filePath
        ));

        for (Path path : list) {
            if (!path.equals(otherCopy)) {
                try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path.toFile()))) {
                    Assertions.assertEquals(SECRET, bufferedReader.readLine());
                }
            }
        }
    }
}
