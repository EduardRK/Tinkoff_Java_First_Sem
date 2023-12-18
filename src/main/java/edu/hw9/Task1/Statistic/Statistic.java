package edu.hw9.Task1.Statistic;

public abstract class Statistic implements Statistically {
    protected final double[] values;

    protected Statistic(double[] values) {
        this.values = values;
    }
}
