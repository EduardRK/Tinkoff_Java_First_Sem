package edu.project4.FractalFlame.Generators;

import edu.project4.FractalFlame.Transformations.Factories.TransformationFactory;
import edu.project4.FractalFlame.Transformations.Types.Transformation;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public final class TransformationGenerator implements Generator<Transformation> {
    private final List<String> typesTransformations;
    private final List<Double> parameters;

    public TransformationGenerator(List<String> typesTransformations, List<Double> parameters) {
        this.typesTransformations = typesTransformations;
        this.parameters = parameters;
    }

    @Override
    public @NotNull List<Transformation> generate() {
        List<Transformation> transformationList = new ArrayList<>();
        TransformationFactory transformationFactory = new TransformationFactory();
        for (String type : typesTransformations) {
            transformationList.add(transformationFactory.create(type, parameters));
        }
        return transformationList;
    }
}
