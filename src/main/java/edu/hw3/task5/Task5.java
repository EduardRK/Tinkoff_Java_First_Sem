package edu.hw3.task5;

import edu.hw3.Validator;
import java.util.ArrayList;
import java.util.Collections;

public class Task5 {
    private static final int ASCII_CODE_FIRST_UPPER_CASE_LETTER = 65;
    private static final int ASCII_CODE_LAST_UPPER_CASE_LETTER = 90;
    private static final int ASCII_CODE_FIRST_LOWER_CASE_LETTER = 97;
    private static final int ASCII_CODE_LAST_LOWER_CASE_LETTER = 122;
    private static final int ASCII_CODE_SPACE = 32;
    private static final int ASCII_CODE_DASH = 45;

    private Task5() {
    }

    public static ArrayList<Contact> parseContacts(ArrayList<String> contacts, Sort typeOfSort)
        throws InvalidContactList {
        if (Validator.isArrayNull(contacts) || Validator.isArrayEmpty(contacts)) {
            return new ArrayList<>();
        }
        if (!isCorrectContacts(contacts)) {
            throw new InvalidContactList();
        }

        ArrayList<Contact> contactsList = convertStringArrayToPersonArray(contacts);
        Collections.sort(contactsList);
        if (typeOfSort == Sort.ASC) {
            return contactsList;
        } else {
            Collections.reverse(contactsList);
            return contactsList;
        }
    }

    private static boolean isCorrectContacts(ArrayList<String> contacts) {
        for (String contact : contacts) {
            if (Validator.isStringEmpty(contact)) {
                return false;
            } else if (!isContactHasFirstNameOrLastName(contact)) {
                return false;
            } else if (!isContactHasOnlyLetters(contact)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isContactHasFirstNameOrLastName(String contact) {
        String[] firstNameAndLastName = contact.split(" ");
        return firstNameAndLastName.length <= 2;
    }

    private static boolean isContactHasOnlyLetters(String contact) {
        char[] contactArray = contact.toCharArray();
        for (char letter : contactArray) {
            if (!(isLetter(letter) || isSpecialSymbol(letter))) {
                return false;
            }
        }
        return true;
    }

    private static boolean isSpecialSymbol(char symbol) {
        return ((int) symbol == ASCII_CODE_SPACE) || ((int) symbol == ASCII_CODE_DASH);
    }

    private static boolean isLetter(char letter) {
        return
            ((int) letter >= ASCII_CODE_FIRST_LOWER_CASE_LETTER
                && (int) letter <= ASCII_CODE_LAST_LOWER_CASE_LETTER)
                || ((int) letter >= ASCII_CODE_FIRST_UPPER_CASE_LETTER
                && (int) letter <= ASCII_CODE_LAST_UPPER_CASE_LETTER);
    }

    private static ArrayList<Contact> convertStringArrayToPersonArray(ArrayList<String> array) {
        ArrayList<Contact> personArrayList = new ArrayList<>();
        for (String contact : array) {
            personArrayList.add(new Contact(contact));
        }
        return personArrayList;
    }
}
