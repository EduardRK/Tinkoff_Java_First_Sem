package edu.project4;

import edu.project4.FractalFlame.Generators.FractalFlameGenerator;

public final class Main {
    private Main() {

    }

    public static void main(String[] args) {
        ArgsParser argsParser = ArgsParser.create(args);
        FractalFlameGenerator.generate(
            argsParser.variationsType(),
            argsParser.imageFormat(),
            argsParser.parameters(),
            argsParser.path()
        );
    }
}
