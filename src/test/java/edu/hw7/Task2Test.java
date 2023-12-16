package edu.hw7;

import edu.hw7.Task2.Task2;
import java.math.BigInteger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Task2Test {
    @Test
    @DisplayName("Correct calculation")
    public void correctCalculation() {
        BigInteger actual = Task2.factorialParallel(5);
        BigInteger expected = new BigInteger("120");

        Assertions.assertEquals(expected, actual);

        actual = Task2.factorialParallel(10);
        expected = new BigInteger("3628800");

        Assertions.assertEquals(expected, actual);
    }
}
