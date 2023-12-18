package edu.hw7;

import edu.hw7.Task4.PiCounter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class Task4Test {
    @Nested
    @DisplayName("Count pi one thread")
    class oneThread {
        private final static int COUNT_THREADS = 1;

        @Test
        @DisplayName("10_000_000 simulations")
        public void tenMillionsSimulations() {
            double pi = PiCounter.countPi(10_000_000, COUNT_THREADS);
            Assertions.assertTrue(3.14 - 0.15 <= pi && 3.14 + 0.15 >= pi);
        }

        @Test
        @DisplayName("100_000_000 simulations")
        public void hundredMillionsSimulations() {
            double pi = PiCounter.countPi(100_000_000, COUNT_THREADS);
            Assertions.assertTrue(3.14 - 0.12 <= pi && 3.14 + 0.12 >= pi);
        }

        @Test
        @DisplayName("1_000_000_000 simulations")
        public void oneBillionSimulations() {
            double pi = PiCounter.countPi(1_000_000_000, COUNT_THREADS);
            Assertions.assertTrue(3.14 - 0.10 <= pi && 3.14 + 0.10 >= pi);
        }
    }

    @Nested
    @DisplayName("Count pi multi thread")
    class multiThread {
        private final static int COUNT_THREADS = 12;

        @Test
        @DisplayName("10_000_000 simulations")
        public void tenMillionsSimulations() {
            double pi = PiCounter.countPi(10_000_000, COUNT_THREADS);
            Assertions.assertTrue(3.14 - 0.15 <= pi && 3.14 + 0.15 >= pi);
        }

        @Test
        @DisplayName("100_000_000 simulations")
        public void hundredMillionsSimulations() {
            double pi = PiCounter.countPi(100_000_000, COUNT_THREADS);
            Assertions.assertTrue(3.14 - 0.12 <= pi && 3.14 + 0.12 >= pi);
        }

        @Test
        @DisplayName("1_000_000_000 simulations")
        public void oneBillionSimulations() {
            double pi = PiCounter.countPi(1_000_000_000, COUNT_THREADS);
            Assertions.assertTrue(3.14 - 0.10 <= pi && 3.14 + 0.10 >= pi);
        }
    }
}
