package edu.project2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public interface Generator {
    Random RANDOM = new Random();

    static Maze generatorPrim(int height, int width) {
        final int maxVisitedCells = ((height + 1) / 2) * ((width + 1) / 2);

        Cell[][] grid = new Cell[height][width];
        Generator.makeStartGrid(grid);

        grid[0][0].createPassage();
        Cell currentCell = grid[0][0];
        ArrayList<Cell> visitedCells = new ArrayList<>(List.of(currentCell));
        ArrayList<Cell> finalVisitedCells = new ArrayList<>();

        while ((visitedCells.size() + finalVisitedCells.size()) != maxVisitedCells) {
            int cellIndex = RANDOM.nextInt(visitedCells.size());
            currentCell = visitedCells.get(cellIndex);
            int xCell = currentCell.row();
            int yCell = currentCell.col();

            ArrayList<Character> directions = new ArrayList<>(List.of('U', 'D', 'R', 'L'));
            while (!directions.isEmpty()) {
                createRandomPassageFromCell(directions, grid, visitedCells, currentCell);
            }

            if ((xCell + 2 >= height || grid[xCell + 2][yCell].isPassage())
                && (xCell - 2 < 0 || grid[xCell - 2][yCell].isPassage())
                && (yCell + 2 >= width || grid[xCell][yCell + 2].isPassage())
                && (yCell - 2 < 0 || grid[xCell][yCell - 2].isPassage())) {

                finalVisitedCells.add(currentCell);
                visitedCells.remove(cellIndex);
            }
        }
        return new Maze(height, width, grid);
    }

    static void makeStartGrid(Cell[][] grid) {
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                grid[i][j] = Cell.createWall(i, j);
            }
        }
    }

    static void createRandomPassageFromCell(
        List<Character> directions,
        Cell[][] grid,
        List<Cell> visitedCells,
        Cell currentCell
    ) {
        int xCell = currentCell.row();
        int yCell = currentCell.col();
        int directionIndex = RANDOM.nextInt(directions.size());

        switch (directions.get(directionIndex)) {
            case 'R':
                if (yCell + 2 < grid[0].length
                    && grid[xCell][yCell + 2].isWall()) {

                    grid[xCell][yCell + 1].createPassage();
                    grid[xCell][yCell + 2].createPassage();
                    visitedCells.add(grid[xCell][yCell + 2]);
                    directions.clear();
                }
                break;
            case 'L':
                if (yCell - 2 >= 0
                    && grid[xCell][yCell - 2].isWall()) {

                    grid[xCell][yCell - 1].createPassage();
                    grid[xCell][yCell - 2].createPassage();
                    visitedCells.add(grid[xCell][yCell - 2]);
                    directions.clear();
                }
                break;
            case 'U':
                if (xCell + 2 < grid.length
                    && grid[xCell + 2][yCell].isWall()) {

                    grid[xCell + 1][yCell].createPassage();
                    grid[xCell + 2][yCell].createPassage();
                    visitedCells.add(grid[xCell + 2][yCell]);
                    directions.clear();
                }
                break;
            case 'D':
                if (xCell - 2 >= 0
                    && grid[xCell - 2][yCell].isWall()) {

                    grid[xCell - 1][yCell].createPassage();
                    grid[xCell - 2][yCell].createPassage();
                    visitedCells.add(grid[xCell - 2][yCell]);
                    directions.clear();
                }
                break;
            default:
                break;
        }

        if (!directions.isEmpty()) {
            directions.remove(directionIndex);
        }
    }
}
