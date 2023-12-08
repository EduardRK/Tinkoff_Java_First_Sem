package edu.project4.FractalFlame.Transformations.Variations;

import edu.project4.FractalFlame.RecordClasses.Coordinate;
import edu.project4.FractalFlame.Transformations.Types.Parametric;
import java.util.Iterator;
import java.util.List;

@SuppressWarnings("MagicNumber")
public class Ngon implements Parametric {
    private double power = 2;
    private double sides = 4;
    private double corners = 4;
    private double circle = 4;
    private double p2 = 2 * Math.PI / sides;

    @Override
    public void setParameters(List<Double> parameters) {
        Iterator<Double> iterator = parameters.iterator();
        if (iterator.hasNext()) {
            power = iterator.next();
        }
        if (iterator.hasNext()) {
            sides = iterator.next();
            p2 = 2 * Math.PI / sides;
        }
        if (iterator.hasNext()) {
            corners = iterator.next();
        }
        if (iterator.hasNext()) {
            circle = iterator.next();
        }
    }

    @Override
    public void setAffine(AffineTransformation affineTransformation) {

    }

    @Override
    public Coordinate apply(Coordinate coordinate) {
        double r = Math.sqrt(Math.pow(coordinate.x(), 2) + Math.pow(coordinate.y(), 2));
        double phi = Math.atan(coordinate.y() / coordinate.x());
        double t3 = phi - p2 * Math.floor(phi / p2);
        double t4 = t3 > p2 / 2 ? t3 : t3 - p2;
        double k = (corners * (1 / Math.cos(t4) - 1) + circle) / Math.pow(r, power);
        return new Coordinate(
            k * coordinate.x(),
            k * coordinate.y()
        );
    }
}
