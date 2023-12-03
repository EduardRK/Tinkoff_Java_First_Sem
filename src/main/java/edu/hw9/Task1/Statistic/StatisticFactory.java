package edu.hw9.Task1.Statistic;

public abstract class StatisticFactory {
    private StatisticFactory() {
    }

    public static Statistically createStatistic(String metricName, double[] values) {
        return switch (metricName.toLowerCase()) {
            case "min" -> new StatisticMin(values);
            case "max" -> new StatisticMax(values);
            case "average" -> new StatisticAverage(values);
            case "sum" -> new StatisticSum(values);
            default -> throw new IllegalArgumentException("Wrong metric name.");
        };
    }
}
