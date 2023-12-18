package edu.project3.Utils;

import edu.project3.LogRecord;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public final class LogStatisticUtils {
    private LogStatisticUtils() {
    }

    public static Map<Object, Long> frequencyDictionary(
        List<LogRecord> logRecordList,
        Function<LogRecord, Object> mapper
    ) {
        return logRecordList.stream()
            .map(mapper)
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public static double averageResponseSize(List<LogRecord> logRecordList) {
        double allResponseSize = logRecordList.stream()
            .map(LogRecord::responseSizeBytes)
            .mapToDouble(Long::intValue)
            .sum();
        return allResponseSize / logRecordList.size();
    }

    public static int countRequest(List<LogRecord> logRecordList) {
        return logRecordList.size();
    }

    public static LocalDate startingDate(List<LogRecord> logRecordList) {
        OffsetDateTime offsetDateTime = logRecordList.stream()
            .min(Comparator.comparing(LogRecord::requestTime))
            .get()
            .requestTime();

        return LocalDate.of(offsetDateTime.getYear(), offsetDateTime.getMonth(), offsetDateTime.getDayOfMonth());
    }

    public static LocalDate endDate(List<LogRecord> logRecordList) {
        OffsetDateTime offsetDateTime = logRecordList.stream()
            .max(Comparator.comparing(LogRecord::requestTime))
            .get()
            .requestTime();

        return LocalDate.of(offsetDateTime.getYear(), offsetDateTime.getMonth(), offsetDateTime.getDayOfMonth());
    }
}
