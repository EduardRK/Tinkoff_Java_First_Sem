package edu.hw5;

import java.util.regex.Pattern;

public final class Task5 {
    private static final String REGEX = "^[АВЕКМНОРСТУХ]\\d{3}[АВЕКМНОРСТУХ]{2}\\d{2,3}$";

    private Task5() {

    }

    public static boolean isValidRussianLicensePlate(String licensePlate) {
        return Pattern.matches(REGEX, licensePlate);
    }
}
