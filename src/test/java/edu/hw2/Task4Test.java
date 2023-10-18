package edu.hw2;

import edu.hw2.task4.CallingInfo;
import edu.hw2.task4.Utility;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Task4Test {

    @Test
    @DisplayName("Calling info: class and method #1")
    public void classAndMethod() {
        CallingInfo callingInfo = Utility.callingInfo();
        var actualClass = callingInfo.className();
        var actualMethod = callingInfo.methodName();
        String expectedClass = "edu.hw2.Task4Test";
        String expectedMethod = "classAndMethod";

        Assertions.assertEquals(expectedClass, actualClass);
        Assertions.assertEquals(expectedMethod, actualMethod);
    }

    @Test
    @DisplayName("Calling info: class and method#1")
    public void sameClassOtherMethod() {
        CallingInfo callingInfo = Utility.callingInfo();
        var actualClass = callingInfo.className();
        var actualMethod = callingInfo.methodName();
        String expectedClass = "edu.hw2.Task4Test";
        String expectedMethod = "sameClassOtherMethod";

        Assertions.assertEquals(expectedClass, actualClass);
        Assertions.assertEquals(expectedMethod, actualMethod);
    }
}
