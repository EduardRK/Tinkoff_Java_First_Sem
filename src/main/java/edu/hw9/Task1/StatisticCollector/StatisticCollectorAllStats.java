package edu.hw9.Task1.StatisticCollector;

import edu.hw9.Task1.StatisticFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class StatisticCollectorAllStats implements StatisticCollector<Map<String, Map<String, Double>>> {
    private static final List<String> METRICS = new ArrayList<>(List.of("max", "min", "sum", "average"));
    private final ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor();
    private final Map<String, Map<String, Double>> statistic = new ConcurrentHashMap<>();

    @Override
    public void push(String metricName, double[] values) {
        Map<String, Double> map = new ConcurrentHashMap<>();
        for (String metric : METRICS) {
            executorService.submit(() -> {
                map.put(metric, StatisticFactory.createStatistic(metric, values).getStat());
            });
        }
        statistic.put(metricName, map);
    }

    @Override
    public Map<String, Map<String, Double>> getStatistic() {
        return statistic;
    }
}
