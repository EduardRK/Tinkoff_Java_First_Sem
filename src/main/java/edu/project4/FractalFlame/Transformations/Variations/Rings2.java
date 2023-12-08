package edu.project4.FractalFlame.Transformations.Variations;

import edu.project4.FractalFlame.RecordClasses.Coordinate;
import edu.project4.FractalFlame.Transformations.Types.Parametric;
import java.util.Iterator;
import java.util.List;

public class Rings2 implements Parametric {
    private double value = 1;

    @Override
    public void setParameters(List<Double> parameters) {
        Iterator<Double> iterator = parameters.iterator();
        if (iterator.hasNext()) {
            value = iterator.next();
        }
    }

    @Override
    public void setAffine(AffineTransformation affineTransformation) {

    }

    @Override
    public Coordinate apply(Coordinate coordinate) {
        double theta = Math.atan(coordinate.x() / coordinate.y());
        double r = Math.sqrt(Math.pow(coordinate.x(), 2) + Math.pow(coordinate.y(), 2));
        double p = Math.pow(value, 2);
        double t = 2 * p * (int) ((r + p) / (2 * p)) + r * (1 - p);
        return new Coordinate(
            t * Math.sin(theta),
            t * Math.cos(theta)
        );
    }
}
