package edu.hw8;

import edu.hw8.Task2.FibonacciCounter;
import java.math.BigDecimal;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class Task2Test {
    @DisplayName("Test fibonacci numbers")
    @ParameterizedTest
    @CsvSource(value = {
        "1, 1",
        "2, 1",
        "3, 2",
        "4, 3",
        "5, 5",
        "6, 8",
        "7, 13",
        "8, 21",
        "9, 34",
        "10, 55",
        "30, 832040",
        "55, 139583862445",
        "83, 99194853094755497",
        "99, 218922995834555169026",
        "100, 354224848179261915075",
        "101, 573147844013817084101",
        "248, 3016128079338728432528443992613633888712980904400501",
        "300, 222232244629420445529739893461909967206666939096499764990979600"
    })
    public void fibonacciNumber(long actualNth, BigDecimal expected) {
        FibonacciCounter fibonacciCounter = new FibonacciCounter(12);
        Assertions.assertEquals(expected, fibonacciCounter.calculateNthNumber(actualNth));
    }
}
