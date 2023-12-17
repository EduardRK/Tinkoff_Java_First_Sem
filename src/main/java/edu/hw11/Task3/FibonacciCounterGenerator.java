package edu.hw11.Task3;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.jar.asm.Opcodes;
import org.jetbrains.annotations.NotNull;

public class FibonacciCounterGenerator {
    private FibonacciCounterGenerator() {

    }

    public static @NotNull Class<?> create() {
        FibonacciCounterAppender fibonacciCounterAppender = new FibonacciCounterAppender();

        return new ByteBuddy()
            .subclass(Object.class)
            .name("FibonacciCounter")
            .defineMethod("fib", long.class, Opcodes.ACC_PUBLIC | Opcodes.ACC_STATIC)
            .withParameters(int.class)
            .intercept(new Implementation.Simple(fibonacciCounterAppender))
            .make()
            .load(FibonacciCounterGenerator.class.getClassLoader())
            .getLoaded();
    }
}
