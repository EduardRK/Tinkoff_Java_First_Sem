package edu.hw7;

import edu.hw7.Task2.Task2;
import java.math.BigInteger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class Task2Test {
    @ParameterizedTest
    @CsvSource(value = {
        "1, 1",
        "5, 120",
        "10, 3628800",
        "20, 2432902008176640000"
    })
    @DisplayName("Correct calculation multi threads")
    public void correctCalculationMultiThreads(int number, BigInteger expected) {
        Assertions.assertEquals(expected, Task2.factorialParallel(number));
        Assertions.assertEquals(expected, Task2.factorialNotParallel(number));
    }
}
