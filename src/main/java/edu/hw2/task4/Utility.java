package edu.hw2.task4;

public final class Utility {
    private Utility() {
    }

    public static CallingInfo callingInfo() {
        Throwable throwable = new Throwable();
        StackTraceElement[] stack = throwable.getStackTrace();
        return new CallingInfo(stack[1].getClassName(), stack[1].getMethodName());
    }
}
