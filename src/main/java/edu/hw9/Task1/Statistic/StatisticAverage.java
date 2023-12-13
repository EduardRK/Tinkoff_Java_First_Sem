package edu.hw9.Task1.Statistic;

import java.util.Arrays;

public class StatisticAverage extends Statistic {

    public StatisticAverage(double[] values) {
        super(values);
    }

    @Override
    public double getStat() {
        return Arrays.stream(values).sum() / values.length;
    }
}
