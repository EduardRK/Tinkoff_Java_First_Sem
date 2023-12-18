package edu.hw2.task1;

import org.jetbrains.annotations.NotNull;

public record Negate(double number) implements Expr {

    public Negate(@NotNull Expr number) {
        this(number.evaluate());
    }

    @Override
    public double evaluate() {
        return -number;
    }
}
