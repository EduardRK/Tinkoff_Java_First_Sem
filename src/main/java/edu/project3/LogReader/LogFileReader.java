package edu.project3.LogReader;

import edu.project3.LogParser.LogParser;
import edu.project3.LogRecord;
import edu.project3.Utils.LogTimeUtils;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;

@SuppressWarnings("RegexpSinglelineJava")
public class LogFileReader implements LogReader {
    //    private final static Logger LOGGER = LogManager.getLogger();
    private final static String READ_ERROR = "Read error: ";
    private final Path filePath;
    private final LogParser logParser;

    public LogFileReader(Path filePath) {
        this.filePath = filePath;
        this.logParser = new LogParser();
    }

    @Override
    public List<LogRecord> readLogs(LocalDate from, LocalDate to) {
        List<LogRecord> logRecordList = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath.toFile()))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                LogRecord logRecord = logParser.parse(line);
                if (LogTimeUtils.isLogBetweenFromAndTo(
                    logRecord,
                    OffsetDateTime.of(LocalDateTime.of(from, LocalTime.of(0, 0, 0)), ZoneOffset.UTC),
                    OffsetDateTime.of(LocalDateTime.of(to, LocalTime.of(0, 0, 0)), ZoneOffset.UTC)
                )) {
                    logRecordList.add(logRecord);
                }
            }
        } catch (IOException e) {
//            LOGGER.info(READ_ERROR + e);
            System.out.println(READ_ERROR + e);
            throw new RuntimeException(e.getMessage());
        }
        return logRecordList;
    }

    @Override
    public List<LogRecord> readLogs(LocalDate dateTime, boolean isBefore) {
        List<LogRecord> logRecordList = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath.toFile()))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                LogRecord logRecord = logParser.parse(line);
                if (LogTimeUtils.isLogBeforeOrAfterDateTime(
                    logRecord,
                    OffsetDateTime.of(LocalDateTime.of(dateTime, LocalTime.of(0, 0, 0)), ZoneOffset.UTC),
                    isBefore
                )) {
                    logRecordList.add(logRecord);
                }
            }
        } catch (IOException e) {
//            LOGGER.info(READ_ERROR + e);
            System.out.println(READ_ERROR + e);
            throw new RuntimeException(e.getMessage());
        }
        return logRecordList;
    }

    @Override
    public List<LogRecord> readLogs() {
        List<LogRecord> logRecordList = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath.toFile()))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                logRecordList.add(logParser.parse(line));
            }
        } catch (IOException e) {
//            LOGGER.info(READ_ERROR + e);
            System.out.println(READ_ERROR + e);
            throw new RuntimeException(e);
        }
        return logRecordList;
    }
}
