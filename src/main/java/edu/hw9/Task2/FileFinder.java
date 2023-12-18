package edu.hw9.Task2;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.function.Predicate;
import org.jetbrains.annotations.NotNull;

public class FileFinder implements Finder<Predicate<File>> {
    private final Path directory;

    public FileFinder(Path path) {
        directory = path;
    }

    @Override
    public List<Path> find(Predicate<File> filter) {
        RecursiveTask<List<Path>> findDirectoriesTask = new FindFilesTask(directory, filter);
        try (ForkJoinPool forkJoinPool = new ForkJoinPool()) {
            return forkJoinPool.invoke(findDirectoriesTask);

        }
    }

    private static class FindFilesTask extends RecursiveTask<List<Path>> {
        private final Path path;
        private final Predicate<File> filePredicate;

        FindFilesTask(Path path, Predicate<File> filePredicate) {
            this.path = path;
            this.filePredicate = filePredicate;
        }

        @Override
        protected @NotNull List<Path> compute() {
            List<Path> filesList = new CopyOnWriteArrayList<>();
            File[] files = path.toFile().listFiles();

            if (files == null) {
                return filesList;
            }

            List<RecursiveTask<List<Path>>> tasks = new ArrayList<>();

            for (File file : files) {
                if (file.isDirectory()) {
                    tasks.add(new FindFilesTask(file.toPath(), filePredicate));
                } else if (filePredicate.test(file)) {
                    filesList.add(file.toPath());
                }
            }

            for (RecursiveTask<List<Path>> task : tasks) {
                task.fork();
            }

            for (RecursiveTask<List<Path>> task : tasks) {
                filesList.addAll(task.join());
            }

            return filesList;
        }
    }
}
