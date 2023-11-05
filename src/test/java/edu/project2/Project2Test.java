package edu.project2;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Project2Test {
    @Test
    @DisplayName("Render maze")
    public void renderMaze() {
        Cell[][] grid = new Cell[5][5];
        grid[0][0] = new Cell(0, 0, Cell.Type.PASSAGE);
        grid[0][1] = new Cell(0, 1, Cell.Type.PASSAGE);
        grid[0][2] = new Cell(0, 2, Cell.Type.PASSAGE);
        grid[0][3] = new Cell(0, 3, Cell.Type.PASSAGE);
        grid[0][4] = new Cell(0, 4, Cell.Type.PASSAGE);

        grid[1][0] = new Cell(1, 0, Cell.Type.PASSAGE);
        grid[1][1] = new Cell(1, 1, Cell.Type.WALL);
        grid[1][2] = new Cell(1, 2, Cell.Type.WALL);
        grid[1][3] = new Cell(1, 3, Cell.Type.WALL);
        grid[1][4] = new Cell(1, 4, Cell.Type.WALL);

        grid[2][0] = new Cell(2, 0, Cell.Type.PASSAGE);
        grid[2][1] = new Cell(2, 1, Cell.Type.PASSAGE);
        grid[2][2] = new Cell(2, 2, Cell.Type.PASSAGE);
        grid[2][3] = new Cell(2, 3, Cell.Type.PASSAGE);
        grid[2][4] = new Cell(2, 4, Cell.Type.PASSAGE);

        grid[3][0] = new Cell(3, 0, Cell.Type.PASSAGE);
        grid[3][1] = new Cell(3, 1, Cell.Type.WALL);
        grid[3][2] = new Cell(3, 2, Cell.Type.WALL);
        grid[3][3] = new Cell(3, 3, Cell.Type.WALL);
        grid[3][4] = new Cell(3, 4, Cell.Type.WALL);

        grid[4][0] = new Cell(4, 0, Cell.Type.PASSAGE);
        grid[4][1] = new Cell(4, 1, Cell.Type.PASSAGE);
        grid[4][2] = new Cell(4, 2, Cell.Type.PASSAGE);
        grid[4][3] = new Cell(4, 3, Cell.Type.PASSAGE);
        grid[4][4] = new Cell(4, 4, Cell.Type.PASSAGE);

        Maze maze = new Maze(5, 5, grid);
        String actual = maze.render();
        String expected = """
            #####################
            ###               ###
            ###   ###############
            ###               ###
            ###   ###############
            ###               ###
            #####################
            """;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Find path")
    public void findPath() {
        Cell[][] grid = new Cell[5][5];
        grid[0][0] = new Cell(0, 0, Cell.Type.PASSAGE);
        grid[0][1] = new Cell(0, 1, Cell.Type.PASSAGE);
        grid[0][2] = new Cell(0, 2, Cell.Type.PASSAGE);
        grid[0][3] = new Cell(0, 3, Cell.Type.PASSAGE);
        grid[0][4] = new Cell(0, 4, Cell.Type.PASSAGE);

        grid[1][0] = new Cell(1, 0, Cell.Type.PASSAGE);
        grid[1][1] = new Cell(1, 1, Cell.Type.WALL);
        grid[1][2] = new Cell(1, 2, Cell.Type.WALL);
        grid[1][3] = new Cell(1, 3, Cell.Type.WALL);
        grid[1][4] = new Cell(1, 4, Cell.Type.WALL);

        grid[2][0] = new Cell(2, 0, Cell.Type.PASSAGE);
        grid[2][1] = new Cell(2, 1, Cell.Type.PASSAGE);
        grid[2][2] = new Cell(2, 2, Cell.Type.PASSAGE);
        grid[2][3] = new Cell(2, 3, Cell.Type.PASSAGE);
        grid[2][4] = new Cell(2, 4, Cell.Type.PASSAGE);

        grid[3][0] = new Cell(3, 0, Cell.Type.PASSAGE);
        grid[3][1] = new Cell(3, 1, Cell.Type.WALL);
        grid[3][2] = new Cell(3, 2, Cell.Type.WALL);
        grid[3][3] = new Cell(3, 3, Cell.Type.WALL);
        grid[3][4] = new Cell(3, 4, Cell.Type.WALL);

        grid[4][0] = new Cell(4, 0, Cell.Type.PASSAGE);
        grid[4][1] = new Cell(4, 1, Cell.Type.PASSAGE);
        grid[4][2] = new Cell(4, 2, Cell.Type.PASSAGE);
        grid[4][3] = new Cell(4, 3, Cell.Type.PASSAGE);
        grid[4][4] = new Cell(4, 4, Cell.Type.PASSAGE);

        Maze maze = new Maze(5, 5, grid);
        List<Coordinate> actual = maze.solveAlgorithmLee(new Coordinate(0, 0), new Coordinate(4, 4));
        List<Coordinate> expected = new ArrayList<>() {{
            add(new Coordinate(0, 0));
            add(new Coordinate(1, 0));
            add(new Coordinate(2, 0));
            add(new Coordinate(3, 0));
            add(new Coordinate(4, 0));
            add(new Coordinate(4, 1));
            add(new Coordinate(4, 2));
            add(new Coordinate(4, 3));
            add(new Coordinate(4, 4));
        }};

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Find path start = end")
    public void findPathStartEqualsEnd() {
        Cell[][] grid = new Cell[5][5];
        grid[0][0] = new Cell(0, 0, Cell.Type.PASSAGE);
        grid[0][1] = new Cell(0, 1, Cell.Type.PASSAGE);
        grid[0][2] = new Cell(0, 2, Cell.Type.PASSAGE);
        grid[0][3] = new Cell(0, 3, Cell.Type.PASSAGE);
        grid[0][4] = new Cell(0, 4, Cell.Type.PASSAGE);

        grid[1][0] = new Cell(1, 0, Cell.Type.PASSAGE);
        grid[1][1] = new Cell(1, 1, Cell.Type.WALL);
        grid[1][2] = new Cell(1, 2, Cell.Type.WALL);
        grid[1][3] = new Cell(1, 3, Cell.Type.WALL);
        grid[1][4] = new Cell(1, 4, Cell.Type.WALL);

        grid[2][0] = new Cell(2, 0, Cell.Type.PASSAGE);
        grid[2][1] = new Cell(2, 1, Cell.Type.PASSAGE);
        grid[2][2] = new Cell(2, 2, Cell.Type.PASSAGE);
        grid[2][3] = new Cell(2, 3, Cell.Type.PASSAGE);
        grid[2][4] = new Cell(2, 4, Cell.Type.PASSAGE);

        grid[3][0] = new Cell(3, 0, Cell.Type.PASSAGE);
        grid[3][1] = new Cell(3, 1, Cell.Type.WALL);
        grid[3][2] = new Cell(3, 2, Cell.Type.WALL);
        grid[3][3] = new Cell(3, 3, Cell.Type.WALL);
        grid[3][4] = new Cell(3, 4, Cell.Type.WALL);

        grid[4][0] = new Cell(4, 0, Cell.Type.PASSAGE);
        grid[4][1] = new Cell(4, 1, Cell.Type.PASSAGE);
        grid[4][2] = new Cell(4, 2, Cell.Type.PASSAGE);
        grid[4][3] = new Cell(4, 3, Cell.Type.PASSAGE);
        grid[4][4] = new Cell(4, 4, Cell.Type.PASSAGE);

        Maze maze = new Maze(5, 5, grid);
        List<Coordinate> actual = maze.solveAlgorithmLee(new Coordinate(0, 0), new Coordinate(0, 0));
        List<Coordinate> expected = new ArrayList<>() {{
            add(new Coordinate(0, 0));
        }};

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Render path")
    public void renderPath() {
        Cell[][] grid = new Cell[5][5];
        grid[0][0] = new Cell(0, 0, Cell.Type.PASSAGE);
        grid[0][1] = new Cell(0, 1, Cell.Type.PASSAGE);
        grid[0][2] = new Cell(0, 2, Cell.Type.PASSAGE);
        grid[0][3] = new Cell(0, 3, Cell.Type.PASSAGE);
        grid[0][4] = new Cell(0, 4, Cell.Type.PASSAGE);

        grid[1][0] = new Cell(1, 0, Cell.Type.PASSAGE);
        grid[1][1] = new Cell(1, 1, Cell.Type.WALL);
        grid[1][2] = new Cell(1, 2, Cell.Type.WALL);
        grid[1][3] = new Cell(1, 3, Cell.Type.WALL);
        grid[1][4] = new Cell(1, 4, Cell.Type.WALL);

        grid[2][0] = new Cell(2, 0, Cell.Type.PASSAGE);
        grid[2][1] = new Cell(2, 1, Cell.Type.PASSAGE);
        grid[2][2] = new Cell(2, 2, Cell.Type.PASSAGE);
        grid[2][3] = new Cell(2, 3, Cell.Type.PASSAGE);
        grid[2][4] = new Cell(2, 4, Cell.Type.PASSAGE);

        grid[3][0] = new Cell(3, 0, Cell.Type.PASSAGE);
        grid[3][1] = new Cell(3, 1, Cell.Type.WALL);
        grid[3][2] = new Cell(3, 2, Cell.Type.WALL);
        grid[3][3] = new Cell(3, 3, Cell.Type.WALL);
        grid[3][4] = new Cell(3, 4, Cell.Type.WALL);

        grid[4][0] = new Cell(4, 0, Cell.Type.PASSAGE);
        grid[4][1] = new Cell(4, 1, Cell.Type.PASSAGE);
        grid[4][2] = new Cell(4, 2, Cell.Type.PASSAGE);
        grid[4][3] = new Cell(4, 3, Cell.Type.PASSAGE);
        grid[4][4] = new Cell(4, 4, Cell.Type.PASSAGE);

        Maze maze = new Maze(5, 5, grid);
        List<Coordinate> path = maze.solveAlgorithmLee(new Coordinate(0, 0), new Coordinate(4, 4));
        String actual = maze.render(path);
        String expected = """
            #####################
            ### *             ###
            ### * ###############
            ### *             ###
            ### * ###############
            ### *  *  *  *  * ###
            #####################
            """;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Path start or end is wall")
    public void pathStartOrEndIsWall() {
        Cell[][] grid = new Cell[5][5];
        grid[0][0] = new Cell(0, 0, Cell.Type.PASSAGE);
        grid[0][1] = new Cell(0, 1, Cell.Type.PASSAGE);
        grid[0][2] = new Cell(0, 2, Cell.Type.PASSAGE);
        grid[0][3] = new Cell(0, 3, Cell.Type.PASSAGE);
        grid[0][4] = new Cell(0, 4, Cell.Type.PASSAGE);

        grid[1][0] = new Cell(1, 0, Cell.Type.PASSAGE);
        grid[1][1] = new Cell(1, 1, Cell.Type.WALL);
        grid[1][2] = new Cell(1, 2, Cell.Type.WALL);
        grid[1][3] = new Cell(1, 3, Cell.Type.WALL);
        grid[1][4] = new Cell(1, 4, Cell.Type.WALL);

        grid[2][0] = new Cell(2, 0, Cell.Type.PASSAGE);
        grid[2][1] = new Cell(2, 1, Cell.Type.PASSAGE);
        grid[2][2] = new Cell(2, 2, Cell.Type.PASSAGE);
        grid[2][3] = new Cell(2, 3, Cell.Type.PASSAGE);
        grid[2][4] = new Cell(2, 4, Cell.Type.PASSAGE);

        grid[3][0] = new Cell(3, 0, Cell.Type.PASSAGE);
        grid[3][1] = new Cell(3, 1, Cell.Type.WALL);
        grid[3][2] = new Cell(3, 2, Cell.Type.WALL);
        grid[3][3] = new Cell(3, 3, Cell.Type.WALL);
        grid[3][4] = new Cell(3, 4, Cell.Type.WALL);

        grid[4][0] = new Cell(4, 0, Cell.Type.PASSAGE);
        grid[4][1] = new Cell(4, 1, Cell.Type.PASSAGE);
        grid[4][2] = new Cell(4, 2, Cell.Type.PASSAGE);
        grid[4][3] = new Cell(4, 3, Cell.Type.PASSAGE);
        grid[4][4] = new Cell(4, 4, Cell.Type.PASSAGE);

        Maze maze = new Maze(5, 5, grid);
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            List<Coordinate> path = maze.solveAlgorithmLee(new Coordinate(0, 0), new Coordinate(1, 1));
        });

        thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            List<Coordinate> path = maze.solveAlgorithmLee(new Coordinate(1, 2), new Coordinate(4, 4));
        });
    }

    @Test
    @DisplayName("Path start or end out of maze")
    public void pathStartOrEndOutOfMaze() {
        Cell[][] grid = new Cell[5][5];
        grid[0][0] = new Cell(0, 0, Cell.Type.PASSAGE);
        grid[0][1] = new Cell(0, 1, Cell.Type.PASSAGE);
        grid[0][2] = new Cell(0, 2, Cell.Type.PASSAGE);
        grid[0][3] = new Cell(0, 3, Cell.Type.PASSAGE);
        grid[0][4] = new Cell(0, 4, Cell.Type.PASSAGE);

        grid[1][0] = new Cell(1, 0, Cell.Type.PASSAGE);
        grid[1][1] = new Cell(1, 1, Cell.Type.WALL);
        grid[1][2] = new Cell(1, 2, Cell.Type.WALL);
        grid[1][3] = new Cell(1, 3, Cell.Type.WALL);
        grid[1][4] = new Cell(1, 4, Cell.Type.WALL);

        grid[2][0] = new Cell(2, 0, Cell.Type.PASSAGE);
        grid[2][1] = new Cell(2, 1, Cell.Type.PASSAGE);
        grid[2][2] = new Cell(2, 2, Cell.Type.PASSAGE);
        grid[2][3] = new Cell(2, 3, Cell.Type.PASSAGE);
        grid[2][4] = new Cell(2, 4, Cell.Type.PASSAGE);

        grid[3][0] = new Cell(3, 0, Cell.Type.PASSAGE);
        grid[3][1] = new Cell(3, 1, Cell.Type.WALL);
        grid[3][2] = new Cell(3, 2, Cell.Type.WALL);
        grid[3][3] = new Cell(3, 3, Cell.Type.WALL);
        grid[3][4] = new Cell(3, 4, Cell.Type.WALL);

        grid[4][0] = new Cell(4, 0, Cell.Type.PASSAGE);
        grid[4][1] = new Cell(4, 1, Cell.Type.PASSAGE);
        grid[4][2] = new Cell(4, 2, Cell.Type.PASSAGE);
        grid[4][3] = new Cell(4, 3, Cell.Type.PASSAGE);
        grid[4][4] = new Cell(4, 4, Cell.Type.PASSAGE);

        Maze maze = new Maze(5, 5, grid);
        IndexOutOfBoundsException thrown = Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            List<Coordinate> path = maze.solveAlgorithmLee(new Coordinate(0, 0), new Coordinate(12, 12));
        });

        thrown = Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            List<Coordinate> path = maze.solveAlgorithmLee(new Coordinate(10, 0), new Coordinate(4, 4));
        });
    }

    @Test
    @DisplayName("Maze generated without errors")
    public void mazeGeneratedWithoutErrors() {
        Maze maze = Generator.generatorPrim(11, 11);
    }
}
