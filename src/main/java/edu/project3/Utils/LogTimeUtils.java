package edu.project3.Utils;

import edu.project3.LogRecord;
import java.time.OffsetDateTime;

public final class LogTimeUtils {
    private LogTimeUtils() {
    }

    public static boolean isLogBetweenFromAndTo(LogRecord logRecord, OffsetDateTime from, OffsetDateTime to) {
        return logRecord.requestTime().isAfter(from)
            && logRecord.requestTime().isBefore(to);
    }

    public static boolean isLogBeforeOrAfterDateTime(LogRecord logRecord, OffsetDateTime dateTime, boolean isBefore) {
        return isBefore ? logRecord.requestTime().isBefore(dateTime)
            : logRecord.requestTime().isAfter(dateTime);
    }
}
