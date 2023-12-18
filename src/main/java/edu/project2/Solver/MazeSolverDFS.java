package edu.project2.Solver;

import edu.project2.Coordinate;
import edu.project2.Maze;
import java.util.ArrayList;
import java.util.List;

public class MazeSolverDFS implements Solver {
    private final static List<Character> DIRECTIONS = new ArrayList<>(List.of('U', 'D', 'R', 'L'));
    private final Maze maze;

    public MazeSolverDFS(Maze maze) {
        this.maze = maze;
    }

    @Override
    public List<Coordinate> solve(Coordinate start, Coordinate end) {
        if (maze.grid()[start.x()][start.y()].isWall()) {
            throw new IllegalArgumentException("Start is wall");
        }

        if (maze.grid()[end.x()][end.y()].isWall()) {
            throw new IllegalArgumentException("End is wall");
        }

        List<Coordinate> path = new ArrayList<>();
        List<Coordinate> visited = new ArrayList<>();

        if (explore(start, end, path, visited)) {
            return path;
        } else {
            throw new IllegalArgumentException("Can't find path in maze");
        }
    }

    private boolean explore(Coordinate coordinate, Coordinate end, List<Coordinate> path, List<Coordinate> visited) {
        if (!isValidCoordinate(coordinate)
            || maze.grid()[coordinate.x()][coordinate.y()].isWall()
            || visited.contains(coordinate)) {
            return false;
        }
        path.add(coordinate);
        visited.add(coordinate);

        if (coordinate.equals(end)) {
            return true;
        }

        for (Character direction : DIRECTIONS) {
            Coordinate nextCoordinate = switch (direction) {
                case 'U' -> new Coordinate(coordinate.x() + 1, coordinate.y());
                case 'D' -> new Coordinate(coordinate.x() - 1, coordinate.y());
                case 'R' -> new Coordinate(coordinate.x(), coordinate.y() + 1);
                case 'L' -> new Coordinate(coordinate.x(), coordinate.y() - 1);
                default -> null;
            };
            if (explore(nextCoordinate, end, path, visited)) {
                return true;
            }
        }
        path.removeLast();
        return false;
    }

    private boolean isValidCoordinate(Coordinate coordinate) {
        return coordinate.x() >= 0 && coordinate.x() < maze.height()
            && coordinate.y() >= 0 && coordinate.y() < maze.width();
    }
}
