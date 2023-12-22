package edu.hw5.Task3;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateFormatDaysAgoOrLater extends DateFormat {
    private static final String REGEX = "^(\\d+)\\s+(days?|months?|years?)\\s+(ago|later)$";
    private static final LocalDate DATE = LocalDate.of(2023, 11, 9);
    private static final int GROUP_OF_COUNT = 1;
    private static final int GROUP_OF_PERIOD = 2;
    private static final int GROUP_OF_AGO_OR_LATER = 3;
    private static final String AGO = "ago";

    @Override
    public Optional<LocalDate> parseDateFormat(String dateFormat) {
        if (dateFormat != null && isValidFormat(REGEX, dateFormat)) {
            Matcher matcher = Pattern.compile(REGEX).matcher(dateFormat);

            if (matcher.find()) {
                int count = Integer.parseInt(matcher.group(GROUP_OF_COUNT));
                String period = matcher.group(GROUP_OF_PERIOD);
                String agoOrLater = matcher.group(GROUP_OF_AGO_OR_LATER);

                return switch (period) {
                    case "day", "days" -> (Objects.equals(agoOrLater, AGO) ? Optional.of(DATE.minusDays(count))
                        : Optional.of(DATE.plusDays(count)));
                    case "month", "months" -> (Objects.equals(agoOrLater, AGO) ? Optional.of(DATE.minusMonths(count))
                        : Optional.of(DATE.plusMonths(count)));
                    case "year", "years" -> (Objects.equals(agoOrLater, AGO) ? Optional.of(DATE.minusYears(count))
                        : Optional.of(DATE.plusYears(count)));
                    default -> Optional.empty();
                };
            }
        } else if (nextDateFormat != null) {
            return nextDateFormat.parseDateFormat(dateFormat);
        }

        return Optional.empty();
    }
}
