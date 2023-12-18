package edu.hw11.Task2;

import edu.hw11.Task2.ArithmaticUtils.MultiArithmeticUtils;
import edu.hw11.Task2.ArithmaticUtils.SumArithmeticUtils;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.agent.ByteBuddyAgent;
import net.bytebuddy.dynamic.loading.ClassReloadingStrategy;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.matcher.ElementMatchers;

public final class Task2 {
    private Task2() {
    }

    public static void switchOperation() {
        ByteBuddyAgent.install();

        new ByteBuddy()
            .redefine(SumArithmeticUtils.class)
            .method(ElementMatchers.named("operation"))
            .intercept(MethodDelegation.to(MultiArithmeticUtils.class))
            .make()
            .load(SumArithmeticUtils.class.getClassLoader(), ClassReloadingStrategy.fromInstalledAgent());
    }
}
