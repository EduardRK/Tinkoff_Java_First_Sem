package edu.hw5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Task5Test {
    @Test
    @DisplayName("Correct license plate")
    public void correctLicensePlate() {
        String licensePlate = "А123ВЕ777";
        Assertions.assertTrue(Task5.isValidRussianLicensePlate(licensePlate));

        licensePlate = "О777ОО177";
        Assertions.assertTrue(Task5.isValidRussianLicensePlate(licensePlate));

        licensePlate = "А123ЕВ07";
        Assertions.assertTrue(Task5.isValidRussianLicensePlate(licensePlate));

        licensePlate = "А999ВО17";
        Assertions.assertTrue(Task5.isValidRussianLicensePlate(licensePlate));
    }

    @Test
    @DisplayName("Incorrect license plate")
    public void incorrectLicensePlate() {
        String licensePlate = "";
        Assertions.assertFalse(Task5.isValidRussianLicensePlate(licensePlate));

        licensePlate = "123АВЕ777";
        Assertions.assertFalse(Task5.isValidRussianLicensePlate(licensePlate));

        licensePlate = "А123*ЕВ27";
        Assertions.assertFalse(Task5.isValidRussianLicensePlate(licensePlate));

        licensePlate = "А123ВЕ7777";
        Assertions.assertFalse(Task5.isValidRussianLicensePlate(licensePlate));

        licensePlate = "ЫВИЫВРАИ123";
        Assertions.assertFalse(Task5.isValidRussianLicensePlate(licensePlate));

        licensePlate = "А123ШЙ7777";
        Assertions.assertFalse(Task5.isValidRussianLicensePlate(licensePlate));
    }
}
