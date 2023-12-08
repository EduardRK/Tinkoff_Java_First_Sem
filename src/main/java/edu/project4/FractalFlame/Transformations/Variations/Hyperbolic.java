package edu.project4.FractalFlame.Transformations.Variations;

import edu.project4.FractalFlame.RecordClasses.Coordinate;
import edu.project4.FractalFlame.Transformations.Types.Transformation;

public class Hyperbolic implements Transformation {
    @Override
    public Coordinate apply(Coordinate coordinate) {
        double theta = Math.atan(coordinate.x() / coordinate.y());
        double r = Math.sqrt(Math.pow(coordinate.x(), 2) + Math.pow(coordinate.y(), 2));
        return new Coordinate(1 / r * Math.sin(theta), r * Math.cos(theta));
    }

    @Override
    public void setAffine(AffineTransformation affineTransformation) {

    }
}
