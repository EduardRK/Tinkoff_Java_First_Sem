package edu.hw5;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;

public final class Task2 {
    private static final int COUNT_OF_MONTH_IN_YEAR = 12;
    private static final int THIRTEEN_DAY_IN_MONTH = 13;

    private Task2() {
    }

    public static List<LocalDate> allFridaysThirteenThisYear(int year) {
        List<LocalDate> fridaysThirteen = new ArrayList<>();
        LocalDate date = LocalDate.of(year, Month.JANUARY, THIRTEEN_DAY_IN_MONTH);

        for (int i = 0; i < COUNT_OF_MONTH_IN_YEAR; ++i) {
            if (date.getDayOfWeek() == DayOfWeek.FRIDAY) {
                fridaysThirteen.add(date);
            }
            date = date.plusMonths(1);
        }

        return fridaysThirteen;
    }

    public static LocalDate nextFridayThirteenth(LocalDate date) {
        TemporalAdjuster nextFriday = TemporalAdjusters.next(DayOfWeek.FRIDAY);
        LocalDate nextFridayThirteen = date;

        do {
            nextFridayThirteen = nextFridayThirteen.with(nextFriday);
        }
        while ((nextFridayThirteen.getDayOfWeek() != DayOfWeek.FRIDAY)
            || (nextFridayThirteen.getDayOfMonth() != THIRTEEN_DAY_IN_MONTH));

        return nextFridayThirteen;
    }
}
