package edu.project4.FractalFlame.Transformations.Variations;

import edu.project4.FractalFlame.RecordClasses.Coordinate;
import edu.project4.FractalFlame.Transformations.Types.Transformation;
import java.awt.Color;

public record AffineTransformation(double a, double b, double c, double d, double e, double f, Color color)
    implements Transformation {
    @Override
    public Coordinate apply(Coordinate coordinate) {
        return new Coordinate(
            a * coordinate.x() + b * coordinate.y() + c,
            d * coordinate.x() + e * coordinate.y() + f
        );
    }

    @Override
    public void setAffine(AffineTransformation affineTransformation) {

    }
}
