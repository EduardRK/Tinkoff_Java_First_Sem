package edu.hw9.Task1.Statistic;

import java.util.Arrays;

public class StatisticSum implements Statistically {
    private final double[] values;

    public StatisticSum(double[] values) {
        this.values = values;
    }

    @Override
    public double getStat() {
        return Arrays.stream(values).sum();
    }
}
