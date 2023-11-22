package edu.project2.Solver;

import edu.project2.Coordinate;
import java.util.List;

public interface Solver {
    List<Coordinate> solve(Coordinate start, Coordinate end);
}
