package edu.hw5.Task3;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Optional;

public class DateFormatDayMonthYear extends DateFormat {
    private static final String REGEX = "^(?:(?:31(\\/)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/)"
        + "(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$"
        + "|^(?:29(\\/)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])"
        + "|(?:(?:16|[2468][048]|[3579][26])00))))$"
        + "|^(?:0?[1-9]|1\\d|2[0-8])(\\/)(?:(?:0?[1-9])"
        + "|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";
    private static final DateTimeFormatter FORMATTER = new DateTimeFormatterBuilder()
        .append(DateTimeFormatter.ofPattern("[d/M/yyyy]" + "[d/M/yy]"))
        .toFormatter();

    @Override
    public Optional<LocalDate> parseDateFormat(String dateFormat) {
        if (dateFormat != null && isValidFormat(REGEX, dateFormat)) {
            return Optional.of(LocalDate.parse(dateFormat, FORMATTER));
        } else if (nextDateFormat != null) {
            return nextDateFormat.parseDateFormat(dateFormat);
        }

        return Optional.empty();
    }
}
