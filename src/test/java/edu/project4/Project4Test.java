package edu.project4;

import edu.project4.FractalFlame.Generators.FractalFlameGenerator;
import java.nio.file.Path;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
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
    public void generateSomeFractalFlame(String variation, @TempDir @NotNull Path path) {
        ArgsParser argsParser = ArgsParser.create(new String[] {path.toString(), variation});
        FractalFlameGenerator.generate(
            argsParser.variationsType(),
            argsParser.imageFormat(),
            argsParser.parameters(),
            path
        );
    }

    @ParameterizedTest
    @CsvSource(value = {
        "JPEG",
        "PNG",
        "BMP"
    })
    @DisplayName("Test image formats")
    public void testImageFormats(String fileType, @TempDir @NotNull Path path) {
        ArgsParser argsParser = ArgsParser.create(new String[] {path.toString(), fileType});
        FractalFlameGenerator.generate(
            argsParser.variationsType(),
            argsParser.imageFormat(),
            argsParser.parameters(),
            path
        );
    }

    @ParameterizedTest
    @CsvSource(value = {
        "qwer",
        "qwRITY"
    })
    @DisplayName("Illegal function name")
    public void illegalFunctionName(String typeName, @TempDir @NotNull Path path) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            ArgsParser argsParser = ArgsParser.create(new String[] {path.toString(), typeName});
            FractalFlameGenerator.generate(
                argsParser.variationsType(),
                argsParser.imageFormat(),
                argsParser.parameters(),
                argsParser.path()
            );
        });
    }
}
