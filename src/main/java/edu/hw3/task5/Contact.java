package edu.hw3.task5;

import org.jetbrains.annotations.NotNull;

public class Contact implements Comparable<Contact> {
    private final String firstName;
    private final String lastName;

    public Contact(String fullName) {
        String[] splitFullName = fullName.split(" ");
        this.firstName = splitFullName[0];
        if (splitFullName.length == 2) {
            this.lastName = splitFullName[1];
        } else {
            this.lastName = "";
        }
    }

    @Override
    public int compareTo(@NotNull Contact other) {
        if (this.lastName.equalsIgnoreCase("") && !other.lastName.equalsIgnoreCase("")) {
            return this.firstName.compareToIgnoreCase(other.lastName);
        }

        if (!this.lastName.equalsIgnoreCase("") && other.lastName.equalsIgnoreCase("")) {
            return this.lastName.compareToIgnoreCase(other.firstName);
        }

        if (this.lastName.equalsIgnoreCase(other.lastName)) {
            return this.firstName.compareToIgnoreCase(other.firstName);
        }

        return this.lastName.compareToIgnoreCase(other.lastName);
    }
}
