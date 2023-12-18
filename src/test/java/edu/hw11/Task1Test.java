package edu.hw11;

import edu.hw11.Task1.Task1;
import java.lang.reflect.InvocationTargetException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Task1Test {
    @Test
    @DisplayName("Test class generator")
    public void classGenerator()
        throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> object = Task1.createClass();
        Assertions.assertEquals("Hello, ByteBuddy!", object.getDeclaredConstructor().newInstance().toString());
    }
}
