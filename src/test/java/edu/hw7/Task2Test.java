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

    @Test
    @DisplayName("Parallel faster than not parallel (Big number)")
    public void parallelFasterThanNotParallel() {
        long t1 = System.nanoTime();
        BigInteger bigInteger1 = Task2.factorialParallel(20_000);
        long t2 = System.nanoTime();

        long t3 = System.nanoTime();
        BigInteger bigInteger2 = Task2.factorialNotParallel(20_000);
        long t4 = System.nanoTime();

        Assertions.assertTrue((t4 - t3) >= (t2 - t1));
    }
}
