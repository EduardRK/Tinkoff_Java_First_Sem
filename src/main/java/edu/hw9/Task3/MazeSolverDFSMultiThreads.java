package edu.hw9.Task3;

import edu.project2.Coordinate;
import edu.project2.Maze;
import edu.project2.Solver.Solver;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import org.jetbrains.annotations.NotNull;

public class MazeSolverDFSMultiThreads implements Solver {
    private static final List<Character> DIRECTIONS = new CopyOnWriteArrayList<>(List.of('U', 'D', 'R', 'L'));
    private static Maze maze;

    public MazeSolverDFSMultiThreads(Maze maze) {
        MazeSolverDFSMultiThreads.maze = maze;
    }

    @Override
    public List<Coordinate> solve(@NotNull Coordinate start, Coordinate end) {
        if (maze.grid()[start.x()][start.y()].isWall()) {
            throw new IllegalArgumentException("Start is wall");
        }

        if (maze.grid()[end.x()][end.y()].isWall()) {
            throw new IllegalArgumentException("End is wall");
        }

        List<Coordinate> path = new CopyOnWriteArrayList<>();
        List<Coordinate> visited = new CopyOnWriteArrayList<>();

        RecursiveTask<Boolean> recursiveTask = new PathFinderTask(start, end, path, visited);
        try (ForkJoinPool forkJoinPool = new ForkJoinPool()) {
            if (forkJoinPool.invoke(recursiveTask)) {
                forkJoinPool.shutdown();
                return path;
            } else {
                throw new IllegalArgumentException("Can't find path in maze");
            }
        }
    }

    private static class PathFinderTask extends RecursiveTask<Boolean> {
        private final Coordinate coordinate;
        private final Coordinate end;
        private final List<Coordinate> path;
        private final List<Coordinate> visited;

        PathFinderTask(Coordinate coordinate, Coordinate end, List<Coordinate> path, List<Coordinate> visited) {
            this.coordinate = coordinate;
            this.end = end;
            this.path = path;
            this.visited = visited;
        }

        @Override
        protected @NotNull Boolean compute() {
            if (!isValidCoordinate(coordinate)
                || maze.grid()[coordinate.x()][coordinate.y()].isWall()
                || visited.contains(coordinate)) {
                return false;
            }

            List<Coordinate> localPath = new ArrayList<>();
            localPath.add(coordinate);
            visited.add(coordinate);

            if (coordinate.equals(end)) {
                path.add(end);
                return true;
            }

            List<RecursiveTask<Boolean>> tasks = new ArrayList<>();

            for (Character direction : DIRECTIONS) {
                Coordinate nextCoordinate = switch (direction) {
                    case 'U' -> new Coordinate(coordinate.x() + 1, coordinate.y());
                    case 'D' -> new Coordinate(coordinate.x() - 1, coordinate.y());
                    case 'R' -> new Coordinate(coordinate.x(), coordinate.y() + 1);
                    case 'L' -> new Coordinate(coordinate.x(), coordinate.y() - 1);
                    default -> null;
                };
                tasks.add(new PathFinderTask(nextCoordinate, end, path, visited));
            }

            for (RecursiveTask<Boolean> task : tasks) {
                task.fork();
            }

            for (RecursiveTask<Boolean> task : tasks) {
                if (task.join()) {
                    path.addAll(localPath);
                    return true;
                }
            }

            localPath.removeLast();
            return false;
        }

        private boolean isValidCoordinate(@NotNull Coordinate coordinate) {
            return coordinate.x() >= 0 && coordinate.x() < maze.height()
                && coordinate.y() >= 0 && coordinate.y() < maze.width();
        }
    }
}
