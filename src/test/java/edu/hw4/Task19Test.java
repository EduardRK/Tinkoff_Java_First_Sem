package edu.hw4;

import edu.hw4.Tasks.Task19;
import edu.hw4.ValidationError.ValidationError;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Task19Test {
    @Test
    @DisplayName("Some animals with error")
    public void someAnimalsWithError() {
        Animal kik = new Animal("Kik", Animal.Type.DOG, Animal.Sex.M, 10, 70, 60, true);
        Animal doggy = new Animal("Doggy", Animal.Type.DOG, Animal.Sex.M, 12, 30, 50, false);
        Animal fisheron = new Animal("Fisheron", Animal.Type.FISH, Animal.Sex.M, 19, 100, 101, true);
        Animal sam = new Animal("Sam", Animal.Type.CAT, Animal.Sex.M, 7, 49, 12, true);
        Animal oz = new Animal("Oz", Animal.Type.BIRD, Animal.Sex.M, 21, 30, 8, false);

        Animal broodMother = new Animal("Brood Mother", Animal.Type.SPIDER, Animal.Sex.F, 56, 150, 40, true);
        Animal a = new Animal("A", Animal.Type.FISH, Animal.Sex.M, 0, 0, 90, true);
        Animal jadeBird = new Animal("Jade Bird", Animal.Type.BIRD, Animal.Sex.F, 19, 3_000, 9_000, false);
        Animal ladyCat = new Animal("Lady Cat", Animal.Type.CAT, Animal.Sex.F, 3_000, -12, 90, false);
        Animal fishka = new Animal("Fishka", Animal.Type.FISH, Animal.Sex.F, 10_000, 0, 0, true);
        Animal spider123 = new Animal("Spider 123", Animal.Type.SPIDER, Animal.Sex.M, 0, -90, 90_000, false);

        ValidationError ageError = new ValidationError("Age");
        ValidationError heightError = new ValidationError("Height");
        ValidationError weightError = new ValidationError("Weight");
        ValidationError nameError = new ValidationError("Name");

        List<Animal> animals = new ArrayList<>() {{
            add(kik);
            add(doggy);
            add(fisheron);
            add(sam);
            add(oz);
            add(broodMother);
            add(a);
            add(jadeBird);
            add(ladyCat);
            add(fishka);
            add(spider123);
        }};

        Map<String, Set<ValidationError>> actual = Task19.animalsWithErrors(animals);
        Map<String, Set<ValidationError>> expected = new HashMap<>() {{
            put("A", new LinkedHashSet<>(List.of(ageError, heightError, nameError)));
            put("Brood Mother", new LinkedHashSet<>(List.of(heightError, weightError)));
            put("Lady Cat", new LinkedHashSet<>(List.of(ageError, heightError)));
            put("Jade Bird", new LinkedHashSet<>(List.of(heightError, weightError)));
            put("Spider 123", new LinkedHashSet<>(List.of(ageError, heightError, weightError, nameError)));
            put("Fishka", new LinkedHashSet<>(List.of(ageError, heightError, weightError)));
        }};

        for (String name : actual.keySet()) {
            List<ValidationError> expectedList = new ArrayList<>(expected.get(name));
            List<ValidationError> actualList = new ArrayList<>(actual.get(name));
            for (int i = 0; i < expectedList.size(); ++i) {
                Assertions.assertEquals(expectedList.get(i).getErrorField(), actualList.get(i).getErrorField());
            }
        }
    }

    @Test
    @DisplayName("No animals with error")
    public void noAnimalsWithError() {
        Animal kik = new Animal("Kik", Animal.Type.DOG, Animal.Sex.M, 10, 70, 60, true);
        Animal doggy = new Animal("Doggy", Animal.Type.DOG, Animal.Sex.M, 12, 30, 50, false);
        Animal fisheron = new Animal("Fisheron", Animal.Type.FISH, Animal.Sex.M, 19, 100, 101, true);
        Animal sam = new Animal("Sam", Animal.Type.CAT, Animal.Sex.M, 7, 49, 12, true);
        Animal oz = new Animal("Oz", Animal.Type.BIRD, Animal.Sex.M, 21, 30, 8, false);

        List<Animal> animals = new ArrayList<>() {{
            add(kik);
            add(doggy);
            add(fisheron);
            add(sam);
            add(oz);
        }};

        Map<String, Set<ValidationError>> actual = Task19.animalsWithErrors(animals);
        Map<String, Set<ValidationError>> expected = new HashMap<>();
        Assertions.assertEquals(expected, actual);
    }
}
