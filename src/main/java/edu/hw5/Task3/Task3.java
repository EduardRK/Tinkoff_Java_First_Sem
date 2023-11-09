package edu.hw5.Task3;

import java.time.LocalDate;
import java.util.Optional;

public class Task3 {
    private Task3() {
    }

    public static Optional<LocalDate> parseDate(String string) {
        DateFormat dateFormat = createChainOfResponsibility();

        return dateFormat.parseDateFormat(string);
    }

    private static DateFormat createChainOfResponsibility() {
        DateFormat dateFormatDayMonthYear = new DateFormatDayMonthYear();
        DateFormat dateFormatYearMonthDay = new DateFormatYearMonthDay();
        DateFormat dateFormatTodayTomorrowYesterday = new DateFormatTodayTomorrowYesterday();
        DateFormat dateFormatDaysAgoOrLater = new DateFormatDaysAgoOrLater();

        dateFormatDayMonthYear.setNextDateFormat(dateFormatYearMonthDay);
        dateFormatYearMonthDay.setNextDateFormat(dateFormatTodayTomorrowYesterday);
        dateFormatTodayTomorrowYesterday.setNextDateFormat(dateFormatDaysAgoOrLater);
        dateFormatDaysAgoOrLater.setNextDateFormat(null);

        return dateFormatDayMonthYear;
    }
}
