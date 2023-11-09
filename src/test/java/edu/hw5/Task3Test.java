package edu.hw5;

import edu.hw5.Task3.Task3;
import java.time.LocalDate;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Task3Test {
    @Test
    @DisplayName("Format dd-MM-yyyy (valid)")
    public void dateFormatYearMonthDayValid() {
        String date = "2020-10-10";
        Optional<LocalDate> actual = Task3.parseDate(date);
        Optional<LocalDate> expected = Optional.of(LocalDate.of(2020, 10, 10));
        Assertions.assertEquals(expected, actual);

        date = "2020-12-2";
        actual = Task3.parseDate(date);
        expected = Optional.of(LocalDate.of(2020, 12, 2));
        Assertions.assertEquals(expected, actual);

        date = "2020-2-2";
        actual = Task3.parseDate(date);
        expected = Optional.of(LocalDate.of(2020, 2, 2));
        Assertions.assertEquals(expected, actual);

        date = "2020-2-20";
        actual = Task3.parseDate(date);
        expected = Optional.of(LocalDate.of(2020, 2, 20));
        Assertions.assertEquals(expected, actual);

        date = "20-12-2";
        actual = Task3.parseDate(date);
        expected = Optional.of(LocalDate.of(2020, 12, 2));
        Assertions.assertEquals(expected, actual);

        date = "00-7-2";
        actual = Task3.parseDate(date);
        expected = Optional.of(LocalDate.of(2000, 7, 2));
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Format dd-MM-yyyy (invalid)")
    public void DateFormatYearMonthDayInvalid() {
        String date = "2020-10-40";
        Optional<LocalDate> actual = Task3.parseDate(date);
        Optional<LocalDate> expected = Optional.empty();
        Assertions.assertEquals(expected, actual);

        date = "2020-30-10";
        actual = Task3.parseDate(date);
        Assertions.assertEquals(expected, actual);

        date = "2020--10";
        actual = Task3.parseDate(date);
        Assertions.assertEquals(expected, actual);

        date = "2020";
        actual = Task3.parseDate(date);
        Assertions.assertEquals(expected, actual);

        date = "2020-10-001";
        actual = Task3.parseDate(date);
        Assertions.assertEquals(expected, actual);

        date = "";
        actual = Task3.parseDate(date);
        Assertions.assertEquals(expected, actual);

        date = "idgskfbgvey";
        actual = Task3.parseDate(date);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Format yyyy/MM/dd (valid)")
    public void dateFormatDayMonthYearValid() {
        String date = "1/3/1976";
        Optional<LocalDate> actual = Task3.parseDate(date);
        Optional<LocalDate> expected = Optional.of(LocalDate.of(1976, 3, 1));
        Assertions.assertEquals(expected, actual);

        date = "1/3/20";
        actual = Task3.parseDate(date);
        expected = Optional.of(LocalDate.of(2020, 3, 1));
        Assertions.assertEquals(expected, actual);

        date = "01/10/20";
        actual = Task3.parseDate(date);
        expected = Optional.of(LocalDate.of(2020, 10, 1));
        Assertions.assertEquals(expected, actual);

        date = "01/03/2020";
        actual = Task3.parseDate(date);
        expected = Optional.of(LocalDate.of(2020, 3, 1));
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Format yyyy/MM/dd (invalid)")
    public void dateFormatDayMonthYearInvalid() {
        String date = "1/30/1976";
        Optional<LocalDate> actual = Task3.parseDate(date);
        Optional<LocalDate> expected = Optional.empty();
        Assertions.assertEquals(expected, actual);

        date = "40/1/1987";
        actual = Task3.parseDate(date);
        Assertions.assertEquals(expected, actual);

        date = "/1/1980";
        actual = Task3.parseDate(date);
        Assertions.assertEquals(expected, actual);

        date = "//1987";
        actual = Task3.parseDate(date);
        Assertions.assertEquals(expected, actual);

        date = "001/3/20";
        actual = Task3.parseDate(date);
        Assertions.assertEquals(expected, actual);

        date = "";
        actual = Task3.parseDate(date);
        Assertions.assertEquals(expected, actual);

        date = "bgkngdfbkgugdf";
        actual = Task3.parseDate(date);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Format tomorrow or today or yesterday (valid)")
    public void dateFormatTodayTomorrowYesterdayValid() {
        String date = "today";
        Optional<LocalDate> actual = Task3.parseDate(date);
        Optional<LocalDate> expected = Optional.of(LocalDate.of(2023, 11, 9));
        Assertions.assertEquals(expected, actual);

        date = "tomorrow";
        actual = Task3.parseDate(date);
        expected = Optional.of(LocalDate.of(2023, 11, 10));
        Assertions.assertEquals(expected, actual);

        date = "yesterday";
        actual = Task3.parseDate(date);
        expected = Optional.of(LocalDate.of(2023, 11, 8));
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Format tomorrow or today or yesterday (invalid)")
    public void dateFormatTodayTomorrowYesterdayInvalid() {
        String date = "todoy";
        Optional<LocalDate> actual = Task3.parseDate(date);
        Optional<LocalDate> expected = Optional.empty();
        Assertions.assertEquals(expected, actual);

        date = "tomorrows";
        actual = Task3.parseDate(date);
        Assertions.assertEquals(expected, actual);

        date = "yesttrday";
        actual = Task3.parseDate(date);
        Assertions.assertEquals(expected, actual);

        date = "";
        actual = Task3.parseDate(date);
        Assertions.assertEquals(expected, actual);

        date = "123";
        actual = Task3.parseDate(date);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Format some days or months or years ago or later (valid)")
    public void dateFormatDaysAgoOrLaterValid() {
        String date = "1 day ago";
        Optional<LocalDate> actual = Task3.parseDate(date);
        Optional<LocalDate> expected = Optional.of(LocalDate.of(2023, 11, 8));
        Assertions.assertEquals(expected, actual);

        date = "6 day later";
        actual = Task3.parseDate(date);
        expected = Optional.of(LocalDate.of(2023, 11, 15));
        Assertions.assertEquals(expected, actual);

        date = "4 months ago";
        actual = Task3.parseDate(date);
        expected = Optional.of(LocalDate.of(2023, 7, 9));
        Assertions.assertEquals(expected, actual);

        date = "1 month later";
        actual = Task3.parseDate(date);
        expected = Optional.of(LocalDate.of(2023, 12, 9));
        Assertions.assertEquals(expected, actual);

        date = "20 years ago";
        actual = Task3.parseDate(date);
        expected = Optional.of(LocalDate.of(2003, 11, 9));
        Assertions.assertEquals(expected, actual);

        date = "10 years later";
        actual = Task3.parseDate(date);
        expected = Optional.of(LocalDate.of(2033, 11, 9));
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Format some days or months or years ago or later (invalid)")
    public void dateFormatDaysAgoOrLaterInvalid() {
        String date = "-1 day ago";
        Optional<LocalDate> actual = Task3.parseDate(date);
        Optional<LocalDate> expected = Optional.empty();
        Assertions.assertEquals(expected, actual);

        date = "1 day";
        actual = Task3.parseDate(date);
        Assertions.assertEquals(expected, actual);

        date = "10000 yer ago";
        actual = Task3.parseDate(date);
        Assertions.assertEquals(expected, actual);

        date = "1 day before";
        actual = Task3.parseDate(date);
        Assertions.assertEquals(expected, actual);

        date = "";
        actual = Task3.parseDate(date);
        Assertions.assertEquals(expected, actual);

        date = "3uv4tyb34";
        actual = Task3.parseDate(date);
        Assertions.assertEquals(expected, actual);
    }
}
