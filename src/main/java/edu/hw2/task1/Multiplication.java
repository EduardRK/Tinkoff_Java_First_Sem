package edu.hw2.task1;

import org.jetbrains.annotations.NotNull;

public record Multiplication(double left, double right) implements Expr {

    public Multiplication(double left, @NotNull Expr right) {
        this(left, right.evaluate());
    }

    public Multiplication(@NotNull Expr left, double right) {
        this(left.evaluate(), right);
    }

    public Multiplication(@NotNull Expr left, @NotNull Expr right) {
        this(left.evaluate(), right.evaluate());
    }

    @Override
    public double evaluate() {
        return left * right;
    }
}
