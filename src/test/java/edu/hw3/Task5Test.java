package edu.hw3;

import edu.hw3.task5.Contact;
import edu.hw3.task5.Sort;
import edu.hw3.task5.Task5;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

public class Task5Test {
    @Contract(" -> new")
    private static Arguments @NotNull [] getASCArguments() {
        return new Arguments[] {
            Arguments.of(
                new ArrayList<>(List.of(
                    "John Locke",
                    "Thomas Aquinas",
                    "David Hume",
                    "Rene Descartes"
                )),
                new ArrayList<>(List.of(
                    new Contact("Thomas Aquinas"),
                    new Contact("Rene Descartes"),
                    new Contact("David Hume"),
                    new Contact("John Locke")
                ))
            ),
            Arguments.of(
                new ArrayList<>(List.of(
                    "John Locke",
                    "Thomas Aquinas",
                    "David Hume",
                    "Fischle",
                    "Rene Descartes",
                    "Dante"
                )),
                new ArrayList<>(List.of(
                    new Contact("Thomas Aquinas"),
                    new Contact("Dante"),
                    new Contact("Rene Descartes"),
                    new Contact("Fischle"),
                    new Contact("David Hume"),
                    new Contact("John Locke")
                ))
            ),
            Arguments.of(
                new ArrayList<>(List.of(
                    "John Locke",
                    "Thomas Aquinas",
                    "David Hume",
                    "Fischle",
                    "Rene Descartes",
                    "Dante"
                )),
                new ArrayList<>(List.of(
                    new Contact("Thomas Aquinas"),
                    new Contact("Dante"),
                    new Contact("Rene Descartes"),
                    new Contact("Fischle"),
                    new Contact("David Hume"),
                    new Contact("John Locke")
                ))
            )
        };
    }

    @Contract(value = " -> new", pure = true)
    private static Arguments @NotNull [] getDESCArguments() {
        return new Arguments[] {
            Arguments.of(
                new ArrayList<>(List.of(
                    "Paul Erdos",
                    "Leonhard Euler",
                    "Carl Gauss"
                )),
                new ArrayList<>(List.of(
                    new Contact("Carl Gauss"),
                    new Contact("Leonhard Euler"),
                    new Contact("Paul Erdos")
                ))
            ),
            Arguments.of(
                new ArrayList<>(List.of(
                    "Paul Erdos",
                    "Leonhard Euler",
                    "Nikki Amuka-Bird",
                    "Carl Gauss",
                    "Lee Latchford-Evans"
                )),
                new ArrayList<>(List.of(
                    new Contact("Lee Latchford-Evans"),
                    new Contact("Carl Gauss"),
                    new Contact("Leonhard Euler"),
                    new Contact("Paul Erdos"),
                    new Contact("Nikki Amuka-Bird")
                ))
            ),
            Arguments.of(
                new ArrayList<>(List.of(
                    "Paul Erdos",
                    "Leonhard Euler",
                    "Nikki Amuka-Bird",
                    "Carl Gauss",
                    "Lee Latchford-Evans"
                )),
                new ArrayList<>(List.of(
                    new Contact("Lee Latchford-Evans"),
                    new Contact("Carl Gauss"),
                    new Contact("Leonhard Euler"),
                    new Contact("Paul Erdos"),
                    new Contact("Nikki Amuka-Bird")
                ))
            )
        };
    }

    @Contract(value = " -> new", pure = true)
    private static Arguments @NotNull [] getIllegalArguments() {
        return new Arguments[] {
            Arguments.of(new ArrayList<>(List.of(
                "John Locke",
                "Thomas Aquinas",
                "David Hume",
                "Rene Descartes",
                "Dante",
                "Fischle",
                ""
            ))),
            Arguments.of(new ArrayList<>(List.of(
                "John Locke",
                "Thomas Aquinas",
                "David Hume",
                "Rene Descartes",
                "Dante",
                "Fischle",
                "327 h865"
            ))),
            Arguments.of(new ArrayList<>(List.of(
                "John Locke",
                "Thomas Aquinas",
                "David Hume",
                "Rene Descartes",
                "Dante",
                "Fischle",
                "John Locke Bird"
            )))
        };
    }

    @ParameterizedTest
    @MethodSource(value = "getASCArguments")
    @DisplayName("Example test ASC")
    public void exampleTestASC(List<String> contacts, List<Contact> expected) {
        Assertions.assertEquals(expected, Task5.parseContacts(contacts, Sort.ASC));
    }

    @ParameterizedTest
    @MethodSource(value = "getDESCArguments")
    @DisplayName("Example test DESC")
    public void exampleTestDESC(List<String> contacts, List<Contact> expected) {
        Assertions.assertEquals(expected, Task5.parseContacts(contacts, Sort.DESC));
    }

    @ParameterizedTest
    @MethodSource(value = "getIllegalArguments")
    @DisplayName("Contact list with empty contact")
    public void contactListWithIllegalContact(List<String> contacts) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> Task5.parseContacts(contacts, Sort.ASC));
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("Null and empty list")
    public void nullContactList(List<String> contacts) {
        Assertions.assertEquals(new ArrayList<>(), Task5.parseContacts(contacts, Sort.ASC));
    }
}
