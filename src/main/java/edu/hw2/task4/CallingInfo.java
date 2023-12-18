package edu.hw2.task4;

import org.jetbrains.annotations.NotNull;

public record CallingInfo(String className, String methodName) {
    public static @NotNull CallingInfo getInstance() {
        Throwable throwable = new Throwable();
        StackTraceElement[] stack = throwable.getStackTrace();
        return new CallingInfo(stack[1].getClassName(), stack[1].getMethodName());
    }
}
