package edu.hw5;

import edu.hw5.Task3.Task3;
import java.time.LocalDate;
import java.util.Optional;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

public class Task3Test {
    @Contract(" -> new")
    private static Arguments @NotNull [] getArgumentsDDMMYYY() {
        return new Arguments[] {
            Arguments.of("2020-10-10", Optional.of(LocalDate.of(2020, 10, 10))),
            Arguments.of("2020-12-2", Optional.of(LocalDate.of(2020, 12, 2))),
            Arguments.of("2020-2-2", Optional.of(LocalDate.of(2020, 2, 2))),
            Arguments.of("2020-2-20", Optional.of(LocalDate.of(2020, 2, 20))),
            Arguments.of("20-12-2", Optional.of(LocalDate.of(2020, 12, 2))),
            Arguments.of("00-7-2", Optional.of(LocalDate.of(2000, 7, 2)))
        };
    }

    @Contract(" -> new")
    private static Arguments @NotNull [] getArgumentsYYYYMMDD() {
        return new Arguments[] {
            Arguments.of("1/3/1976", Optional.of(LocalDate.of(1976, 3, 1))),
            Arguments.of("1/3/20", Optional.of(LocalDate.of(2020, 3, 1))),
            Arguments.of("01/10/20", Optional.of(LocalDate.of(2020, 10, 1))),
            Arguments.of("01/03/2020", Optional.of(LocalDate.of(2020, 3, 1)))
        };
    }

    @Contract(" -> new")
    private static Arguments @NotNull [] getArgumentsTodayTomorrowYesterday() {
        return new Arguments[] {
            Arguments.of("today", Optional.of(LocalDate.of(2023, 11, 9))),
            Arguments.of("tomorrow", Optional.of(LocalDate.of(2023, 11, 10))),
            Arguments.of("yesterday", Optional.of(LocalDate.of(2023, 11, 8)))
        };
    }

    @Contract(" -> new") private static Arguments @NotNull [] getArgumentsDaysAgoOrLater() {
        return new Arguments[] {
            Arguments.of("1 day ago", Optional.of(LocalDate.of(2023, 11, 8))),
            Arguments.of("6 day later", Optional.of(LocalDate.of(2023, 11, 15))),
            Arguments.of("4 months ago", Optional.of(LocalDate.of(2023, 7, 9))),
            Arguments.of("1 month later", Optional.of(LocalDate.of(2023, 12, 9))),
            Arguments.of("20 years ago", Optional.of(LocalDate.of(2003, 11, 9))),
            Arguments.of("10 years later", Optional.of(LocalDate.of(2033, 11, 9)))
        };
    }

    @ParameterizedTest
    @MethodSource(value = "getArgumentsDDMMYYY")
    @DisplayName("Format dd-MM-yyyy (valid)")
    public void dateFormatYearMonthDayValid(String data, Optional<LocalDate> expected) {
        Assertions.assertEquals(expected, Task3.parseDate(data));
    }

    @ParameterizedTest
    @CsvSource(value = {
        "2020-10-40",
        "2020-30-10",
        "2020--10",
        "2020",
        "2020-10-001",
        "idgskfbgvey"
    })
    @NullAndEmptySource
    @DisplayName("Format dd-MM-yyyy (invalid)")
    public void DateFormatYearMonthDayInvalid(String data) {
        Assertions.assertEquals(Optional.empty(), Task3.parseDate(data));
    }

    @ParameterizedTest
    @MethodSource(value = "getArgumentsYYYYMMDD")
    @DisplayName("Format yyyy/MM/dd (valid)")
    public void dateFormatDayMonthYearValid(String data, Optional<LocalDate> expected) {
        Assertions.assertEquals(expected, Task3.parseDate(data));
    }

    @ParameterizedTest
    @CsvSource(value = {
        "1/30/1976",
        "40/1/1987",
        "/1/1980",
        "//1987",
        "001/3/20",
        "bgkngdfbkgugdf"
    })
    @NullAndEmptySource
    @DisplayName("Format yyyy/MM/dd (invalid)")
    public void dateFormatDayMonthYearInvalid(String data) {
        Assertions.assertEquals(Optional.empty(), Task3.parseDate(data));
    }

    @ParameterizedTest
    @MethodSource(value = "getArgumentsTodayTomorrowYesterday")
    @DisplayName("Format tomorrow or today or yesterday (valid)")
    public void dateFormatTodayTomorrowYesterdayValid(String data, Optional<LocalDate> expected) {
        Assertions.assertEquals(expected, Task3.parseDate(data));
    }

    @ParameterizedTest
    @CsvSource(value = {
        "todoy",
        "tomorrows",
        "yesttrday",
        "123"
    })
    @NullAndEmptySource
    @DisplayName("Format tomorrow or today or yesterday (invalid)")
    public void dateFormatTodayTomorrowYesterdayInvalid(String data) {
        Assertions.assertEquals(Optional.empty(), Task3.parseDate(data));
    }

    @ParameterizedTest
    @MethodSource(value = "getArgumentsDaysAgoOrLater")
    @DisplayName("Format some days or months or years ago or later (valid)")
    public void dateFormatDaysAgoOrLaterValid(String data, Optional<LocalDate> expected) {
        Assertions.assertEquals(expected, Task3.parseDate(data));
    }

    @ParameterizedTest
    @CsvSource(value = {
        "-1 day ago",
        "1 day",
        "10000 yer ago",
        "1 day before",
        "3uv4tyb34"
    })
    @NullAndEmptySource
    @DisplayName("Format some days or months or years ago or later (invalid)")
    public void dateFormatDaysAgoOrLaterInvalid(String data) {
        Assertions.assertEquals(Optional.empty(), Task3.parseDate(data));
    }
}
