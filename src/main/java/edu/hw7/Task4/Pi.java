package edu.hw7.Task4;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicLong;
import org.jetbrains.annotations.NotNull;

public class Pi {
    private static final int R = 1;
    private static final Coordinate CENTER_OF_THE_CIRCLE = new Coordinate(1, 1);
    private static final double LOWER_BOUND_X = CENTER_OF_THE_CIRCLE.x() - R;
    private static final double UPPER_BOUND_X = CENTER_OF_THE_CIRCLE.x() + R;
    private static final double LOWER_BOUND_Y = CENTER_OF_THE_CIRCLE.y() - R;
    private static final double UPPER_BOUND_Y = CENTER_OF_THE_CIRCLE.y() + R;
    private static final int COEFFICIENT = 4;
    private static final long DEFAULT_ITERATIONS_COUNT = 1_000_000_000;
    private final int countThreads;
    private final long countIterations;
    private double cachePiValue = 0;

    public Pi() {
        this(Runtime.getRuntime().availableProcessors(), DEFAULT_ITERATIONS_COUNT);
    }

    public Pi(int countThreads) {
        this(countThreads, DEFAULT_ITERATIONS_COUNT);
    }

    public Pi(long countIterations) {
        this(Runtime.getRuntime().availableProcessors(), countIterations);
    }

    public Pi(int countThreads, long countIterations) {
        this.countThreads = countThreads;
        this.countIterations = countIterations;
    }

    public double getPi() {
        if (cachePiValue == 0) {
            cachePiValue = countPi();
        }

        return cachePiValue;
    }

    private double countPi() {
        List<Thread> threadList = new ArrayList<>();

        AtomicLong circleCount = new AtomicLong();
        for (int i = 0; i < countThreads; ++i) {
            threadList.add(new Thread(() -> {
                ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
                long localCircleCount = 0;
                for (long j = 0; j < countIterations / countThreads; ++j) {
                    if (isCoordinateInCircle(new Coordinate(
                        threadLocalRandom.nextDouble(LOWER_BOUND_X, UPPER_BOUND_X),
                        threadLocalRandom.nextDouble(LOWER_BOUND_Y, UPPER_BOUND_Y)
                    ))) {
                        localCircleCount++;
                    }
                }
                circleCount.addAndGet(localCircleCount);
            }));
            threadList.getLast().start();
        }

        try {
            for (Thread thread : threadList) {
                thread.join();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return COEFFICIENT * (circleCount.doubleValue() / countIterations);
    }

    private boolean isCoordinateInCircle(@NotNull Coordinate coordinate) {
        return (Math.pow(coordinate.x() - CENTER_OF_THE_CIRCLE.x(), 2)
            + Math.pow(coordinate.y() - CENTER_OF_THE_CIRCLE.y(), 2)) <= Math.pow(R, 2);
    }
}
