package edu.hw8.Task2;

import edu.hw8.Task2.ThreadPool.FixedThreadPool;
import edu.hw8.Task2.ThreadPool.ThreadPool;
import java.math.BigDecimal;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class FibonacciCounter {
    private final static BigDecimal[][] START_MATRIX = new BigDecimal[][] {
        new BigDecimal[] {BigDecimal.ONE, BigDecimal.ONE},
        new BigDecimal[] {BigDecimal.ONE, BigDecimal.ZERO}
    };
    private final static BigDecimal[][] IDENTITY_MATRIX = new BigDecimal[][] {
        new BigDecimal[] {BigDecimal.ONE, BigDecimal.ZERO},
        new BigDecimal[] {BigDecimal.ZERO, BigDecimal.ONE}
    };
    private final int countThreads;
    private final ThreadPool threadPool;
    private BigDecimal[][] resultMatrix = IDENTITY_MATRIX;

    public FibonacciCounter(int countThreads) {
        this.countThreads = countThreads;
        threadPool = FixedThreadPool.create(countThreads);
    }

    public BigDecimal calculateNthNumber(long n) {
        resultMatrix = IDENTITY_MATRIX;
        setTasks(n - 1);
        threadPool.start();
        try {
            threadPool.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return resultMatrix[0][0];
    }

    private void setTasks(long n) {
        for (int i = 0; i < countThreads; ++i) {
            threadPool.execute(getDefaultRunnableFunction(n / countThreads));
        }
        threadPool.execute(getRemainsRunnableFunction(n));
    }

    @Contract(pure = true)
    private @NotNull Runnable getDefaultRunnableFunction(long n) {
        return () -> {
            BigDecimal[][] localStartMatrix = START_MATRIX;
            long finalN = n;
            BigDecimal[][] temp = IDENTITY_MATRIX;

            while (finalN > 0) {
                if (finalN % 2 == 0) {
                    localStartMatrix = multiplyMatrices(localStartMatrix, localStartMatrix);
                    finalN /= 2;
                } else {
                    temp = multiplyMatrices(temp, localStartMatrix);
                    --finalN;
                }
            }
            synchronized (this) {
                resultMatrix = multiplyMatrices(resultMatrix, temp);
            }
        };
    }

    @Contract(pure = true)
    private @NotNull Runnable getRemainsRunnableFunction(long n) {
        return getDefaultRunnableFunction(n - ((n / countThreads) * countThreads));
    }

    private BigDecimal[][] multiplyMatrices(BigDecimal[][] left, BigDecimal[][] right) {
        BigDecimal[][] result = new BigDecimal[left.length][right[0].length];
        for (int row = 0; row < result.length; ++row) {
            for (int col = 0; col < result[row].length; ++col) {
                BigDecimal temp = new BigDecimal(0);
                for (int i = 0; i < right.length; i++) {
                    temp = temp.add(left[row][i].multiply(right[i][col]));
                }
                result[row][col] = temp;
            }
        }
        return result;
    }
}
