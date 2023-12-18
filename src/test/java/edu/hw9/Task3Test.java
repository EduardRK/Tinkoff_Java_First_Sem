package edu.hw9;

import edu.hw9.Task3.MazeSolverDFSMultiThreads;
import edu.project2.Coordinate;
import edu.project2.Generator.Generator;
import edu.project2.Generator.MazeGeneratorPrim;
import edu.project2.Maze;
import edu.project2.Solver.MazeSolverDFS;
import edu.project2.Solver.Solver;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class Task3Test {
    @ParameterizedTest
    @CsvSource(value = {
        "30, 30",
        "11, 13",
        "13, 41",
        "10, 9",
        "17, 91",
        "15, 11"
    })
    public void mazeDFSMultiThreadsTestFirst(int height, int width) {
        Coordinate start = new Coordinate(0, 0);
        Coordinate end =
            new Coordinate(height % 2 == 0 ? height - 2 : height - 1, width % 2 == 0 ? width - 2 : width - 1);

        Generator generator = new MazeGeneratorPrim();
        Maze maze = generator.generator(height, width);

        Solver solverMultiThreads = new MazeSolverDFSMultiThreads(maze);
        List<Coordinate> pathMultiThreads = solverMultiThreads.solve(start, end);

        Solver solverSingleThread = new MazeSolverDFS(maze);
        List<Coordinate> pathSingleThread = solverSingleThread.solve(start, end);

        Assertions.assertTrue(pathSingleThread.containsAll(pathMultiThreads));
        Assertions.assertTrue(pathMultiThreads.containsAll(pathSingleThread));
    }
}
