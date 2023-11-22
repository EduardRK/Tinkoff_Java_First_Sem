package edu.project2.Solver;

import edu.project2.Cell;
import edu.project2.Coordinate;
import edu.project2.Maze;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MazeSolverBFS implements Solver {
    private final Maze maze;

    public MazeSolverBFS(Maze maze) {
        this.maze = maze;
    }

    private void makeStartLengthMap(int[][] lengthMap) {
        for (int[] ints : lengthMap) {
            Arrays.fill(ints, -1);
        }
    }

    private void waveFilling(
        Cell[][] grid,
        int[][] lengthMap,
        List<Cell> toVisit,
        Cell currentCell,
        int waveLvl
    ) {
        int x = currentCell.row();
        int y = currentCell.col();
        if (x + 1 < lengthMap.length && grid[x + 1][y].isPassage() && lengthMap[x + 1][y] == -1) {
            lengthMap[x + 1][y] = waveLvl;
            toVisit.add(grid[x + 1][y]);
        }
        if (x - 1 >= 0 && grid[x - 1][y].isPassage() && lengthMap[x - 1][y] == -1) {
            lengthMap[x - 1][y] = waveLvl;
            toVisit.add(grid[x - 1][y]);
        }
        if (y + 1 < lengthMap[0].length && grid[x][y + 1].isPassage() && lengthMap[x][y + 1] == -1) {
            lengthMap[x][y + 1] = waveLvl;
            toVisit.add(grid[x][y + 1]);
        }
        if (y - 1 >= 0 && grid[x][y - 1].isPassage() && lengthMap[x][y - 1] == -1) {
            lengthMap[x][y - 1] = waveLvl;
            toVisit.add(grid[x][y - 1]);
        }
    }

    private List<Coordinate> makePath(int[][] lengthMap, Coordinate start, Coordinate end) {
        List<Coordinate> path = new ArrayList<>();
        Coordinate currentCell = end;
        path.add(currentCell);

        while (!currentCell.equals(start)) {
            int x = currentCell.x();
            int y = currentCell.y();

            int minWave = lengthMap[x][y];
            Coordinate minWaveCoordinate = end;
            if (x + 1 < lengthMap.length && lengthMap[x + 1][y] != -1 && lengthMap[x + 1][y] <= minWave) {
                minWaveCoordinate = new Coordinate(x + 1, y);
            }
            if (x - 1 >= 0 && lengthMap[x - 1][y] != -1 && lengthMap[x - 1][y] <= minWave) {
                minWaveCoordinate = new Coordinate(x - 1, y);
            }
            if (y + 1 < lengthMap[0].length && lengthMap[x][y + 1] != -1 && lengthMap[x][y + 1] <= minWave) {
                minWaveCoordinate = new Coordinate(x, y + 1);
            }
            if (y - 1 >= 0 && lengthMap[x][y - 1] != -1 && lengthMap[x][y - 1] <= minWave) {
                minWaveCoordinate = new Coordinate(x, y - 1);
            }
            currentCell = minWaveCoordinate;
            path.add(currentCell);
        }
        return path.reversed();
    }

    @Override
    public List<Coordinate> solve(Coordinate start, Coordinate end) {
        if (maze.grid()[start.x()][start.y()].isWall()) {
            throw new IllegalArgumentException("Start is wall");
        }
        if (maze.grid()[end.x()][end.y()].isWall()) {
            throw new IllegalArgumentException("End is wall");
        }

        int[][] lengthMap = new int[maze.height()][maze.width()];
        makeStartLengthMap(lengthMap);

        List<Cell> toVisit = new ArrayList<>();
        lengthMap[start.x()][start.y()] = 0;
        int waveLvl = 1;
        toVisit.add(maze.grid()[start.x()][start.y()]);

        while (!toVisit.isEmpty()) {
            Cell currentCell = toVisit.removeFirst();

            if (currentCell.row() == end.x() && currentCell.col() == end.y()) {
                break;
            }

            waveFilling(maze.grid(), lengthMap, toVisit, currentCell, waveLvl);

            waveLvl++;
        }
        return makePath(lengthMap, start, end);
    }
}
