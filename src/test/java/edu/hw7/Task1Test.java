package edu.hw7;

import edu.hw7.Task1.Counter;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class Task1Test {
    @Nested
    @DisplayName("One thread")
    class OneThread {
        @Test
        @DisplayName("One increment")
        public void oneIncrement() throws InterruptedException {
            Counter counter = new Counter();
            Thread thread = new Thread(counter::increment);
            thread.start();
            thread.join();

            Assertions.assertEquals(1, counter.getCounter().intValue());
        }

        @Test
        @DisplayName("Multiple increment")
        public void multipleIncrement() throws InterruptedException {
            final int countIncrement = 10;
            Counter counter = new Counter();
            Thread thread = new Thread(() -> {
                for (int i = 0; i < countIncrement; ++i) {
                    counter.increment();
                }
            });
            thread.start();
            thread.join();

            Assertions.assertEquals(countIncrement, counter.getCounter().intValue());
        }
    }

    @Nested
    @DisplayName("Multiple threads")
    class MultipleThreads {
        @Test
        @DisplayName("One increment")
        public void oneIncrement() throws InterruptedException {
            final int countThreads = Runtime.getRuntime().availableProcessors();

            Counter counter = new Counter();
            List<Thread> threadList = new ArrayList<>();

            for (int i = 0; i < countThreads; ++i) {
                threadList.add(new Thread(counter::increment));
                threadList.getLast().start();
            }

            for (Thread thread : threadList) {
                thread.join();
            }

            Assertions.assertEquals(countThreads, counter.getCounter().intValue());
        }

        @Test
        @DisplayName("Multiple increment")
        public void multipleIncrement() throws InterruptedException {
            final int countThreads = 10;
            final int countIncrements = 30;

            Counter counter = new Counter();
            List<Thread> threadList = new ArrayList<>();

            for (int i = 0; i < countThreads; ++i) {
                threadList.add(new Thread(() -> {
                    for (int j = 0; j < countIncrements; ++j) {
                        counter.increment();
                    }
                }));
                threadList.getLast().start();
            }

            for (Thread thread : threadList) {
                thread.join();
            }

            Assertions.assertEquals(countThreads * countIncrements, counter.getCounter().intValue());
        }
    }
}
