package edu.hw9.Task2;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import org.jetbrains.annotations.NotNull;

public class DirectoryFinder implements Finder<Integer> {
    private final Path directoryPath;

    public DirectoryFinder(Path path) {
        directoryPath = path;
    }

    @Override
    public List<Path> find(Integer countFiles) {
        RecursiveTask<List<Path>> findDirectoriesTask = new FindDirectoriesTask(directoryPath, countFiles);
        try (ForkJoinPool forkJoinPool = new ForkJoinPool()) {
            return forkJoinPool.invoke(findDirectoriesTask);
        }
    }

    private static class FindDirectoriesTask extends RecursiveTask<List<Path>> {
        private final Path path;
        private final int n;

        FindDirectoriesTask(Path path, int n) {
            this.path = path;
            this.n = n;
        }

        @Override
        protected @NotNull List<Path> compute() {
            List<Path> directiriesList = new CopyOnWriteArrayList<>();
            File[] files = path.toFile().listFiles();

            if (files == null) {
                return directiriesList;
            }

            List<RecursiveTask<List<Path>>> tasks = new ArrayList<>();

            int counterFiles = 0;
            for (File file : files) {
                if (file.isDirectory()) {
                    tasks.add(new FindDirectoriesTask(file.toPath(), n));
                } else {
                    counterFiles++;
                }
            }

            if (counterFiles > n) {
                directiriesList.add(path);
            }

            for (RecursiveTask<List<Path>> task : tasks) {
                task.fork();
            }

            for (RecursiveTask<List<Path>> task : tasks) {
                directiriesList.addAll(task.join());
            }

            return directiriesList;
        }
    }

}
