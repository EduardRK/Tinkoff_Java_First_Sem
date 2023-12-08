package edu.project4.FractalFlame.Transformations.Variations;

import edu.project4.FractalFlame.RecordClasses.Coordinate;
import edu.project4.FractalFlame.Transformations.Types.Transformation;

public class Sinusoidal implements Transformation {
    @Override
    public Coordinate apply(Coordinate coordinate) {
        return new Coordinate(Math.sin(coordinate.x()), Math.sin(coordinate.y()));
    }

    @Override
    public void setAffine(AffineTransformation affineTransformation) {

    }
}
