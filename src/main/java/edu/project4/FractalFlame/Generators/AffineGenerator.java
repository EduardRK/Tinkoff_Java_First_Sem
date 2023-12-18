package edu.project4.FractalFlame.Generators;

import edu.project4.Constants;
import edu.project4.FractalFlame.Transformations.Factories.AffineTransformationFactory;
import edu.project4.FractalFlame.Transformations.Variations.AffineTransformation;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public final class AffineGenerator implements Generator<AffineTransformation> {
    public AffineGenerator() {
    }

    public @NotNull List<AffineTransformation> generate() {
        List<AffineTransformation> affineTransformationList = new ArrayList<>();
        AffineTransformationFactory affineTransformationFactory = new AffineTransformationFactory();
        for (int i = 0; i < Constants.COUNT_AFFINE_TRANSFORMATIONS; ++i) {
            affineTransformationList.add(affineTransformationFactory.create());
        }
        return affineTransformationList;
    }
}
