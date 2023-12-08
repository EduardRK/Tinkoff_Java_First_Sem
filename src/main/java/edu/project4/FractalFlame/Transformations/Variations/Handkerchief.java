package edu.project4.FractalFlame.Transformations.Variations;

import edu.project4.FractalFlame.RecordClasses.Coordinate;
import edu.project4.FractalFlame.Transformations.Types.Transformation;

public class Handkerchief implements Transformation {
    @Override
    public Coordinate apply(Coordinate coordinate) {
        double theta = Math.atan(coordinate.x() / coordinate.y());
        double r = Math.sqrt(Math.pow(coordinate.x(), 2) + Math.pow(coordinate.y(), 2));
        return new Coordinate(r * Math.sin(theta + r), r * Math.cos(theta - r));
    }

    @Override
    public void setAffine(AffineTransformation affineTransformation) {

    }
}
