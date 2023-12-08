package edu.project4.FractalFlame.Transformations.Variations;

import edu.project4.FractalFlame.RecordClasses.Coordinate;
import edu.project4.FractalFlame.Transformations.Types.Parametric;
import java.util.Iterator;
import java.util.List;

@SuppressWarnings("MagicNumber")
public class Blob implements Parametric {
    private double high = 1;
    private double low = 0;
    private double waves = 5;

    @Override
    public Coordinate apply(Coordinate coordinate) {
        double theta = Math.atan(coordinate.x() / coordinate.y());
        double r = Math.sqrt(Math.pow(coordinate.x(), 2) + Math.pow(coordinate.y(), 2));
        double multiplier = r * (low + (high - low) / waves * (Math.sin(waves * theta) + 1));
        return new Coordinate(
            multiplier * Math.cos(theta),
            multiplier * Math.sin(theta)
        );
    }

    @Override
    public void setParameters(List<Double> parameters) {
        Iterator<Double> iterator = parameters.iterator();
        if (iterator.hasNext()) {
            high = iterator.next();
        }
        if (iterator.hasNext()) {
            low = iterator.next();
        }
        if (iterator.hasNext()) {
            waves = iterator.next();
        }
    }

    @Override
    public void setAffine(AffineTransformation affineTransformation) {

    }
}
