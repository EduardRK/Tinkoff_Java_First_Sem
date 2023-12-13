package edu.hw9.Task1.Statistic;

import java.util.Arrays;

public class StatisticSum extends Statistic {

    public StatisticSum(double[] values) {
        super(values);
    }

    @Override
    public double getStat() {
        return Arrays.stream(values).sum();
    }
}
