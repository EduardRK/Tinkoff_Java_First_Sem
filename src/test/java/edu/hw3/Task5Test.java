package edu.hw3;

import edu.hw3.task5.Contact;
import edu.hw3.task5.InvalidContactList;
import edu.hw3.task5.Sort;
import edu.hw3.task5.Task5;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Task5Test {
    @Test
    @DisplayName("Example test ASC")
    public void exampleTestASC() throws InvalidContactList {
        List<String> contacts = new ArrayList<>() {{
            add("John Locke");
            add("Thomas Aquinas");
            add("David Hume");
            add("Rene Descartes");
        }};

        var actual = Task5.parseContacts(contacts, Sort.ASC);
        List<Contact> expected = new ArrayList<>() {{
            add(new Contact("Thomas Aquinas"));
            add(new Contact("Rene Descartes"));
            add(new Contact("David Hume"));
            add(new Contact("John Locke"));
        }};
        for (int i = 0; i < actual.size(); ++i) {
            Assertions.assertEquals(0, expected.get(i).compareTo(actual.get(i)));
        }
    }

    @Test
    @DisplayName("Example test DESC")
    public void exampleTestDESC() throws InvalidContactList {
        List<String> contacts = new ArrayList<>() {{
            add("Paul Erdos");
            add("Leonhard Euler");
            add("Carl Gauss");
        }};

        var actual = Task5.parseContacts(contacts, Sort.DESC);
        List<Contact> expected = new ArrayList<>() {{
            add(new Contact("Carl Gauss"));
            add(new Contact("Leonhard Euler"));
            add(new Contact("Paul Erdos"));
        }};
        for (int i = 0; i < actual.size(); ++i) {
            Assertions.assertEquals(0, expected.get(i).compareTo(actual.get(i)));
        }
    }

    @Test
    @DisplayName("Contact list with double surname")
    public void contactListWithDoubleSurname() throws InvalidContactList {
        List<String> contacts = new ArrayList<>() {{
            add("Paul Erdos");
            add("Leonhard Euler");
            add("Nikki Amuka-Bird");
            add("Carl Gauss");
            add("Lee Latchford-Evans");
        }};

        var actual = Task5.parseContacts(contacts, Sort.DESC);
        List<Contact> expected = new ArrayList<>() {{
            add(new Contact("Lee Latchford-Evans"));
            add(new Contact("Carl Gauss"));
            add(new Contact("Leonhard Euler"));
            add(new Contact("Paul Erdos"));
            add(new Contact("Nikki Amuka-Bird"));
        }};
        for (int i = 0; i < actual.size(); ++i) {
            Assertions.assertEquals(0, expected.get(i).compareTo(actual.get(i)));
        }
    }

    @Test
    @DisplayName("Empty contact list")
    public void emptyContactList() throws InvalidContactList {
        List<String> contacts = new ArrayList<>();
        var actual1 = Task5.parseContacts(contacts, Sort.ASC);
        var expected = new ArrayList<>();
        Assertions.assertEquals(expected, actual1);

        actual1 = Task5.parseContacts(contacts, Sort.DESC);
        Assertions.assertEquals(expected, actual1);
    }

    @Test
    @DisplayName("Null contact list")
    public void nullContactList() throws InvalidContactList {
        var actual1 = Task5.parseContacts(null, Sort.ASC);
        var expected = new ArrayList<>();
        Assertions.assertEquals(expected, actual1);

        actual1 = Task5.parseContacts(null, Sort.DESC);
        Assertions.assertEquals(expected, actual1);
    }

    @Test
    @DisplayName("Contact list with first names")
    public void contactListWithFirstNamws() throws InvalidContactList {
        List<String> contacts = new ArrayList<>() {{
            add("John Locke");
            add("Thomas Aquinas");
            add("David Hume");
            add("Fischle");
            add("Rene Descartes");
            add("Dante");
        }};

        var actual = Task5.parseContacts(contacts, Sort.ASC);
        List<Contact> expected = new ArrayList<>() {{
            add(new Contact("Thomas Aquinas"));
            add(new Contact("Dante"));
            add(new Contact("Rene Descartes"));
            add(new Contact("Fischle"));
            add(new Contact("David Hume"));
            add(new Contact("John Locke"));
        }};
        for (int i = 0; i < actual.size(); ++i) {
            Assertions.assertEquals(0, expected.get(i).compareTo(actual.get(i)));
        }
    }

    @Test
    @DisplayName("Contact list with empty contact")
    public void contactListWithEmptyContact() throws InvalidContactList {
        List<String> contacts = new ArrayList<>() {{
            add("John Locke");
            add("Thomas Aquinas");
            add("David Hume");
            add("Rene Descartes");
            add("Dante");
            add("Fischle");
            add("");
        }};
        Assertions.assertThrows(InvalidContactList.class, () -> {
            List<Contact> actual = Task5.parseContacts(contacts, Sort.ASC);
        });
    }

    @Test
    @DisplayName("Contact list with null contact")
    public void contactListWithNullContact() throws InvalidContactList {
        List<String> contacts = new ArrayList<>() {{
            add("John Locke");
            add("Thomas Aquinas");
            add("David Hume");
            add("Rene Descartes");
            add("Dante");
            add("Fischle");
            add("");
        }};
        Assertions.assertThrows(InvalidContactList.class, () -> {
            List<Contact> actual = Task5.parseContacts(contacts, Sort.ASC);
        });
    }

    @Test
    @DisplayName("Contact list with incorrect contact")
    public void contactListWithIncorrectContact() throws InvalidContactList {
        List<String> contacts = new ArrayList<>() {{
            add("John Locke");
            add("Thomas Aquinas");
            add("David Hume");
            add("Rene Descartes");
            add("Dante");
            add("Fischle");
            add("213 !@sdf");
        }};
        Assertions.assertThrows(InvalidContactList.class, () -> {
            List<Contact> actual = Task5.parseContacts(contacts, Sort.ASC);
        });
    }

    @Test
    @DisplayName("Contact list with contact more than 3 words")
    public void contactListWithContactMoreThanThreeWords() throws InvalidContactList {
        List<String> contacts = new ArrayList<>() {{
            add("John Locke");
            add("Thomas Aquinas");
            add("David Hume");
            add("Rene Descartes");
            add("Dante");
            add("Fischle");
            add("John Locke Bird");
        }};
        Assertions.assertThrows(InvalidContactList.class, () -> {
            List<Contact> actual = Task5.parseContacts(contacts, Sort.ASC);
        });
    }
}
