package edu.hw11;

import edu.hw11.Task2.ArithmaticUtils.MultiArithmeticUtils;
import edu.hw11.Task2.ArithmaticUtils.SumArithmeticUtils;
import edu.hw11.Task2.Task2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Task2Test {
    @Test
    @DisplayName("Test switch method operation")
    public void switchMethodOperation() {
        int sum = SumArithmeticUtils.operation(5, 10);
        int multi = MultiArithmeticUtils.operation(5, 10);

        Task2.switchOperation();
        int sumAfterSwitch = SumArithmeticUtils.operation(5, 10);

        Assertions.assertNotEquals(sum, sumAfterSwitch);
        Assertions.assertEquals(multi, sumAfterSwitch);
    }
}
