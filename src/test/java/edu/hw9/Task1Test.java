package edu.hw9;

import edu.hw9.Task1.StatisticCollector;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Task1Test {
    @Test
    @DisplayName("Test race condition")
    public void raceConditionTest() {
        ExecutorService executorService1 = Executors.newVirtualThreadPerTaskExecutor();
        ExecutorService executorService2 = Executors.newVirtualThreadPerTaskExecutor();
        List<String> metrics = new ArrayList<>(List.of("sum", "min", "max", "average"));
        StatisticCollector collector = new StatisticCollector();
        List<Double> resultStats = new CopyOnWriteArrayList<>();

        for (int i = 0; i < 1_000; ++i) {
            executorService1.submit(() -> {
                ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
                collector.push(metrics.get(threadLocalRandom.nextInt(0, metrics.size())), getRandomValues());
            });
            executorService2.submit(() -> {
                resultStats.add(collector.getStatistic());
            });
        }
        executorService1.close();
        executorService2.close();

        Assertions.assertEquals(resultStats.size(), 1_000);
    }

    @Test
    @DisplayName("Test stats")
    public void statsTest() {
        ExecutorService executorService1 = Executors.newVirtualThreadPerTaskExecutor();
        ExecutorService executorService2 = Executors.newVirtualThreadPerTaskExecutor();

        List<String> metrics = new ArrayList<>(List.of("sum", "min", "max", "average"));
        double[] data = new double[] {-1, 1, 0, 0, 0.25, 1, 100, 120, 14.5, -191};

        StatisticCollector collector = new StatisticCollector();
        List<Double> resultStats = new CopyOnWriteArrayList<>();

        for (String string : metrics) {
            executorService1.submit(() -> {
                collector.push(string, data);
            });
            executorService2.submit(() -> {
                resultStats.add(collector.getStatistic());
            });
        }
        executorService1.close();
        executorService2.close();

        resultStats.sort(Comparator.naturalOrder());
        List<Double> expected = new ArrayList<>(List.of(-191D, 4.475, 44.75, 120D));
        Assertions.assertEquals(expected, resultStats);
    }

    private double[] getRandomValues() {
        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
        double[] values = new double[threadLocalRandom.nextInt(1_000)];
        for (int i = 0; i < values.length; ++i) {
            values[i] = threadLocalRandom.nextDouble(-100, 100);
        }
        return values;
    }
}
