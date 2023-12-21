package edu.hw6.Task1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Objects;
import java.util.function.Predicate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;

public class DirectoryManager implements Directory {
    private final static Logger LOGGER = LogManager.getLogger();
    private final File directory;

    public DirectoryManager(String dirName) {
        directory = new File(dirName);
        directory.mkdirs();
    }

    @Override
    public String readFile(Path path) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path.toFile()))) {
            return bufferedReader.readLine();
        } catch (IOException e) {
            LOGGER.info("Read error: " + e);
            return null;
        }
    }

    @Override
    public void writeFile(@NotNull Path path, String string) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(
            new FileWriter(path.toFile()))
        ) {
            bufferedWriter.write(path.getFileName() + ":" + string);
        } catch (IOException e) {
            LOGGER.info("Write error: " + e);
        }
    }

    @Override
    public void deleteFile(String fileName) {
        try {
            Files.delete(Path.of(directory + File.separator + fileName));
        } catch (IOException e) {
            LOGGER.info("Delete error: " + e);
        }
    }

    @Override
    public void clearDirectory() {
        Arrays.stream(Objects.requireNonNull(directory.listFiles()))
            .filter(Predicate.not(File::isDirectory))
            .forEach(File::delete);
    }
}
