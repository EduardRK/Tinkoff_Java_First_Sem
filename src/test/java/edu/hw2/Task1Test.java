package edu.hw2;

import edu.hw2.task1.Addition;
import edu.hw2.task1.Constant;
import edu.hw2.task1.Exponent;
import edu.hw2.task1.Multiplication;
import edu.hw2.task1.Negate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Task1Test {

    @Test
    @DisplayName("Constant")
    public void constantTests() {
        Assertions.assertEquals(3, new Constant(3).evaluate());
        Assertions.assertEquals(8, new Constant(new Addition(3, 5)).evaluate());
    }

    @Test
    @DisplayName("Negate")
    public void NegateTests() {
        Assertions.assertEquals(-3, new Negate(3).evaluate());
        Assertions.assertEquals(-4, new Negate(new Multiplication(2, 2)).evaluate());
    }

    @Test
    @DisplayName("Addition")
    public void additionTests() {
        Assertions.assertEquals(7, new Addition(3, 4).evaluate());
        Assertions.assertEquals(10, new Addition(new Constant(6), 4).evaluate());
        Assertions.assertEquals(5, new Addition(3, new Multiplication(1, 2)).evaluate());
        Assertions.assertEquals(-1, new Addition(new Exponent(3, 1), new Negate(4)).evaluate());
    }

    @Test
    @DisplayName("Multiplication")
    public void MultiplicationTests() {
        Assertions.assertEquals(12, new Multiplication(3, 4).evaluate());
        Assertions.assertEquals(24, new Multiplication(new Constant(6), 4).evaluate());
        Assertions.assertEquals(6, new Multiplication(3, new Multiplication(1, 2)).evaluate());
        Assertions.assertEquals(-12, new Multiplication(new Exponent(3, 1), new Negate(4)).evaluate());
    }

    @Test
    @DisplayName("Exponent")
    public void exponentTests() {
        Assertions.assertEquals(81, new Exponent(3, 4).evaluate());
        Assertions.assertEquals(16, new Exponent(new Constant(2), 4).evaluate());
        Assertions.assertEquals(9, new Exponent(3, new Multiplication(1, 2)).evaluate());
        Assertions.assertEquals(1, new Exponent(new Addition(3, 1), new Negate(0)).evaluate());
    }
}
