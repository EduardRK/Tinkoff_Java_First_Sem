package edu.project3.LogReader;

import edu.project3.LogParser.LogParser;
import edu.project3.LogRecord;
import edu.project3.Utils.LogTimeUtils;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;

@SuppressWarnings("RegexpSinglelineJava")
public class LogURIReader implements LogReader {
    //    private final static Logger LOGGER = LogManager.getLogger();
    private final String uri;
    private final LogParser logParser;

    public LogURIReader(String uri) {
        this.uri = uri;
        this.logParser = new LogParser();
    }

    @Override
    public List<LogRecord> readLogs(LocalDate from, LocalDate to) {
        String[] logs = gettingLogsByURI();
        List<LogRecord> logRecordList = new ArrayList<>();
        for (String log : logs) {
            LogRecord logRecord = logParser.parse(log);
            if (LogTimeUtils.isLogBetweenFromAndTo(
                logRecord,
                OffsetDateTime.of(LocalDateTime.of(from, LocalTime.of(0, 0, 0)), ZoneOffset.UTC),
                OffsetDateTime.of(LocalDateTime.of(to, LocalTime.of(0, 0, 0)), ZoneOffset.UTC)
            )
            ) {
                logRecordList.add(logRecord);
            }
        }
        return logRecordList;
    }

    @Override
    public List<LogRecord> readLogs(LocalDate dateTime, boolean isBefore) {
        String[] logs = gettingLogsByURI();
        List<LogRecord> logRecordList = new ArrayList<>();
        for (String log : logs) {
            LogRecord logRecord = logParser.parse(log);
            if (LogTimeUtils.isLogBeforeOrAfterDateTime(
                logRecord,
                OffsetDateTime.of(LocalDateTime.of(dateTime, LocalTime.of(0, 0, 0)), ZoneOffset.UTC),
                isBefore
            )) {
                logRecordList.add(logRecord);
            }
        }
        return logRecordList;
    }

    @Override
    public List<LogRecord> readLogs() {
        String[] logs = gettingLogsByURI();
        List<LogRecord> logRecordList = new ArrayList<>();
        for (String log : logs) {
            logRecordList.add(logParser.parse(log));
        }
        return logRecordList;
    }

    private String @NotNull [] gettingLogsByURI() {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(this.uri))
                .GET()
                .header("Content-Type", "application/json")
                .build();

            HttpResponse<String> response
                = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

            return response.body().split("\n");
        } catch (URISyntaxException e) {
//            LOGGER.info("Wrong URI: " + e);
            System.out.println("Wrong URI" + e);
            throw new RuntimeException(e);
        } catch (IOException | InterruptedException e) {
//            LOGGER.info("Connection error: " + e);
            System.out.println("Connection error" + e);
            throw new RuntimeException(e);
        }
    }
}
