package edu.project4.FractalFlame.Transformations.Variations;

import edu.project4.FractalFlame.RecordClasses.Coordinate;
import edu.project4.FractalFlame.Transformations.Types.Transformation;

@SuppressWarnings("MagicNumber")
public class Popcorn implements Transformation {
    private AffineTransformation affineTransformation;

    @Override
    public Coordinate apply(Coordinate coordinate) {
        return new Coordinate(
            coordinate.x() + affineTransformation.c() * Math.sin(Math.tan(3 * coordinate.y())),
            coordinate.y() + affineTransformation.f() * Math.sin(Math.tan(3 * coordinate.x()))
        );
    }

    @Override
    public void setAffine(AffineTransformation affineTransformation) {
        this.affineTransformation = affineTransformation;
    }
}
