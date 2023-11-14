package edu.hw4;

import edu.hw4.Tasks.Task3;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Task3Test {
    @Test
    @DisplayName("Counting the number of animals of each type")
    public void animalsOfEachType() {
        Animal kik = new Animal("Kik", Animal.Type.DOG, Animal.Sex.M, 10, 70, 50, true);
        Animal sam = new Animal("Sam", Animal.Type.CAT, Animal.Sex.M, 7, 49, 12, true);
        Animal oz = new Animal("Oz", Animal.Type.BIRD, Animal.Sex.M, 21, 30, 8, false);
        Animal broodMother = new Animal("BroodMother", Animal.Type.SPIDER, Animal.Sex.F, 56, 150, 40, true);
        Animal kokomi = new Animal("Kokomi", Animal.Type.FISH, Animal.Sex.F, 17, 160, 45, false);
        Animal liza = new Animal("Liza", Animal.Type.DOG, Animal.Sex.F, 1, 30, 4, true);
        Animal veryBigName = new Animal("VeryBigNameAnimal", Animal.Type.CAT, Animal.Sex.F, 6, 64, 8, true);
        Animal smallBird = new Animal("SmallBird", Animal.Type.BIRD, Animal.Sex.F, 3, 10, 1, false);

        List<Animal> animals = new ArrayList<>() {{
            add(kik);
            add(sam);
            add(oz);
            add(broodMother);
            add(kokomi);
            add(liza);
            add(veryBigName);
            add(smallBird);
        }};

        Map<Animal.Type, Integer> numberOfEachType = Task3.animalsOfEachType(animals);
        Map<Animal.Type, Integer> expected = new HashMap<>() {{
            put(Animal.Type.SPIDER, 1);
            put(Animal.Type.DOG, 2);
            put(Animal.Type.CAT, 2);
            put(Animal.Type.BIRD, 2);
            put(Animal.Type.FISH, 1);
        }};
        for (Animal.Type type : numberOfEachType.keySet()) {
            Assertions.assertEquals(expected.get(type), numberOfEachType.get(type));
        }
    }

    @Test
    @DisplayName("Missing some types animals")
    public void missingSomeTypesAnimals() {
        Animal kik = new Animal("Kik", Animal.Type.DOG, Animal.Sex.M, 10, 70, 50, true);
        Animal oz = new Animal("Oz", Animal.Type.BIRD, Animal.Sex.M, 21, 30, 8, false);
        Animal kokomi = new Animal("Kokomi", Animal.Type.FISH, Animal.Sex.F, 17, 160, 45, false);
        Animal liza = new Animal("Liza", Animal.Type.DOG, Animal.Sex.F, 1, 30, 4, true);
        Animal smallBird = new Animal("SmallBird", Animal.Type.BIRD, Animal.Sex.F, 3, 10, 1, false);

        List<Animal> animals = new ArrayList<>() {{
            add(kik);
            add(oz);
            add(kokomi);
            add(liza);
            add(smallBird);
        }};

        Map<Animal.Type, Integer> numberOfEachType = Task3.animalsOfEachType(animals);
        Map<Animal.Type, Integer> expected = new HashMap<>() {{
            put(Animal.Type.SPIDER, 0);
            put(Animal.Type.DOG, 2);
            put(Animal.Type.CAT, 0);
            put(Animal.Type.BIRD, 2);
            put(Animal.Type.FISH, 1);
        }};
        for (Animal.Type type : numberOfEachType.keySet()) {
            Assertions.assertEquals(expected.get(type), numberOfEachType.get(type));
        }
    }
}
