package edu.project4.FractalFlame.Renders;

import edu.project4.FractalFlame.Image.ImageClasses.FractalImage;
import edu.project4.FractalFlame.Transformations.Types.Transformation;
import java.util.List;

public interface Renderer {
    FractalImage render(
        List<Transformation> variations
    );
}
