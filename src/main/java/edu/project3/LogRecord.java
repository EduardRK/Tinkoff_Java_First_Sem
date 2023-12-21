package edu.project3;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public record LogRecord(
    String clientIPAddress,
    String clientID,
    OffsetDateTime requestTime,
    String requestType,
    String documentName,
    String protocol,
    int httpResponseCode,
    long responseSizeBytes,
    String referAddress,
    String userData
) {
    @Contract(" -> new")
    public @NotNull LocalDate convertOffsetDateTimeToLocalDate() {
        return LocalDate.of(requestTime.getYear(), requestTime.getMonth(), requestTime.getDayOfMonth());
    }
}
