package edu.hw11;

import edu.hw11.Task3.FibonacciCounterExample;
import edu.hw11.Task3.FibonacciCounterGenerator;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class Task3Test {
    @ParameterizedTest
    @CsvSource(value = {
        "0, 0",
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
        "15, 610",
        "20, 6765"
    })
    public void fibonacciCounterExample(int n, long expected) {
        Assertions.assertEquals(expected, FibonacciCounterExample.fib(n));
    }

    @ParameterizedTest
    @CsvSource(value = {
        "0, 0",
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
        "15, 610",
        "20, 6765"
    })
    public void fibonacciCounterAppender(int n, long expected)
        throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<?> fibonacciCounter = FibonacciCounterGenerator.create();
        Method fib = fibonacciCounter.getMethod("fib", int.class);
        Assertions.assertEquals(expected, fib.invoke(fibonacciCounter, n));
    }
}
