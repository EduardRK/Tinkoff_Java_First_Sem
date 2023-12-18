package edu.hw10.Task1;

import edu.hw10.Task1.Annotations.Max;
import edu.hw10.Task1.Annotations.Min;
import edu.hw10.Task1.Annotations.NotNull;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Arrays;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public class RandomObjectGenerator implements ObjectGenerator {
    private final ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
    private final Class<?> currentClass;

    public RandomObjectGenerator(Class<?> currentClass) {
        this.currentClass = currentClass;
    }

    @Override
    public Object nextObject() {
        Constructor<?>[] constructors = currentClass.getDeclaredConstructors();
        Constructor<?> constructor = constructors[threadLocalRandom.nextInt(constructors.length)];
        Parameter[] parameters = constructor.getParameters();

        try {
            if (parameters.length == 0) {
                return constructor.newInstance();
            }

            return constructor.newInstance(getArguments(parameters));
        } catch (InvocationTargetException | IllegalAccessException | InstantiationException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Object nextObject(String factoryMethod) {
        try {
            Method method = Arrays.stream(currentClass.getMethods())
                .filter(method1 -> method1.getName().equals(factoryMethod))
                .findFirst()
                .orElse(null);
            Parameter[] parameters = method.getParameters();

            return method.invoke(null, getArguments(parameters));
        } catch (InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    private Object[] getArguments(Parameter[] parameters) {
        Object[] arguments = new Object[parameters.length];
        int i = 0;
        for (Parameter parameter : parameters) {
            int max = Integer.MAX_VALUE;
            int min = Integer.MIN_VALUE;
            boolean canBeNull = true;

            Annotation[] annotations = parameter.getAnnotations();
            for (Annotation annotation : annotations) {
                if (annotation instanceof Max) {
                    max = ((Max) annotation).value();
                }
                if (annotation instanceof Min) {
                    min = ((Min) annotation).value();
                }
                if (annotation instanceof NotNull) {
                    canBeNull = false;
                }
            }

            if (parameter.getType().isPrimitive()) {
                arguments[i] = threadLocalRandom.nextInt(min, max);
            } else if (canBeNull) {
                int randomValue = threadLocalRandom.nextInt(0, 2);
                if (randomValue == 1) {
                    arguments[i] = null;
                } else {
                    arguments[i] = UUID.randomUUID().toString();
                }
            } else {
                arguments[i] = UUID.randomUUID().toString();
            }
            ++i;
        }
        return arguments;
    }
}
