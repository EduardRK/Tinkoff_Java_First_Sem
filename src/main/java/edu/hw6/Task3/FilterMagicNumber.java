package edu.hw6.Task3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FilterMagicNumber implements AbstractFilter {
    private static final int BASE_HEXADECIMAL = 16;
    private final int[] magicNumbers;

    public FilterMagicNumber(int... magicNumbers) {
        this.magicNumbers = magicNumbers;
    }

    @Override
    public boolean accept(Path entry) throws IOException {
        byte[] bytes = Files.readAllBytes(entry);
        if (bytes.length < magicNumbers.length) {
            return false;
        }
        for (int i = 0; i < magicNumbers.length; ++i) {
            if (Integer.parseInt(String.format("%02x", bytes[i]), BASE_HEXADECIMAL) != magicNumbers[i]) {
                return false;
            }
        }
        return true;
    }
}
