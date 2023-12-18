package edu.hw10;

import edu.hw10.Task2.CacheProxy;
import edu.hw10.Task2.Calculators.CacheCalculator;
import edu.hw10.Task2.Calculators.CacheFibCalculator;
import edu.hw10.Task2.Calculators.NonCacheCalculator;
import edu.hw10.Task2.Calculators.NonCacheFibCalculator;
import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

public class Task2Test {
    @Test
    @DisplayName("Test file cache")
    public void fileCache(@TempDir Path path) {
        CacheCalculator cacheCalculator = (CacheCalculator) CacheProxy.create(new CacheFibCalculator(), path);
        Assertions.assertEquals(10, cacheCalculator.calculate(10));
        Assertions.assertEquals(20, cacheCalculator.calculate(20));
        Assertions.assertEquals(30, cacheCalculator.calculate(30));
        Assertions.assertEquals(40, cacheCalculator.calculate(40));

        List<File> fileList = new ArrayList<>(List.of(
            Path.of(path + File.separator + "calculate" + "_1" + ".cache").toFile(),
            Path.of(path + File.separator + "calculate" + "_2" + ".cache").toFile(),
            Path.of(path + File.separator + "calculate" + "_3" + ".cache").toFile(),
            Path.of(path + File.separator + "calculate" + "_4" + ".cache").toFile()
        ));
        Set<File> fileSet = new HashSet<>(Set.of(Objects.requireNonNull(path.toFile().listFiles())));
        Assertions.assertTrue(fileSet.containsAll(fileList));
    }

    @Test
    @DisplayName("Test memoru cache")
    public void memoryCache() {
        NonCacheCalculator nonCacheCalculator = (NonCacheCalculator) CacheProxy.create(new NonCacheFibCalculator());
        Assertions.assertEquals(10, nonCacheCalculator.calculate(10));
        Assertions.assertEquals(20, nonCacheCalculator.calculate(20));
        Assertions.assertEquals(30, nonCacheCalculator.calculate(30));
        Assertions.assertEquals(40, nonCacheCalculator.calculate(40));
    }
}
