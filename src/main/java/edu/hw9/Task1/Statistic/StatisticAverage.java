package edu.hw9.Task1.Statistic;

import java.util.Arrays;

public class StatisticAverage implements Statistically {
    private final double[] values;

    public StatisticAverage(double[] values) {
        this.values = values;
    }

    @Override
    public double getStat() {
        return Arrays.stream(values).sum() / values.length;
    }
}
