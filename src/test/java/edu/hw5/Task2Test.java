package edu.hw5;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Task2Test {
    @Test
    @DisplayName("All fridays are the 13th of the year")
    public void allFridaysThirteenThisYear() {
        List<LocalDate> actual = Task2.allFridaysThirteenThisYear(1925);
        List<LocalDate> expected = new ArrayList<>() {{
            add(LocalDate.of(1925, 2, 13));
            add(LocalDate.of(1925, 3, 13));
            add(LocalDate.of(1925, 11, 13));
        }};

        Assertions.assertEquals(expected, actual);

        actual = Task2.allFridaysThirteenThisYear(2024);
        expected = new ArrayList<>() {{
            add(LocalDate.of(2024, 9, 13));
            add(LocalDate.of(2024, 12, 13));
        }};

        Assertions.assertEquals(expected, actual);

        actual = Task2.allFridaysThirteenThisYear(2000);
        expected = new ArrayList<>() {{
            add(LocalDate.of(2000, 10, 13));
        }};

        Assertions.assertEquals(expected, actual);

        actual = Task2.allFridaysThirteenThisYear(1826);
        expected = new ArrayList<>() {{
            add(LocalDate.of(1826, 1, 13));
            add(LocalDate.of(1826, 10, 13));
        }};

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Next friday are 13th")
    public void nextFridayThirteenth() {
        LocalDate actual = Task2.nextFridayThirteenth(LocalDate.of(2024, 11, 17));
        LocalDate expected = LocalDate.of(2024, 12, 13);
        Assertions.assertEquals(expected, actual);

        actual = Task2.nextFridayThirteenth(LocalDate.of(2000, 1, 1));
        expected = LocalDate.of(2000, 10, 13);
        Assertions.assertEquals(expected, actual);

        actual = Task2.nextFridayThirteenth(LocalDate.of(2024, 9, 13));
        expected = LocalDate.of(2024, 12, 13);
        Assertions.assertEquals(expected, actual);
    }
}
