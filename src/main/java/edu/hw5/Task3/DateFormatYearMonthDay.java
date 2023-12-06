package edu.hw5.Task3;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Optional;

public class DateFormatYearMonthDay extends DateFormat {
    private static final String REGEX = "^(\\d{2})(\\d{2})?-((0?[1-9]|1[012])-(0?[1-9]|[12]\\d)"
        + "|(0?[1-9]|1[012])-30|(0?[13578]|1[02])-31)$";
    private static final DateTimeFormatter FORMATTER = new DateTimeFormatterBuilder()
        .append(DateTimeFormatter.ofPattern("[yyyy-M-d]" + "[yy-M-d]"))
        .toFormatter();

    @Override
    public Optional<LocalDate> parseDateFormat(String dateFormat) {
        if (isValidFormat(REGEX, dateFormat)) {
            return Optional.of(LocalDate.parse(dateFormat, FORMATTER));
        } else if (nextDateFormat != null) {
            return nextDateFormat.parseDateFormat(dateFormat);
        }
        return Optional.empty();
    }
}
