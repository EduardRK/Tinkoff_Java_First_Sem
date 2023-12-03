package edu.hw9.Task1.Statistic;

import java.util.Arrays;

public class StatisticMin implements Statistically {
    private final double[] values;

    public StatisticMin(double[] values) {
        this.values = values;
    }

    @Override
    public double getStat() {
        return Arrays.stream(values).min().orElse(0);
    }
}
