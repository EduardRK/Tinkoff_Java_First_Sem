package edu.hw7;

import edu.hw7.Task4.PiCounter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class Task4Test {
    @Nested
    @DisplayName("Count pi one thread")
    class oneThread {
        private final static int COUNT_THREADS = 1;

        @ParameterizedTest
        @CsvSource(value = {
            "10_000_000",
            "100_000_000",
            "1_000_000_000"
        })
        @DisplayName("Test pi counting")
        public void tenMillionsSimulations(long simulations) {
            double pi = PiCounter.countPi(simulations, COUNT_THREADS);
            Assertions.assertTrue(3.14 - 0.15 <= pi && 3.14 + 0.15 >= pi);
        }
    }

    @Nested
    @DisplayName("Count pi multi thread")
    class multiThread {
        private final static int COUNT_THREADS = Runtime.getRuntime().availableProcessors();

        @ParameterizedTest
        @CsvSource(value = {
            "10_000_000",
            "100_000_000",
            "1_000_000_000"
        })
        @DisplayName("Test pi counting")
        public void tenMillionsSimulations(long simulations) {
            double pi = PiCounter.countPi(simulations, COUNT_THREADS);
            Assertions.assertTrue(3.14 - 0.15 <= pi && 3.14 + 0.15 >= pi);
        }
    }
}
