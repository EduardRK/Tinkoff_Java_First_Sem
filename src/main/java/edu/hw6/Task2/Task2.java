package edu.hw6.Task2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;

public final class Task2 {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final int BUFFER_SIZE = 2048;

    private Task2() {
    }

    public static void cloneFile(@NotNull Path path) {
        Path directoryPath = path.getParent();
        if (Files.notExists(path)) {
            createNewFile(path);
            return;
        }
        File[] files = directoryPath.toFile().listFiles();

        int currentCopyIndex = 0;
        if (files != null) {
            for (File ignored : files) {
                if (Files.notExists(createCopyPath(path, currentCopyIndex))) {
                    break;
                }
                currentCopyIndex++;
            }

            Path copyPath = createCopyPath(path, currentCopyIndex);
            createNewFile(copyPath);
            copyFileContent(path, copyPath);

        } else {
            createNewFile(path);
        }
    }

    private static void copyFileContent(Path source, Path target) {
        try (InputStream is = new FileInputStream(source.toFile());
             OutputStream os = new FileOutputStream(target.toFile())) {
            byte[] buffer = new byte[BUFFER_SIZE];
            int len;
            while ((len = is.read(buffer)) != -1) {
                os.write(buffer, 0, len);
            }
        } catch (IOException e) {
            LOGGER.info("Copy error: " + e);
        }
    }

    private static Path createCopyPath(Path path, int currentCopyIndex) {
        if (currentCopyIndex == 0) {
            return path;
        } else if (currentCopyIndex == 1) {
            return Path.of(
                path.getParent() + File.separator + getFileName(path) + " — копия" + "." + getFileExtension(path)
            );
        } else {
            return Path.of(
                path.getParent() + File.separator + getFileName(path) + " — копия " + "(" + currentCopyIndex + ")"
                    + "." + getFileExtension(path)
            );
        }
    }

    private static void createNewFile(Path path) {
        try {
            new File(String.valueOf(path)).createNewFile();
        } catch (IOException e) {
            LOGGER.info("Create error: " + e);
        }
    }

    private static @NotNull String getFileName(@NotNull Path path) {
        String fileName = String.valueOf(path.getFileName());
        return fileName.substring(0, fileName.lastIndexOf('.'));
    }

    private static @NotNull String getFileExtension(@NotNull Path path) {
        String fileName = String.valueOf(path.getFileName());
        return fileName.substring(fileName.lastIndexOf('.') + 1);
    }
}
