package edu.hw4.Tasks;

import edu.hw4.Animal;
import edu.hw4.ValidationError.ValidationError;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.jetbrains.annotations.NotNull;

public final class Task20 {
    private Task20() {
    }

    public static Map<String, String> animalsWithErrorsString(@NotNull List<Animal> animals) {
        return animals.stream()
            .filter(animal -> !ValidationError.setOfValidationErrors(animal).isEmpty())
            .collect(Collectors.toMap(Animal::name, animal -> {
                StringBuilder stringErrors = new StringBuilder();

                for (ValidationError error : ValidationError.setOfValidationErrors(animal)) {
                    stringErrors.append(error.getErrorField());
                }

                return new String(stringErrors);
            }));
    }
}
