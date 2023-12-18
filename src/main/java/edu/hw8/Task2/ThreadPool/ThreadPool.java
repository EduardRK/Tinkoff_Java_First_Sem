package edu.hw8.Task2.ThreadPool;

public interface ThreadPool extends AutoCloseable {
    void start();

    void execute(Runnable runnable);
}
