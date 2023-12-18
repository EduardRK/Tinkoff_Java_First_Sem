package edu.project4.FractalFlame.Transformations.Variations;

import edu.project4.FractalFlame.RecordClasses.Coordinate;
import edu.project4.FractalFlame.Transformations.Types.Transformation;
import org.jetbrains.annotations.NotNull;

public class Fan implements Transformation {
    private AffineTransformation affineTransformation;

    public Fan() {
    }

    @Override
    public Coordinate apply(@NotNull Coordinate coordinate) {
        double theta = Math.atan(coordinate.x() / coordinate.y());
        double r = Math.sqrt(Math.pow(coordinate.x(), 2) + Math.pow(coordinate.y(), 2));
        double t = Math.PI * Math.pow(affineTransformation.c(), 2);
        double tOverTwo = t / 2;
        if ((theta + affineTransformation.f()) % t >= tOverTwo) {
            return new Coordinate(
                r * Math.cos(theta - tOverTwo),
                r * Math.sin(theta - tOverTwo)
            );
        } else {
            return new Coordinate(
                r * Math.cos(theta + tOverTwo),
                r * Math.sin(theta + tOverTwo)
            );
        }
    }

    @Override
    public void setAffine(AffineTransformation affineTransformation) {
        this.affineTransformation = affineTransformation;
    }
}
