package edu.project2;

import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public record Maze(int height, int width, Cell[][] grid) implements Render {

    @Override
    public @NotNull String render() {
        return render(new ArrayList<>());
    }

    @Override
    public @NotNull String render(List<Coordinate> path) {
        StringBuilder maze = new StringBuilder();

        maze.append(WALL.repeat(width + 2)).append(System.lineSeparator());
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
            maze.append(WALL).append(System.lineSeparator());
        }
        maze.append(WALL.repeat(width + 2)).append(System.lineSeparator());

        return maze.toString();
    }

}
