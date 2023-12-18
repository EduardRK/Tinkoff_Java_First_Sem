package edu.project4;

import edu.project4.FractalFlame.Generators.FractalFlameGenerator;
import java.nio.file.Path;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class Project4Test {
    @ParameterizedTest
    @CsvSource(value = {
        "ex",
        "swirl",
        "spiral",
        "exponential",
        "polar",
        "tangent",
        "horseshoe",
        "heart",
        "cross",
        "curl",
        "bent",
        "blob"
    })
    @DisplayName("Generate some fractal flame images")
    public void generateSomeFractalFlame(String variation, @TempDir Path path) {
        String[] args = new String[] {path.toString(), variation};
        ArgsParser argsParser = ArgsParser.create(args);
        FractalFlameGenerator.generate(
            argsParser.variationsType(),
            argsParser.imageFormat(),
            argsParser.parameters(),
            path
        );
    }

    @Test
    @DisplayName("Test image formats")
    public void testImageFormats(@TempDir Path path) {
        String[] args = new String[] {path.toString(), "JPEG"};
        ArgsParser argsParser = ArgsParser.create(args);
        FractalFlameGenerator.generate(
            argsParser.variationsType(),
            argsParser.imageFormat(),
            argsParser.parameters(),
            path
        );

        args = new String[] {path.toString(), "BMP"};
        argsParser = ArgsParser.create(args);
        FractalFlameGenerator.generate(
            argsParser.variationsType(),
            argsParser.imageFormat(),
            argsParser.parameters(),
            path
        );
    }

    @Test
    @DisplayName("Illegal function name")
    public void illegalFunctionName(@TempDir Path path) {
        String[] args = new String[] {path.toString(), "qwer"};
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            ArgsParser argsParser = ArgsParser.create(args);
            FractalFlameGenerator.generate(
                argsParser.variationsType(),
                argsParser.imageFormat(),
                argsParser.parameters(),
                argsParser.path()
            );
        });
    }
}
