package edu.hw5;

import java.util.regex.Pattern;

public class Task5 {
    private Task5() {

    }

    public static boolean isValidRussianLicensePlate(String licensePlate) {
        String regex = "^[АВЕКМНОРСТУХ]\\d{3}[АВЕКМНОРСТУХ]{2}\\d{2,3}$";
        return Pattern.matches(regex, licensePlate);
    }
}
