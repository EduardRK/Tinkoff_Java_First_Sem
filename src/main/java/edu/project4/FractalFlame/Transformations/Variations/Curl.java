package edu.project4.FractalFlame.Transformations.Variations;

import edu.project4.FractalFlame.RecordClasses.Coordinate;
import edu.project4.FractalFlame.Transformations.Types.Parametric;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("MagicNumber")
public class Curl implements Parametric {
    private double p1 = 3;
    private double p2 = 2;

    @Override
    public void setParameters(@NotNull List<Double> parameters) {
        Iterator<Double> iterator = parameters.iterator();
        if (iterator.hasNext()) {
            p1 = iterator.next();
        }
        if (iterator.hasNext()) {
            p2 = iterator.next();
        }
    }

    @Override
    public void setAffine(AffineTransformation affineTransformation) {

    }

    @Override
    public Coordinate apply(@NotNull Coordinate coordinate) {
        double t1 = 1 + p1 * coordinate.x() + p2 * (Math.pow(coordinate.x(), 2) - Math.pow(coordinate.y(), 2));
        double t2 = p1 * coordinate.y() + 2 * p2 * coordinate.x() * coordinate.y();
        double multiplier = 1 / (Math.pow(t1, 2) + Math.pow(t2, 2));
        return new Coordinate(
            multiplier * (coordinate.x() * t1 + coordinate.y() * t2),
            multiplier * (coordinate.y() * t1 - coordinate.x() * t2)
        );
    }
}
