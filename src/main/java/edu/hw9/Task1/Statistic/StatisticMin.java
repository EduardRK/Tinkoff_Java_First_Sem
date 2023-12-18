package edu.hw9.Task1.Statistic;

import java.util.Arrays;

public class StatisticMin extends Statistic {
    public StatisticMin(double[] values) {
        super(values);
    }

    @Override
    public double getStat() {
        return Arrays.stream(values).min().orElse(0);
    }
}
