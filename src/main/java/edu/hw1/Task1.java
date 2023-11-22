package edu.hw1;

public final class Task1 {
    private static final int SECONDS_IN_MINUTE = 60;

    private Task1() {
    }

    private static boolean isTimestampCorrectFormat(String[] timestampArray) {
        return timestampArray.length == 2;
    }

    private static boolean isTimestampCorrectValues(int minutes, int seconds) {
        return (minutes >= 0) && (seconds >= 0) && (seconds < SECONDS_IN_MINUTE);
    }

    private static int timestampConvertToSeconds(int minutes, int seconds) {
        if (isTimestampCorrectValues(minutes, seconds)) {
            return minutes * SECONDS_IN_MINUTE + seconds;
        } else {
            return -1;
        }
    }

    public static int minutesToSeconds(String timestamp) {
        if ((Validator.isStringEmpty(timestamp))
            || (!timestamp.equals(timestamp.trim()))) {
            return -1;
        }
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
}
