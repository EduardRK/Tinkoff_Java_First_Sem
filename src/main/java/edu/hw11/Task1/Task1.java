package edu.hw11.Task1;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.dynamic.loading.ClassLoadingStrategy;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.matcher.ElementMatchers;

public final class Task1 {
    private Task1() {
    }

    public static Class<?> createClass() {
        return new ByteBuddy()
            .subclass(Object.class)
            .method(ElementMatchers.named("toString"))
            .intercept(FixedValue.value("Hello, ByteBuddy!"))
            .make()
            .load(Object.class.getClassLoader(), ClassLoadingStrategy.Default.WRAPPER)
            .getLoaded();
    }
}
