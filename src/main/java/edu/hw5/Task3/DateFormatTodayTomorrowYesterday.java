package edu.hw5.Task3;

import java.time.LocalDate;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateFormatTodayTomorrowYesterday extends DateFormat {
    private static final String REGEX = "^(tomorrow|today|yesterday)$";
    private static final LocalDate DATE = LocalDate.of(2023, 11, 9);

    @Override
    public Optional<LocalDate> parseDateFormat(String dateFormat) {
        if (dateFormat != null && isValidFormat(REGEX, dateFormat)) {
            Matcher matcher = Pattern.compile(REGEX).matcher(dateFormat);

            if (matcher.find()) {
                String todayOrTomorrowOrYesterday = matcher.group(1);

                return switch (todayOrTomorrowOrYesterday) {
                    case "today" -> Optional.of(DATE);
                    case "tomorrow" -> Optional.of(DATE.plusDays(1));
                    case "yesterday" -> Optional.of(DATE.minusDays(1));
                    default -> Optional.empty();
                };
            }
        } else if (nextDateFormat != null) {
            return nextDateFormat.parseDateFormat(dateFormat);
        }

        return Optional.empty();
    }
}
