package edu.hw4;

import edu.hw4.Tasks.Task20;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Task20Test {
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

        Map<String, String> actual = Task20.animalsWithErrorsString(animals);
        Map<String, String> expected = new HashMap<>() {{
            put("A", "AgeHeightName");
            put("Brood Mother", "HeightWeight");
            put("Lady Cat", "AgeHeight");
            put("Jade Bird", "HeightWeight");
            put("Spider 123", "AgeHeightWeightName");
            put("Fishka", "AgeHeightWeight");
        }};

        for (String name : actual.keySet()) {
            Assertions.assertEquals(expected.get(name), actual.get(name));
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

        Map<String, String> actual = Task20.animalsWithErrorsString(animals);
        Map<String, String> expected = new HashMap<>();
        Assertions.assertEquals(expected, actual);
    }
}
