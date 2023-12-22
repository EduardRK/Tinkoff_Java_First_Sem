package edu.hw2.task1;

import org.jetbrains.annotations.NotNull;

public record Constant(double number) implements Expr {
    public Constant(@NotNull Expr number) {
        this(number.evaluate());
    }

    @Override
    public double evaluate() {
        return number;
    }
}


