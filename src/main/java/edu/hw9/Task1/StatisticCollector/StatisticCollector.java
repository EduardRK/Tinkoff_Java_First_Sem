package edu.hw9.Task1.StatisticCollector;

public interface StatisticCollector<T> {
    void push(String metricName, double[] values);

    T getStatistic();
}
