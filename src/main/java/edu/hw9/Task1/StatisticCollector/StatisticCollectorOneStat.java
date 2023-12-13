package edu.hw9.Task1.StatisticCollector;

import edu.hw9.Task1.Statistic.Statistically;
import edu.hw9.Task1.StatisticFactory;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class StatisticCollectorOneStat implements StatisticCollector<Double> {
    private final BlockingQueue<Statistically> blockingQueue = new LinkedBlockingQueue<>();

    public StatisticCollectorOneStat() {
    }

    @Override
    public void push(String metricName, double[] values) {
        try {
            blockingQueue.put(StatisticFactory.createStatistic(metricName, values));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Double getStatistic() {
        try {
            return blockingQueue.take().getStat();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
