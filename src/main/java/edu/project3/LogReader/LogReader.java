package edu.project3.LogReader;

import edu.project3.LogRecord;
import java.time.LocalDate;
import java.util.List;

public interface LogReader {
    List<LogRecord> readLogs(LocalDate from, LocalDate to);

    List<LogRecord> readLogs(LocalDate dateTime, boolean isBefore);

    List<LogRecord> readLogs();
}
