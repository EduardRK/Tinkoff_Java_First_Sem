package edu.project4.FractalFlame.Transformations.Variations;

import edu.project4.FractalFlame.RecordClasses.Coordinate;
import edu.project4.FractalFlame.Transformations.Types.Transformation;
import org.jetbrains.annotations.NotNull;

public class Bent implements Transformation {

    @Override
    public Coordinate apply(@NotNull Coordinate coordinate) {
        if (coordinate.x() >= 0 && coordinate.y() >= 0) {
            return new Coordinate(
                coordinate.x(),
                coordinate.y()
            );
        } else if (coordinate.x() < 0 && coordinate.y() >= 0) {
            return new Coordinate(
                2 * coordinate.x(),
                coordinate.y()
            );
        } else if (coordinate.x() >= 0 && coordinate.y() < 0) {
            return new Coordinate(
                coordinate.x(),
                coordinate.y() / 2
            );
        } else {
            return new Coordinate(
                2 * coordinate.x(),
                coordinate.y() / 2
            );
        }
    }

    @Override
    public void setAffine(AffineTransformation affineTransformation) {
    }
}
