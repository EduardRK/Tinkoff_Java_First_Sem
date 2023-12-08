package edu.project4.FractalFlame.Transformations.Variations;

import edu.project4.FractalFlame.RecordClasses.Coordinate;
import edu.project4.FractalFlame.Transformations.Types.Parametric;
import java.util.Iterator;
import java.util.List;

public class Fan2 implements Parametric {
    private double x = 1;
    private double y = 1;

    @Override
    public void setParameters(List<Double> parameters) {
        Iterator<Double> iterator = parameters.iterator();
        if (iterator.hasNext()) {
            x = iterator.next();
        }
        if (iterator.hasNext()) {
            y = iterator.next();
        }
    }

    @Override
    public void setAffine(AffineTransformation affineTransformation) {

    }

    @Override
    public Coordinate apply(Coordinate coordinate) {
        double p1 = Math.PI * Math.pow(x, 2);
        double p2 = y;
        double theta = Math.atan(coordinate.x() / coordinate.y());
        double r = Math.sqrt(Math.pow(coordinate.x(), 2) + Math.pow(coordinate.y(), 2));
        double t = theta + p2 - p1 * (int) (2 * theta * p2 / p1);
        if (t > p1 / 2) {
            return new Coordinate(
                r * Math.sin(theta - p1 / 2),
                r * Math.cos(theta - p1 / 2)
            );
        } else {
            return new Coordinate(
                r * Math.sin(theta + p1 / 2),
                r * Math.cos(theta + p1 / 2)
            );
        }
    }
}
