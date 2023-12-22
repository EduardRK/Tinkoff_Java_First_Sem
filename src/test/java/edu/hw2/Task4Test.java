package edu.hw2;

import edu.hw2.task4.CallingInfo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Task4Test {

    @Test
    @DisplayName("Calling info: class and method #1")
    public void classAndMethod() {
        CallingInfo callingInfo = CallingInfo.getInstance();

        String expectedClass = "edu.hw2.Task4Test";
        String expectedMethod = "classAndMethod";

        Assertions.assertEquals(expectedClass, callingInfo.className());
        Assertions.assertEquals(expectedMethod, callingInfo.methodName());
    }

    @Test
    @DisplayName("Calling info: class and method #2")
    public void sameClassOtherMethod() {
        CallingInfo callingInfo = CallingInfo.getInstance();

        String expectedClass = "edu.hw2.Task4Test";
        String expectedMethod = "sameClassOtherMethod";

        Assertions.assertEquals(expectedClass, callingInfo.className());
        Assertions.assertEquals(expectedMethod, callingInfo.methodName());
    }
}
