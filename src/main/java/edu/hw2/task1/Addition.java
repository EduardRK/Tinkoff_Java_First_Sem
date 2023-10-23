package edu.hw2.task1;

public record Addition(double left, double right) implements Expr {

    public Addition(double left, Expr right) {
        this(left, right.evaluate());
    }

    public Addition(Expr left, double right) {
        this(left.evaluate(), right);
    }

    public Addition(Expr left, Expr right) {
        this(left.evaluate(), right.evaluate());
    }

    @Override
    public double evaluate() {
        return left + right;
    }
}
