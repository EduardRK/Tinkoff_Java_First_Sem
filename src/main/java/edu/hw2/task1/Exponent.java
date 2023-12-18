package edu.hw2.task1;

import org.jetbrains.annotations.NotNull;

public record Exponent(double base, double power) implements Expr {

    public Exponent(double base, @NotNull Expr power) {
        this(base, power.evaluate());
    }

    public Exponent(@NotNull Expr base, double power) {
        this(base.evaluate(), power);
    }

    public Exponent(@NotNull Expr base, @NotNull Expr power) {
        this(base.evaluate(), power.evaluate());
    }

    @Override
    public double evaluate() {
        return Math.pow(base, power);
    }
}
