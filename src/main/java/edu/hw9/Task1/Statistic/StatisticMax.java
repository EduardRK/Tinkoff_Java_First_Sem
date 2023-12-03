package edu.hw9.Task1.Statistic;

import java.util.Arrays;

public class StatisticMax implements Statistically {
    private final double[] values;

    public StatisticMax(double[] values) {
        this.values = values;
    }

    @Override
    public double getStat() {
        return Arrays.stream(values).max().orElse(0);
    }
}
