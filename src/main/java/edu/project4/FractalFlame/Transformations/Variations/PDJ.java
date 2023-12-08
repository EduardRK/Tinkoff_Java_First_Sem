package edu.project4.FractalFlame.Transformations.Variations;

import edu.project4.FractalFlame.RecordClasses.Coordinate;
import edu.project4.FractalFlame.Transformations.Types.Parametric;
import java.util.Iterator;
import java.util.List;

@SuppressWarnings("MagicNumber")
public class PDJ implements Parametric {
    private double a = 0.5;
    private double b = 0.1;
    private double c = 0.2;
    private double d = 0.7;

    @Override
    public Coordinate apply(Coordinate coordinate) {
        return new Coordinate(
            Math.sin(a * coordinate.y()) - Math.cosh(b * coordinate.x()),
            Math.sin(c * coordinate.x()) - Math.cos(d * coordinate.y())
        );
    }

    @Override
    public void setAffine(AffineTransformation affineTransformation) {

    }

    @Override
    public void setParameters(List<Double> parameters) {
        Iterator<Double> iterator = parameters.iterator();
        if (iterator.hasNext()) {
            a = iterator.next();
        }
        if (iterator.hasNext()) {
            b = iterator.next();
        }
        if (iterator.hasNext()) {
            c = iterator.next();
        }
        if (iterator.hasNext()) {
            d = iterator.next();
        }
    }
}
