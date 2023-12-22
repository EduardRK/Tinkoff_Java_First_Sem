package edu.hw4.ValidationError;

import edu.hw4.Animal;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import org.jetbrains.annotations.NotNull;

public class ValidationError {
    private final String errorField;

    public ValidationError(String errorMessage) {
        this.errorField = errorMessage;
    }

    public static @NotNull Set<ValidationError> setOfValidationErrors(Animal animal) {
        Set<ValidationError> validationErrors = new LinkedHashSet<>();

        if (!ValidationErrorChecker.isAnimalAgeValid(animal)) {
            validationErrors.add(new ValidationError("Age"));
        }

        if (!ValidationErrorChecker.isAnimalHeightValid(animal)) {
            validationErrors.add(new ValidationError("Height"));
        }

        if (!ValidationErrorChecker.isAnimalWeightValid(animal)) {
            validationErrors.add(new ValidationError("Weight"));
        }

        if (!ValidationErrorChecker.isAnimalNameValid(animal)) {
            validationErrors.add(new ValidationError("Name"));
        }

        return validationErrors;
    }

    public String getErrorField() {
        return this.errorField;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        ValidationError validationError = (ValidationError) obj;
        return Objects.equals(errorField, validationError.getErrorField());
    }

    @Override
    public int hashCode() {
        return Objects.hash(errorField);
    }
}
