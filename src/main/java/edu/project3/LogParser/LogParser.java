package edu.project3.LogParser;

import edu.project3.LogRecord;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogParser implements Parser {
    private final static String LOG_FORMAT = "^(\\S+)\\s-\\s(\\S*)\\s\\[(.*)]\\s\"(\\S+)\\s(\\S+)\\s([^\"]+)\""
        + "\\s(\\d+)\\s(\\d+)\\s\"([^\"]+)\"\\s\"([^\"]+)\"$";
    private final static DateTimeFormatter FORMATTER =
        DateTimeFormatter.ofPattern("d/MMM/yyyy:H:m:s Z", Locale.ENGLISH);

    private final static int GROUP_OF_CLIENT_IP_ADDRESS = 1;
    private final static int GROUP_OF_CLIENT_ID = 2;
    private final static int GROUP_OF_REQUEST_TIME = 3;
    private final static int GROUP_OF_REQUEST_TYPE = 4;
    private final static int GROUP_OF_DOCUMENT_NAME = 5;
    private final static int GROUP_OF_PROTOCOL = 6;
    private final static int GROUP_OF_HTTP_RESPONSE_CODE = 7;
    private final static int GROUP_OF_RESPONSE_SIZE_BYTES = 8;
    private final static int GROUP_OF_REFER_ADDRESS = 9;
    private final static int GROUP_OF_USER_DATA = 10;

    public LogParser() {
    }

    @Override
    public LogRecord parse(String logString) {
        if (isValidLog(logString)) {
            Matcher matcher = Pattern.compile(LOG_FORMAT).matcher(logString);
            if (matcher.find()) {
                return new LogRecord(
                    matcher.group(GROUP_OF_CLIENT_IP_ADDRESS),
                    matcher.group(GROUP_OF_CLIENT_ID),
                    OffsetDateTime.parse(matcher.group(GROUP_OF_REQUEST_TIME), FORMATTER),
                    matcher.group(GROUP_OF_REQUEST_TYPE),
                    matcher.group(GROUP_OF_DOCUMENT_NAME),
                    matcher.group(GROUP_OF_PROTOCOL),
                    Integer.parseInt(matcher.group(GROUP_OF_HTTP_RESPONSE_CODE)),
                    Integer.parseInt(matcher.group(GROUP_OF_RESPONSE_SIZE_BYTES)),
                    matcher.group(GROUP_OF_REFER_ADDRESS),
                    matcher.group(GROUP_OF_USER_DATA)
                );
            }
        }
        throw new IllegalArgumentException("Wrong log format");
    }

    private boolean isValidLog(String logString) {
        return Pattern.matches(LOG_FORMAT, logString);
    }
}
