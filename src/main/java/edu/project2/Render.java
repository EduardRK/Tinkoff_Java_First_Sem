package edu.project2;

import java.util.List;

public interface Render {

    String WALL = "###";
    String PASSAGE = "   ";
    String PATH = " * ";

    String render();

    String render(List<Coordinate> path);
}
