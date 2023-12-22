package edu.hw2.task1;

import org.jetbrains.annotations.NotNull;

public record Addition(double left, double right) implements Expr {

    public Addition(double left, @NotNull Expr right) {
        this(left, right.evaluate());
    }

    public Addition(@NotNull Expr left, double right) {
        this(left.evaluate(), right);
    }

    public Addition(@NotNull Expr left, @NotNull Expr right) {
        this(left.evaluate(), right.evaluate());
    }

    @Override
    public double evaluate() {
        return left + right;
    }
}
