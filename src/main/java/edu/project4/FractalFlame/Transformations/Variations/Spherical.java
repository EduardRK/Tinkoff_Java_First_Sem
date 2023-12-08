package edu.project4.FractalFlame.Transformations.Variations;

import edu.project4.FractalFlame.RecordClasses.Coordinate;
import edu.project4.FractalFlame.Transformations.Types.Transformation;

public class Spherical implements Transformation {
    @Override
    public Coordinate apply(Coordinate coordinate) {
        double rSquare = Math.pow(coordinate.x(), 2) + Math.pow(coordinate.y(), 2);
        return new Coordinate(coordinate.x() / rSquare, coordinate.y() / rSquare);
    }

    @Override
    public void setAffine(AffineTransformation affineTransformation) {

    }
}
