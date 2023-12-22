package edu.hw9.Task1;

import edu.hw9.Task1.Statistic.StatisticAverage;
import edu.hw9.Task1.Statistic.StatisticMax;
import edu.hw9.Task1.Statistic.StatisticMin;
import edu.hw9.Task1.Statistic.StatisticSum;
import edu.hw9.Task1.Statistic.Statistically;
import org.jetbrains.annotations.NotNull;

public final class StatisticFactory {
    private StatisticFactory() {
    }

    public static Statistically createStatistic(@NotNull String metricName, double[] values) {
        return switch (metricName.toLowerCase()) {
            case "min" -> new StatisticMin(values);
            case "max" -> new StatisticMax(values);
            case "average" -> new StatisticAverage(values);
            case "sum" -> new StatisticSum(values);
            default -> throw new IllegalArgumentException("Wrong metric name.");
        };
    }
}
