package edu.hw6.Task4;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.CRC32;
import java.util.zip.CheckedOutputStream;
import java.util.zip.Checksum;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;

public final class CompositionOutputStreams {
    private static final Logger LOGGER = LogManager.getLogger();

    private CompositionOutputStreams() {
    }

    public static void fileWrite(Path path, @NotNull String string) throws IOException {
        try (OutputStream outputStream = Files.newOutputStream(path)) {
            Checksum checksum = new CRC32();
            checksum.update(string.getBytes());

            CheckedOutputStream checkedOutputStream = new CheckedOutputStream(outputStream, checksum);

            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(checkedOutputStream);

            OutputStreamWriter outputStreamWriter =
                new OutputStreamWriter(bufferedOutputStream, StandardCharsets.UTF_8);

            try (PrintWriter printWriter = new PrintWriter(outputStreamWriter)) {
                printWriter.write(string);
                printWriter.flush();

                checkedOutputStream.close();
                bufferedOutputStream.close();
                outputStreamWriter.close();
            }
        } catch (IOException e) {
            LOGGER.info("Write error: " + e);
            throw e;
        }
    }
}
