package edu.project4.FractalFlame.Transformations.Variations;

import edu.project4.FractalFlame.RecordClasses.Coordinate;
import edu.project4.FractalFlame.Transformations.Types.Transformation;
import org.jetbrains.annotations.NotNull;

public class Swirl implements Transformation {
    @Override
    public Coordinate apply(@NotNull Coordinate coordinate) {
        double rSquare = Math.pow(coordinate.x(), 2) + Math.pow(coordinate.y(), 2);
        double sinRSquare = Math.sin(rSquare);
        double cosRSquare = Math.cos(rSquare);
        return new Coordinate(
            coordinate.x() * sinRSquare - coordinate.y() * cosRSquare,
            coordinate.x() * cosRSquare + coordinate.y() * sinRSquare
        );
    }

    @Override
    public void setAffine(AffineTransformation affineTransformation) {

    }
}
