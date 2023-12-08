package edu.project4.FractalFlame.Transformations.Variations;

import edu.project4.FractalFlame.RecordClasses.Coordinate;
import edu.project4.FractalFlame.Transformations.Types.Transformation;

@SuppressWarnings("MagicNumber")
public class Bubble implements Transformation {
    @Override
    public void setAffine(AffineTransformation affineTransformation) {

    }

    @Override
    public Coordinate apply(Coordinate coordinate) {
        double r = Math.sqrt(Math.pow(coordinate.x(), 2) + Math.pow(coordinate.y(), 2));
        double multiplier = 4 / (Math.pow(r, 2) + 4);
        return new Coordinate(
            multiplier * coordinate.x(),
            multiplier * coordinate.y()
        );
    }
}
