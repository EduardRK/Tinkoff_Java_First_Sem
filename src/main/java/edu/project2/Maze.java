package edu.project2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class Maze implements Solver, Render {
    private int height;
    private int width;
    private Cell[][] grid;

    public Maze(int height, int width, Cell[][] grid) {
        this.height = height;
        this.width = width;
        this.grid = grid;
    }

    @Override
    public List<Coordinate> solveAlgorithmLee(Coordinate start, Coordinate end) {
        if (grid[start.x()][start.y()].isWall()) {
            throw new IllegalArgumentException("Start is wall");
        }
        if (grid[end.x()][end.y()].isWall()) {
            throw new IllegalArgumentException("End is wall");
        }

        int[][] lengthMap = new int[this.height][this.width];
        makeStartLengthMap(lengthMap);

        List<Cell> toVisit = new ArrayList<>();
        List<Coordinate> path = new ArrayList<>();
        lengthMap[start.x()][start.y()] = 0;
        int waveLvl = 1;
        toVisit.add(grid[start.x()][start.y()]);

        while (!toVisit.isEmpty()) {
            Cell currentCell = toVisit.remove(0);
            int x = currentCell.row();
            int y = currentCell.col();

            if (currentCell.row() == end.x() && currentCell.col() == end.y()) {
                break;
            }

            waveFilling(grid, lengthMap, toVisit, currentCell, waveLvl);

            waveLvl++;
        }
        return makePath(lengthMap, start, end);
    }

    @Override
    public String render() {
        StringBuilder maze = new StringBuilder();

        maze.append(WALL.repeat(width + 2)).append("\n");
        for (int i = 0; i < height; ++i) {
            maze.append(WALL);
            for (int j = 0; j < width; ++j) {
                if (grid[i][j].isWall()) {
                    maze.append(WALL);
                } else {
                    maze.append(PASSAGE);
                }
            }
            maze.append(WALL).append("\n");
        }
        maze.append(WALL.repeat(width + 2)).append("\n");

        return new String(maze);
    }

    @Override
    public String render(List<Coordinate> path) {
        StringBuilder maze = new StringBuilder();

        maze.append(WALL.repeat(width + 2)).append("\n");
        for (int i = 0; i < height; ++i) {
            maze.append(WALL);
            for (int j = 0; j < width; ++j) {
                if (grid[i][j].isWall()) {
                    maze.append(WALL);
                } else if (path.contains(new Coordinate(i, j))) {
                    maze.append(PATH);
                } else {
                    maze.append(PASSAGE);
                }
            }
            maze.append(WALL).append("\n");
        }
        maze.append(WALL.repeat(width + 2)).append("\n");

        return new String(maze);
    }

    private static void makeStartLengthMap(int[][] lengthMap) {
        for (int[] ints : lengthMap) {
            Arrays.fill(ints, -1);
        }
    }

    private static void waveFilling(
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

    private static List<Coordinate> makePath(int[][] lengthMap, Coordinate start, Coordinate end) {
        ArrayList<Coordinate> path = new ArrayList<>();
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
}
