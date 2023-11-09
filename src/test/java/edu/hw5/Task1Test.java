package edu.hw5;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Task1Test {
    @Test
    @DisplayName("Example test")
    public void exampleTest() {
        List<String> sessions = new ArrayList<>() {{
            add("2022-03-12, 20:20 - 2022-03-12, 23:50");
            add("2022-04-01, 21:30 - 2022-04-02, 01:20");
        }};
        Duration expected = Duration.of(220, ChronoUnit.MINUTES);
        Assertions.assertEquals(expected, Task1.averageSession(sessions));
    }

    @Test
    @DisplayName("Valid sessions (list)")
    public void validSessionsList() {
        List<String> sessions = new ArrayList<>() {{
            add("2022-03-12, 20:30 - 2022-03-12, 23:30");
            add("2022-04-01, 21:30 - 2022-04-01, 22:30");
            add("2022-07-22, 23:00 - 2022-07-23, 02:00");
            add("2000-01-02, 02:00 - 2000-01-02, 02:00");
            add("2022-03-12, 19:20 - 2022-03-12, 23:20");
            add("2007-12-31, 23:00 - 2008-01-01, 02:00");
            add("1987-02-02, 01:00 - 1987-02-02, 01:00");
        }};
        Duration expected = Duration.of(2, ChronoUnit.HOURS);
        Assertions.assertEquals(expected, Task1.averageSession(sessions));

        sessions = new ArrayList<>() {{
            add("2022-03-12, 20:20 - 2022-03-12, 23:50");
            add("2022-04-01, 14:23 - 2022-04-01, 17:21");
            add("2022-04-01, 15:34 - 2022-04-01, 19:59");
            add("2022-04-01, 02:17 - 2022-04-01, 10:00");
        }};
        expected = Duration.of(16740, ChronoUnit.SECONDS);
        Assertions.assertEquals(expected, Task1.averageSession(sessions));
    }

    @Test
    @DisplayName("Valid sessions (sequence)")
    public void validSessionsSequence() {
        Duration expected = Duration.of(2, ChronoUnit.HOURS);
        Duration actual = Task1.averageSession(
            "2022-03-12, 20:30 - 2022-03-12, 23:30",
            "2022-04-01, 21:30 - 2022-04-01, 22:30",
            "2022-07-22, 23:00 - 2022-07-23, 02:00",
            "2000-01-02, 02:00 - 2000-01-02, 02:00",
            "2022-03-12, 19:20 - 2022-03-12, 23:20",
            "2007-12-31, 23:00 - 2008-01-01, 02:00",
            "1987-02-02, 01:00 - 1987-02-02, 01:00"
        );
        Assertions.assertEquals(expected, actual);

        expected = Duration.of(16740, ChronoUnit.SECONDS);
        actual = Task1.averageSession(
            "2022-03-12, 20:20 - 2022-03-12, 23:50",
            "2022-04-01, 14:23 - 2022-04-01, 17:21",
            "2022-04-01, 15:34 - 2022-04-01, 19:59",
            "2022-04-01, 02:17 - 2022-04-01, 10:00"
        );
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Invalid sessions (format)")
    public void invalidSessionsFormat() {
        List<String> sessionsFirst = new ArrayList<>() {{
            add("2022-03-12, 20:30 - 2022-03-12, 23:30");
            add("2022-04-01, 21:30 - 2022-04-01, 22:30");
            add("2022-07-22, 23:00 - 2022-07-23, 02:00");
            add("2000-01-02, 02:00 - 2000-01-02, 02:00");
            add("2022-03-12, 19:20 - 2022-03-12, 23:20");
            add("2007-12-31 - 2008-01-01, 02:00");
            add("1987-02-02, 01:00 - 1987-02-02, 01:00");
        }};

        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Duration actual = Task1.averageSession(sessionsFirst);
        });

        List<String> sessionsSecond = new ArrayList<>() {{
            add("2022-03-12, 20:30 - 2022-03-12, 23:30");
            add("2022-04-01, 21:30 - 2022-04-01, 22:30");
            add("712854195194671");
            add("2000-01-02, 02:00 - 2000-01-02, 02:00");
            add("2022-03-12, 19:20 - 2022-03-12, 23:20");
            add("2007-12-31, 23:00 - 2008-01-01, 02:00");
            add("1987-02-02, 01:00 - 1987-02-02, 01:00");
        }};

        thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Duration actual = Task1.averageSession(sessionsSecond);
        });

        List<String> sessionsThird = new ArrayList<>() {{
            add("2022-03-12, 20:30 - 2022-03-12, 23:30");
            add("2022-04-01, 21:30 - 2022-04-01, 22:30");
            add("2022-07-22, 23:002022-07-23, 02:00");
            add("2000-01-02, 02:00 - 2000-01-02, 02:00");
            add("2022-03-12, 19:20 - 2022-03-12, 23:20");
            add("2007-12-31, 23:00 - 2008-01-01, 02:00");
            add("1987-02-02, 01:00 - 1987-02-02, 01:00");
        }};

        thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Duration actual = Task1.averageSession(sessionsThird);
        });
    }

    @Test
    @DisplayName("Wrong date")
    public void wrongDate() {
        List<String> sessionsFirst = new ArrayList<>() {{
            add("2022-13-12, 20:30 - 2022-03-12, 23:30");
            add("2022-04-01, 21:30 - 2022-04-01, 22:30");
            add("2022-07-22, 23:00 - 2022-07-23, 02:00");
            add("2000-01-02, 02:00 - 2000-01-02, 02:00");
            add("2022-03-12, 19:20 - 2022-03-12, 23:20");
            add("2007-12-31, 23:00 - 2008-01-01, 02:00");
            add("1987-02-02, 01:00 - 1987-02-02, 01:00");
        }};

        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Duration actual = Task1.averageSession(sessionsFirst);
        });

        List<String> sessionsSecond = new ArrayList<>() {{
            add("2022-03-12, 20:30 - 2022-03-12, 23:30");
            add("2022-04-01, 21:30 - 2022-04-01, 22:30");
            add("2022-07-22, 23:00 - 2022-07-23, 02:00");
            add("2000-01-02, 02:00 - 2000-01-02, 02:00");
            add("2022-03-41, 19:20 - 2022-03-12, 23:20");
            add("2007-12-31, 23:00 - 2008-01-01, 02:00");
            add("1987-02-02, 01:00 - 1987-02-02, 01:00");
        }};

        thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Duration actual = Task1.averageSession(sessionsSecond);
        });
    }

    @Test
    @DisplayName("Invalid sessions (Start after end)")
    public void invalidSessions() {
        List<String> sessions = new ArrayList<>() {{
            add("2022-03-12, 20:30 - 2022-03-12, 23:30");
            add("2022-04-01, 21:30 - 2022-04-01, 22:30");
            add("2022-07-22, 23:00 - 2022-07-23, 02:00");
            add("2000-01-02, 02:00 - 2000-01-02, 02:00");
            add("2022-03-12, 19:20 - 2022-03-12, 15:20");
            add("2007-12-31, 23:00 - 2008-01-01, 02:00");
            add("1987-02-02, 01:00 - 1987-02-02, 01:00");
        }};

        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Duration actual = Task1.averageSession(sessions);
        });
    }
}
