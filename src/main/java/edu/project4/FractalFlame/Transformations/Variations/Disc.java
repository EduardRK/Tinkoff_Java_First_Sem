package edu.project4.FractalFlame.Transformations.Variations;

import edu.project4.FractalFlame.RecordClasses.Coordinate;
import edu.project4.FractalFlame.Transformations.Types.Transformation;

public class Disc implements Transformation {
    @Override
    public Coordinate apply(Coordinate coordinate) {
        double theta = Math.atan(coordinate.x() / coordinate.y());
        double r = Math.sqrt(Math.pow(coordinate.x(), 2) + Math.pow(coordinate.y(), 2));
        double piR = Math.PI * r;
        return new Coordinate(
            theta / Math.PI * Math.sin(piR),
            theta / Math.PI * Math.cos(piR)
        );
    }

    @Override
    public void setAffine(AffineTransformation affineTransformation) {

    }
}
