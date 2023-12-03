package edu.hw9.Task1;

import edu.hw9.Task1.Statistic.StatisticFactory;
import edu.hw9.Task1.Statistic.Statistically;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class StatisticCollector {
    private final BlockingQueue<Statistically> blockingQueue = new LinkedBlockingQueue<>();

    public StatisticCollector() {
    }

    public synchronized void push(String metricName, double[] values) {
        try {
            blockingQueue.put(StatisticFactory.createStatistic(metricName, values));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public double getStatistic() {
        try {
            return blockingQueue.take().getStat();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
