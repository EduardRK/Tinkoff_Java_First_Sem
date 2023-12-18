package edu.hw7.Task4;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicLong;

public final class PiCounter {
    private static final int R = 1;
    private static final Coordinate CENTER_OF_THE_CIRCLE = new Coordinate(1, 1);
    private static final double LOWER_BOUND_X = CENTER_OF_THE_CIRCLE.x() - R;
    private static final double UPPER_BOUND_X = CENTER_OF_THE_CIRCLE.x() + R;
    private static final double LOWER_BOUND_Y = CENTER_OF_THE_CIRCLE.y() - R;
    private static final double UPPER_BOUND_Y = CENTER_OF_THE_CIRCLE.y() + R;
    private static final int COEFFICIENT = 4;

    private PiCounter() {
    }

    public static double countPi(long simulations, int countThread) {
        List<Thread> threadList = new ArrayList<>();

        AtomicLong circleCount = new AtomicLong();
        for (int i = 0; i < countThread; ++i) {
            threadList.add(new Thread(() -> {
                ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
                long localCircleCount = 0;
                for (long j = 0; j < simulations / countThread; ++j) {
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

        return COEFFICIENT * (circleCount.doubleValue() / simulations);
    }

    private static boolean isCoordinateInCircle(Coordinate coordinate) {
        return (Math.pow(coordinate.x() - CENTER_OF_THE_CIRCLE.x(), 2)
            + Math.pow(coordinate.y() - CENTER_OF_THE_CIRCLE.y(), 2)) <= Math.pow(R, 2);
    }
}
