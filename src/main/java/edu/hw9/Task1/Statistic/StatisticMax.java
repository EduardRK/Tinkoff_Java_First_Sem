package edu.hw9.Task1.Statistic;

import java.util.Arrays;

public class StatisticMax extends Statistic {

    public StatisticMax(double[] values) {
        super(values);
    }

    @Override
    public double getStat() {
        return Arrays.stream(values).max().orElse(0);
    }
}
