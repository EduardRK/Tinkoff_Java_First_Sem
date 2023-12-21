package edu.project3.Utils;

import edu.project3.LogRecord;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public final class LogStatisticUtils {
    private LogStatisticUtils() {
    }

    public static Map<Object, Long> frequencyDictionary(
        @NotNull List<LogRecord> logRecordList,
        Function<LogRecord, Object> mapper
    ) {
        return logRecordList.stream()
            .map(mapper)
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public static double averageResponseSize(@NotNull List<LogRecord> logRecordList) {
        double allResponseSize = logRecordList.stream()
            .map(LogRecord::responseSizeBytes)
            .mapToDouble(Long::intValue)
            .sum();
        return allResponseSize / logRecordList.size();
    }

    @Contract(pure = true)
    public static int countRequest(@NotNull List<LogRecord> logRecordList) {
        return logRecordList.size();
    }

    public static @NotNull LocalDate startingDate(@NotNull List<LogRecord> logRecordList) {
        OffsetDateTime offsetDateTime = logRecordList.stream()
            .min(Comparator.comparing(LogRecord::requestTime))
            .get()
            .requestTime();

        return LocalDate.of(offsetDateTime.getYear(), offsetDateTime.getMonth(), offsetDateTime.getDayOfMonth());
    }

    public static @NotNull LocalDate endDate(@NotNull List<LogRecord> logRecordList) {
        OffsetDateTime offsetDateTime = logRecordList.stream()
            .max(Comparator.comparing(LogRecord::requestTime))
            .get()
            .requestTime();

        return LocalDate.of(offsetDateTime.getYear(), offsetDateTime.getMonth(), offsetDateTime.getDayOfMonth());
    }
}
