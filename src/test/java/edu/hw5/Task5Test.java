package edu.hw5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;

public class Task5Test {
    @ParameterizedTest
    @CsvSource(value = {
        "А123ВЕ777",
        "О777ОО177",
        "А123ЕВ07",
        "А999ВО17"
    })
    @DisplayName("Correct license plate")
    public void correctLicensePlate(String licensePlate) {
        Assertions.assertTrue(Task5.isValidRussianLicensePlate(licensePlate));
    }

    @ParameterizedTest
    @CsvSource(value = {
        "123АВЕ777",
        "А123*ЕВ27",
        "А123ВЕ7777",
        "ЫВИЫВРАИ123",
        "А123ШЙ7777"
    })
    @EmptySource
    @DisplayName("Incorrect license plate")
    public void incorrectLicensePlate(String licensePlate) {
        Assertions.assertFalse(Task5.isValidRussianLicensePlate(licensePlate));
    }
}
