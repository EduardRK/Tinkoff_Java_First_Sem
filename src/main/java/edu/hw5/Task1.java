package edu.hw5;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.regex.Pattern;

public class Task1 {
    private Task1() {
    }

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd, HH:mm");
    private static final String REGEX = "(^(((\\d\\d)(([02468][048])|([13579][26]))-02-29)|(((\\d\\d)(\\d\\d)))-"
        + "((((0\\d)|(1[0-2]))-((0\\d)|(1\\d)|(2[0-8])))|((((0[13578])|(1[02]))-31)|(((0[1,3-9])|(1[0-2]))-"
        + "(29|30))))),\\s(([01]\\d|2[0-3]):([0-5]\\d))\\s-\\s(((\\d\\d)(([02468][048])|([13579][26]))-02-29)"
        + "|(((\\d\\d)(\\d\\d)))-((((0\\d)|(1[0-2]))-((0\\d)|(1\\d)|(2[0-8])))|((((0[13578])|(1[02]))-31)"
        + "|(((0[1,3-9])|(1[0-2]))-(29|30))))),\\s(([01]\\d|2[0-3]):([0-5]\\d))$)";

    public static Duration averageSession(List<String> sessions) {
        if (!isValidSessions(sessions)) {
            throw new IllegalArgumentException("Wrong sessions list");
        }

        Duration averageSession = Duration.ZERO;
        for (String session : sessions) {
            String[] sessionStartAndEnd = session.split("\\s-\\s");
            LocalDateTime start = LocalDateTime.parse(sessionStartAndEnd[0], FORMATTER);
            LocalDateTime end = LocalDateTime.parse(sessionStartAndEnd[1], FORMATTER);

            if (end.isBefore(start)) {
                throw new IllegalArgumentException("Wrong session duration");
            }

            averageSession = averageSession.plus(Duration.between(start, end));
        }
        return averageSession.dividedBy(sessions.size());
    }

    public static Duration averageSession(String... sessions) {
        return averageSession(List.of(sessions));
    }

    private static boolean isValidSessions(List<String> sessions) {
        for (String session : sessions) {
            if (!Pattern.matches(REGEX, session)) {
                return false;
            }
        }
        return true;
    }

}
