package edu.hw6;

import edu.hw6.Task4.CompositionOutputStreams;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Task4Test {
    @Test
    @DisplayName("Write in file (File exist)")
    public void writeInFileExist() {
        Path path = Path.of("src/main/resources/hw6_TestsDirectory/Task4Test/File.txt");
        String string = "Programming is learned by writing programs. ― Brian Kernighan";

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path.toFile()))) {
            Assertions.assertNull(bufferedReader.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path.toFile()))) {
            CompositionOutputStreams.fileWrite(path, string);
            Assertions.assertEquals(string, bufferedReader.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path.toFile()))) {
            bufferedWriter.write("");
            bufferedWriter.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @DisplayName("Write in file (File not exist)")
    public void writeInFileNotExist() throws IOException {
        Path path = Path.of("src/main/resources/hw6_TestsDirectory/Task4Test/File2.txt");
        String string = "Programming is learned by writing programs. ― Brian Kernighan";

        Assertions.assertTrue(Files.notExists(path));

        CompositionOutputStreams.fileWrite(path, string);
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path.toFile()))) {
            Assertions.assertTrue(Files.exists(path));
            Assertions.assertEquals(string, bufferedReader.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Files.delete(path);
    }
}
