package edu.hw4;

import edu.hw4.Tasks.Task6;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Task6Test {
    @Test
    @DisplayName("Heaviest animal each type")
    public void heaviestAnimalEachType() {
        Animal kik = new Animal("Kik", Animal.Type.DOG, Animal.Sex.M, 10, 70, 60, true);
        Animal maleDog = new Animal("Doggy", Animal.Type.DOG, Animal.Sex.M, 12, 30, 50, false);
        Animal maleFish = new Animal("Fisheron", Animal.Type.FISH, Animal.Sex.M, 19, 100, 101, true);
        Animal sam = new Animal("Sam", Animal.Type.CAT, Animal.Sex.M, 7, 49, 12, true);
        Animal oz = new Animal("Oz", Animal.Type.BIRD, Animal.Sex.M, 21, 30, 8, false);
        Animal broodMother = new Animal("BroodMother", Animal.Type.SPIDER, Animal.Sex.F, 56, 150, 40, true);
        Animal kokomi = new Animal("Kokomi", Animal.Type.FISH, Animal.Sex.F, 17, 160, 45, false);
        Animal snegok = new Animal("Snegok", Animal.Type.CAT, Animal.Sex.M, 3, 24, 6, false);
        Animal maleShark = new Animal("Acula", Animal.Type.FISH, Animal.Sex.M, 14, 121, 50, true);
        Animal chicken = new Animal("Chicka", Animal.Type.BIRD, Animal.Sex.F, 2, 30, 4, false);
        Animal femaleSpider = new Animal("Kate", Animal.Type.SPIDER, Animal.Sex.F, 3, 30, 4, true);
        Animal buka = new Animal("Buka", Animal.Type.SPIDER, Animal.Sex.F, 1, 12, 2, true);
        Animal liza = new Animal("Liza", Animal.Type.DOG, Animal.Sex.F, 1, 30, 4, true);
        Animal veryBigName = new Animal("VeryBigNameAnimal", Animal.Type.CAT, Animal.Sex.F, 6, 64, 8, true);
        Animal smallBird = new Animal("SmallBird", Animal.Type.BIRD, Animal.Sex.F, 3, 10, 1, false);

        List<Animal> animals = new ArrayList<>() {{
            add(kik);
            add(sam);
            add(chicken);
            add(femaleSpider);
            add(buka);
            add(maleDog);
            add(maleFish);
            add(oz);
            add(broodMother);
            add(kokomi);
            add(liza);
            add(veryBigName);
            add(smallBird);
            add(snegok);
            add(maleShark);
        }};

        Map<Animal.Type, Animal> actual = Task6.heaviestAnimalEachType(animals);
        Map<Animal.Type, Animal> expected = new HashMap<>() {{
            put(Animal.Type.FISH, maleFish);
            put(Animal.Type.DOG, kik);
            put(Animal.Type.CAT, sam);
            put(Animal.Type.BIRD, oz);
            put(Animal.Type.SPIDER, broodMother);
        }};

        for (Animal.Type type : actual.keySet()) {
            Assertions.assertEquals(expected.get(type), actual.get(type));
        }
    }

    @Test
    @DisplayName("Missing some types animals")
    public void missingSomeTypesAnimals() {
        Animal sam = new Animal("Sam", Animal.Type.CAT, Animal.Sex.M, 7, 49, 12, true);
        Animal oz = new Animal("Oz", Animal.Type.BIRD, Animal.Sex.M, 21, 30, 8, false);
        Animal broodMother = new Animal("BroodMother", Animal.Type.SPIDER, Animal.Sex.F, 56, 150, 40, true);
        Animal snegok = new Animal("Snegok", Animal.Type.CAT, Animal.Sex.M, 3, 24, 6, false);
        Animal chicken = new Animal("Chicka", Animal.Type.BIRD, Animal.Sex.F, 2, 30, 4, false);
        Animal femaleSpider = new Animal("Kate", Animal.Type.SPIDER, Animal.Sex.F, 3, 30, 4, true);
        Animal buka = new Animal("Buka", Animal.Type.SPIDER, Animal.Sex.F, 1, 12, 2, true);
        Animal veryBigName = new Animal("VeryBigNameAnimal", Animal.Type.CAT, Animal.Sex.F, 6, 64, 8, true);
        Animal smallBird = new Animal("SmallBird", Animal.Type.BIRD, Animal.Sex.F, 3, 10, 1, false);

        List<Animal> animals = new ArrayList<>() {{
            add(sam);
            add(chicken);
            add(femaleSpider);
            add(buka);
            add(oz);
            add(broodMother);
            add(veryBigName);
            add(smallBird);
            add(snegok);
        }};

        Map<Animal.Type, Animal> actual = Task6.heaviestAnimalEachType(animals);
        Map<Animal.Type, Animal> expected = new HashMap<>() {{
            put(Animal.Type.FISH, null);
            put(Animal.Type.DOG, null);
            put(Animal.Type.CAT, sam);
            put(Animal.Type.BIRD, oz);
            put(Animal.Type.SPIDER, broodMother);
        }};

        for (Animal.Type type : actual.keySet()) {
            Assertions.assertEquals(expected.get(type), actual.get(type));
        }
    }
}
