package edu.hw8.Task2.ThreadPool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class FixedThreadPool implements ThreadPool {
    private final Thread[] threads;
    private final BlockingQueue<Runnable> blockingQueue = new LinkedBlockingQueue<>();

    private FixedThreadPool(int countThreads) {
        this.threads = new Thread[countThreads];
    }

    @Contract(pure = true)
    public static @NotNull FixedThreadPool create(int countThreads) {
        return new FixedThreadPool(countThreads);
    }

    @Override
    public void start() {
        while (!blockingQueue.isEmpty()) {
            for (int i = 0; i < threads.length; ++i) {
                if (!blockingQueue.isEmpty()) {
                    try {
                        threads[i] = new Thread(blockingQueue.take());
                        threads[i].start();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }

    @Override
    public void execute(Runnable runnable) {
        blockingQueue.add(runnable);
    }

    @Override
    public void close() throws Exception {
        for (Thread thread : threads) {
            thread.join();
        }
    }
}
