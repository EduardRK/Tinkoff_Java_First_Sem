package edu.project2.Generator;

import edu.project2.Cell;
import edu.project2.Maze;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MazeGeneratorPrim implements Generator {
    private final static Random RANDOM = new Random();

    public MazeGeneratorPrim() {
    }

    @Override
    public Maze generator(int height, int width) {
        final int maxVisitedCells = ((height + 1) / 2) * ((width + 1) / 2);

        Cell[][] grid = new Cell[height][width];
        makeStartGrid(grid);

        grid[0][0].createPassage();
        Cell currentCell = grid[0][0];
        List<Cell> visitedCells = new ArrayList<>(List.of(currentCell));
        List<Cell> finalVisitedCells = new ArrayList<>();

        while ((visitedCells.size() + finalVisitedCells.size()) != maxVisitedCells) {
            int cellIndex = RANDOM.nextInt(visitedCells.size());
            currentCell = visitedCells.get(cellIndex);
            int x = currentCell.row();
            int y = currentCell.col();

            ArrayList<Character> directions = new ArrayList<>(List.of('U', 'D', 'R', 'L'));
            while (!directions.isEmpty()) {
                createRandomPassageFromCell(directions, grid, visitedCells, currentCell);
            }

            if ((x + 2 >= height || grid[x + 2][y].isPassage())
                && (x - 2 < 0 || grid[x - 2][y].isPassage())
                && (y + 2 >= width || grid[x][y + 2].isPassage())
                && (y - 2 < 0 || grid[x][y - 2].isPassage())) {

                finalVisitedCells.add(currentCell);
                visitedCells.remove(cellIndex);
            }
        }
        return new Maze(height, width, grid);
    }

    private void makeStartGrid(Cell[][] grid) {
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                grid[i][j] = Cell.createWall(i, j);
            }
        }
    }

    private void createRandomPassageFromCell(
        List<Character> directions,
        Cell[][] grid,
        List<Cell> visitedCells,
        Cell currentCell
    ) {
        int xCell = currentCell.row();
        int yCell = currentCell.col();
        int directionIndex = RANDOM.nextInt(directions.size());

        switch (directions.get(directionIndex)) {
            case 'R' -> {
                if (yCell + 2 < grid[0].length
                    && grid[xCell][yCell + 2].isWall()) {

                    grid[xCell][yCell + 1].createPassage();
                    grid[xCell][yCell + 2].createPassage();
                    visitedCells.add(grid[xCell][yCell + 2]);
                    directions.clear();
                }
            }
            case 'L' -> {
                if (yCell - 2 >= 0
                    && grid[xCell][yCell - 2].isWall()) {

                    grid[xCell][yCell - 1].createPassage();
                    grid[xCell][yCell - 2].createPassage();
                    visitedCells.add(grid[xCell][yCell - 2]);
                    directions.clear();
                }
            }
            case 'U' -> {
                if (xCell + 2 < grid.length
                    && grid[xCell + 2][yCell].isWall()) {

                    grid[xCell + 1][yCell].createPassage();
                    grid[xCell + 2][yCell].createPassage();
                    visitedCells.add(grid[xCell + 2][yCell]);
                    directions.clear();
                }
            }
            case 'D' -> {
                if (xCell - 2 >= 0
                    && grid[xCell - 2][yCell].isWall()) {

                    grid[xCell - 1][yCell].createPassage();
                    grid[xCell - 2][yCell].createPassage();
                    visitedCells.add(grid[xCell - 2][yCell]);
                    directions.clear();
                }
            }
            default -> {
            }
        }

        if (!directions.isEmpty()) {
            directions.remove(directionIndex);
        }
    }
}
