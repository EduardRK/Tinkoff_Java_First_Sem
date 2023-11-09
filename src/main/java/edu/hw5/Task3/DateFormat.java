package edu.hw5.Task3;

import java.time.LocalDate;
import java.util.Optional;
import java.util.regex.Pattern;

public abstract class DateFormat {
    protected DateFormat nextDateFormat;

    public void setNextDateFormat(DateFormat nextDateFormat) {
        this.nextDateFormat = nextDateFormat;
    }

    protected boolean isValidFormat(String regex, String dateFormat) {
        return Pattern.matches(regex, dateFormat);
    }

    public abstract Optional<LocalDate> parseDateFormat(String dateFormat);
}
