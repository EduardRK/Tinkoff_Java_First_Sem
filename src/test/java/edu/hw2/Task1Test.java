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
    public void constatnTests() {
        var actual = new Constant(3);
        var expected = 3;
        Assertions.assertEquals(expected, actual.evaluate());

        actual = new Constant(new Addition(3, 5));
        expected = 8;
        Assertions.assertEquals(expected, actual.evaluate());

        actual = new Constant(new Multiplication(9, -1));
        expected = -9;
        Assertions.assertEquals(expected, actual.evaluate());
    }

    @Test
    @DisplayName("Negate")
    public void NegateTests() {
        var actual = new Negate(3);
        var expected = -3;
        Assertions.assertEquals(expected, actual.evaluate());

        actual = new Negate(new Addition(3, 5));
        expected = -8;
        Assertions.assertEquals(expected, actual.evaluate());

        actual = new Negate(new Exponent(9, 2));
        expected = -81;
        Assertions.assertEquals(expected, actual.evaluate());
    }

    @Test
    @DisplayName("Addition")
    public void additionTests() {
        var actual = new Addition(3, 1);
        var expected = 4;
        Assertions.assertEquals(expected, actual.evaluate());

        actual = new Addition(new Addition(3, 5), new Addition(-1, -1));
        expected = 6;
        Assertions.assertEquals(expected, actual.evaluate());

        actual = new Addition(new Multiplication(9, 2), new Constant(9));
        expected = 27;
        Assertions.assertEquals(expected, actual.evaluate());
    }

    @Test
    @DisplayName("Multiplication")
    public void MultiplicationTests() {
        var actual = new Multiplication(3, 7);
        var expected = 21;
        Assertions.assertEquals(expected, actual.evaluate());

        actual = new Multiplication(new Addition(3, 5), new Negate(9));
        expected = -72;
        Assertions.assertEquals(expected, actual.evaluate());

        actual = new Multiplication(new Multiplication(9, -1), new Addition(3, 4));
        expected = -63;
        Assertions.assertEquals(expected, actual.evaluate());
    }

    @Test
    @DisplayName("Exponent")
    public void exponentTests() {
        var actual = new Exponent(3, 2);
        var expected = 9;
        Assertions.assertEquals(expected, actual.evaluate());

        actual = new Exponent(new Addition(3, 5), 1);
        expected = 8;
        Assertions.assertEquals(expected, actual.evaluate());

        actual = new Exponent(new Multiplication(9, -1), new Addition(1, new Negate(-1)));
        expected = 81;
        Assertions.assertEquals(expected, actual.evaluate());
    }
}
