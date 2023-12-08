package edu.project4.FractalFlame.Transformations.Variations;

import edu.project4.FractalFlame.RecordClasses.Coordinate;
import edu.project4.FractalFlame.Transformations.Types.Transformation;

public class Horseshoe implements Transformation {
    @Override
    public Coordinate apply(Coordinate coordinate) {
        double r = Math.sqrt(Math.pow(coordinate.x(), 2) + Math.pow(coordinate.y(), 2));
        return new Coordinate(
            (coordinate.x() - coordinate.y()) * (coordinate.x() + coordinate.y()) / r,
            2 * coordinate.x() * coordinate.y() / r
        );
    }

    @Override
    public void setAffine(AffineTransformation affineTransformation) {

    }
}
