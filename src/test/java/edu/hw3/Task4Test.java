package edu.hw3;

import edu.hw3.task4.Task4;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class Task4Test {

    @ParameterizedTest
    @CsvSource(value = {
        "2, II",
        "12, XII",
        "16, XVI",
        "341, CCCXLI",
        "620, DCXX",
        "948, CMXLVIII",
        "2389, MMCCCLXXXIX",
        "2619, MMDCXIX",
        "3989, MMMCMLXXXIX"
    })
    @DisplayName("Example test")
    public void exampleTest(int number, String romanNumber) {
        Assertions.assertEquals(romanNumber, Task4.convertToRoman(number));
    }

    @Test
    @DisplayName("Negative and zero numbers")
    public void negativeNumber() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> Task4.convertToRoman(-19));
        Assertions.assertThrows(IllegalArgumentException.class, () -> Task4.convertToRoman(0));
    }
}
