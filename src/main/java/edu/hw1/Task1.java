package edu.hw1;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public final class Task1 {
    private static final int SECONDS_IN_MINUTE = 60;

    private Task1() {
    }

    public static int minutesToSeconds(String timestamp) {
        if (timestamp == null || timestamp.isEmpty()) {
            return -1;
        }

        timestamp = timestamp.trim();
        String[] timestampArray = timestamp.split(":");

        if (!isTimestampCorrectFormat(timestampArray)) {
            return -1;
        }

        try {
            int minutes = Integer.parseInt(timestampArray[0]);
            int seconds = Integer.parseInt(timestampArray[1]);
            return timestampConvertToSeconds(minutes, seconds);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static int timestampConvertToSeconds(int minutes, int seconds) {
        if (isTimestampCorrectValues(minutes, seconds)) {
            return minutes * SECONDS_IN_MINUTE + seconds;
        } else {
            return -1;
        }
    }

    @Contract(pure = true)
    private static boolean isTimestampCorrectFormat(String @NotNull [] timestampArray) {
        return timestampArray.length == 2;
    }

    private static boolean isTimestampCorrectValues(int minutes, int seconds) {
        return minutes >= 0
            && seconds >= 0
            && seconds < SECONDS_IN_MINUTE;
    }
}
