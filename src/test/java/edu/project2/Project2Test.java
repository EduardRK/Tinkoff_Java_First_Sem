package edu.project2;

import edu.project2.Generator.Generator;
import edu.project2.Generator.MazeGeneratorPrim;
import edu.project2.Solver.MazeSolverBFS;
import edu.project2.Solver.MazeSolverDFS;
import java.util.List;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Project2Test {
    private static final int HEIGHT = 5;
    private static final int WIDTH = 5;
    private static final Cell[][] GRID = new Cell[HEIGHT][WIDTH];
    private static final Maze MAZE = new Maze(HEIGHT, WIDTH, GRID);
    private static final String RENDER_MAZE = "#####################" + System.lineSeparator()
        + "###               ###" + System.lineSeparator()
        + "###   ###############" + System.lineSeparator()
        + "###               ###" + System.lineSeparator()
        + "###   ###############" + System.lineSeparator()
        + "###               ###" + System.lineSeparator()
        + "#####################" + System.lineSeparator();
    private static final String RENDER_PATH_MAZE = "#####################" + System.lineSeparator()
        + "### *             ###" + System.lineSeparator()
        + "### * ###############" + System.lineSeparator()
        + "### *             ###" + System.lineSeparator()
        + "### * ###############" + System.lineSeparator()
        + "### *  *  *  *  * ###" + System.lineSeparator()
        + "#####################" + System.lineSeparator();

    static {
        GRID[0][0] = new Cell(0, 0, Cell.Type.PASSAGE);
        GRID[0][1] = new Cell(0, 1, Cell.Type.PASSAGE);
        GRID[0][2] = new Cell(0, 2, Cell.Type.PASSAGE);
        GRID[0][3] = new Cell(0, 3, Cell.Type.PASSAGE);
        GRID[0][4] = new Cell(0, 4, Cell.Type.PASSAGE);

        GRID[1][0] = new Cell(1, 0, Cell.Type.PASSAGE);
        GRID[1][1] = new Cell(1, 1, Cell.Type.WALL);
        GRID[1][2] = new Cell(1, 2, Cell.Type.WALL);
        GRID[1][3] = new Cell(1, 3, Cell.Type.WALL);
        GRID[1][4] = new Cell(1, 4, Cell.Type.WALL);

        GRID[2][0] = new Cell(2, 0, Cell.Type.PASSAGE);
        GRID[2][1] = new Cell(2, 1, Cell.Type.PASSAGE);
        GRID[2][2] = new Cell(2, 2, Cell.Type.PASSAGE);
        GRID[2][3] = new Cell(2, 3, Cell.Type.PASSAGE);
        GRID[2][4] = new Cell(2, 4, Cell.Type.PASSAGE);

        GRID[3][0] = new Cell(3, 0, Cell.Type.PASSAGE);
        GRID[3][1] = new Cell(3, 1, Cell.Type.WALL);
        GRID[3][2] = new Cell(3, 2, Cell.Type.WALL);
        GRID[3][3] = new Cell(3, 3, Cell.Type.WALL);
        GRID[3][4] = new Cell(3, 4, Cell.Type.WALL);

        GRID[4][0] = new Cell(4, 0, Cell.Type.PASSAGE);
        GRID[4][1] = new Cell(4, 1, Cell.Type.PASSAGE);
        GRID[4][2] = new Cell(4, 2, Cell.Type.PASSAGE);
        GRID[4][3] = new Cell(4, 3, Cell.Type.PASSAGE);
        GRID[4][4] = new Cell(4, 4, Cell.Type.PASSAGE);
    }

    @Contract(" -> new")
    private static Arguments @NotNull [] getArgumentsPath() {
        return new Arguments[] {
            Arguments.of(new Coordinate(0, 0), new Coordinate(4, 4), List.of(
                new Coordinate(0, 0),
                new Coordinate(1, 0),
                new Coordinate(2, 0),
                new Coordinate(3, 0),
                new Coordinate(4, 0),
                new Coordinate(4, 1),
                new Coordinate(4, 2),
                new Coordinate(4, 3),
                new Coordinate(4, 4)
            )),
            Arguments.of(new Coordinate(0, 0), new Coordinate(0, 0), List.of(new Coordinate(0, 0)))
        };
    }

    @Contract(" -> new")
    private static Arguments @NotNull [] getArgumentsForRender() {
        return new Arguments[] {
            Arguments.of(new Coordinate(0, 0), new Coordinate(4, 4))
        };
    }

    @Contract(" -> new")
    private static Arguments @NotNull [] getInvalidArguments() {
        return new Arguments[] {
            Arguments.of(new Coordinate(0, 0), new Coordinate(1, 1)),
            Arguments.of(new Coordinate(1, 2), new Coordinate(4, 4)),
            Arguments.of(new Coordinate(0, 0), new Coordinate(12, 12)),
            Arguments.of(new Coordinate(10, 0), new Coordinate(4, 4))
        };
    }

    @Test
    @DisplayName("Render maze")
    public void renderMaze() {
        Assertions.assertEquals(RENDER_MAZE, MAZE.render());
    }

    @ParameterizedTest
    @MethodSource(value = "getArgumentsPath")
    @DisplayName("Find path")
    public void findPath(Coordinate start, Coordinate end, List<Coordinate> path) {
        Assertions.assertEquals(path, new MazeSolverBFS(MAZE).solve(start, end));
        Assertions.assertEquals(path, new MazeSolverDFS(MAZE).solve(start, end));
    }

    @ParameterizedTest
    @MethodSource(value = "getArgumentsForRender")
    @DisplayName("Render path")
    public void renderPath(Coordinate start, Coordinate end) {
        Assertions.assertEquals(RENDER_PATH_MAZE, MAZE.render(new MazeSolverBFS(MAZE).solve(start, end)));
        Assertions.assertEquals(RENDER_PATH_MAZE, MAZE.render(new MazeSolverDFS(MAZE).solve(start, end)));
    }

    @ParameterizedTest
    @MethodSource(value = "getInvalidArguments")
    @DisplayName("Path start or end is wall")
    public void invalidArguments(Coordinate start, Coordinate end) {
        Assertions.assertThrows(Exception.class, () -> new MazeSolverBFS(MAZE).solve(start, end));
        Assertions.assertThrows(Exception.class, () -> new MazeSolverDFS(MAZE).solve(start, end));
    }

    @Test
    @DisplayName("Maze generated without errors")
    public void mazeGeneratedWithoutErrors() {
        Generator generator = new MazeGeneratorPrim();
        Maze maze = generator.generator(11, 11);
    }
}
