package edu.hw3.task5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public final class Task5 {
    private static final int ASCII_CODE_FIRST_UPPER_CASE_LETTER = 65;
    private static final int ASCII_CODE_LAST_UPPER_CASE_LETTER = 90;
    private static final int ASCII_CODE_FIRST_LOWER_CASE_LETTER = 97;
    private static final int ASCII_CODE_LAST_LOWER_CASE_LETTER = 122;
    private static final int ASCII_CODE_SPACE = 32;
    private static final int ASCII_CODE_DASH = 45;

    private Task5() {
    }

    public static @NotNull List<Contact> parseContacts(List<String> contacts, Sort typeOfSort) {
        if (contacts == null || contacts.isEmpty()) {
            return new ArrayList<>();
        }

        if (!isCorrectContacts(contacts)) {
            throw new IllegalArgumentException();
        }

        List<Contact> contactsList = convertStringArrayToPersonArray(contacts);
        Collections.sort(contactsList);

        if (typeOfSort != Sort.ASC) {
            Collections.reverse(contactsList);
        }

        return contactsList;
    }

    private static boolean isCorrectContacts(@NotNull List<String> contacts) {
        for (String contact : contacts) {
            if (contact == null
                || contact.isEmpty()
                || !isContactHasFirstNameOrLastName(contact)
                || !isContactHasOnlyLetters(contact)) {
                return false;
            }
        }

        return true;
    }

    @Contract(pure = true)
    private static boolean isContactHasFirstNameOrLastName(@NotNull String contact) {
        String[] firstNameAndLastName = contact.split("\\s+");
        return firstNameAndLastName.length <= 2;
    }

    private static boolean isContactHasOnlyLetters(@NotNull String contact) {
        char[] contactArray = contact.toCharArray();

        for (char letter : contactArray) {
            if (!(isLetter(letter) || isSpecialSymbol(letter))) {
                return false;
            }
        }

        return true;
    }

    private static boolean isSpecialSymbol(char symbol) {
        return (int) symbol == ASCII_CODE_SPACE || (int) symbol == ASCII_CODE_DASH;
    }

    private static boolean isLetter(char letter) {
        return
            ((int) letter >= ASCII_CODE_FIRST_LOWER_CASE_LETTER
                && (int) letter <= ASCII_CODE_LAST_LOWER_CASE_LETTER)
                || ((int) letter >= ASCII_CODE_FIRST_UPPER_CASE_LETTER
                && (int) letter <= ASCII_CODE_LAST_UPPER_CASE_LETTER);
    }

    private static @NotNull List<Contact> convertStringArrayToPersonArray(@NotNull List<String> array) {
        List<Contact> personArrayList = new ArrayList<>();

        for (String contact : array) {
            personArrayList.add(new Contact(contact));
        }

        return personArrayList;
    }
}
