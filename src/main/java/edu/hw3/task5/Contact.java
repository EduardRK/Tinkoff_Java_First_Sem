package edu.hw3.task5;

import java.util.Objects;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class Contact implements Comparable<Contact> {
    private final String firstName;
    private final String lastName;

    @Contract(pure = true)
    public Contact(@NotNull String fullName) {
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Contact contact = (Contact) obj;
        return Objects.equals(firstName, contact.firstName)
            && Objects.equals(lastName, contact.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }
}
