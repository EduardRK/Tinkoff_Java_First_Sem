package edu.hw4;

import edu.hw4.Tasks.Task16;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Task16Test {
    @Test
    @DisplayName("All animals")
    public void allAnimals() {
        Animal kik = new Animal("Kik", Animal.Type.DOG, Animal.Sex.M, 10, 70, 60, true);
        Animal doggy = new Animal("Doggy", Animal.Type.DOG, Animal.Sex.M, 12, 30, 50, false);
        Animal fisheron = new Animal("Fisheron", Animal.Type.FISH, Animal.Sex.M, 19, 100, 101, true);
        Animal sam = new Animal("Sam", Animal.Type.CAT, Animal.Sex.M, 7, 49, 12, true);
        Animal oz = new Animal("Oz", Animal.Type.BIRD, Animal.Sex.M, 21, 30, 8, false);
        Animal broodMother = new Animal("Brood Mother", Animal.Type.SPIDER, Animal.Sex.F, 56, 150, 40, true);
        Animal kokomi = new Animal("Kokomi", Animal.Type.FISH, Animal.Sex.F, 17, 160, 45, false);
        Animal snegok = new Animal("Snegok", Animal.Type.CAT, Animal.Sex.M, 4, 24, 6, false);
        Animal acula = new Animal("Acula", Animal.Type.FISH, Animal.Sex.M, 14, 121, 50, true);
        Animal chicka = new Animal("Chicka", Animal.Type.BIRD, Animal.Sex.F, 2, 30, 4, false);
        Animal kate = new Animal("Kate", Animal.Type.SPIDER, Animal.Sex.F, 3, 30, 4, true);
        Animal buka = new Animal("Buka", Animal.Type.SPIDER, Animal.Sex.F, 1, 12, 2, true);
        Animal liza = new Animal("Liza", Animal.Type.DOG, Animal.Sex.F, 1, 30, 4, true);
        Animal veryBigName = new Animal("Very Big Name", Animal.Type.CAT, Animal.Sex.F, 6, 64, 8, true);
        Animal smallBird = new Animal("Small Bird", Animal.Type.BIRD, Animal.Sex.F, 3, 10, 1, false);
        Animal bigJadeSpider = new Animal("Big Jade Spider", Animal.Type.SPIDER, Animal.Sex.M, 9, 90, 85, true);

        List<Animal> animals = new ArrayList<>() {{
            add(kik);
            add(doggy);
            add(acula);
            add(chicka);
            add(kate);
            add(sam);
            add(buka);
            add(oz);
            add(broodMother);
            add(fisheron);
            add(kokomi);
            add(liza);
            add(veryBigName);
            add(smallBird);
            add(snegok);
            add(bigJadeSpider);
        }};

        List<Animal> actual = Task16.animalListSortedByTypeBySexByName(animals);
        List<Animal> expected = new ArrayList<>() {{
            add(sam);
            add(snegok);
            add(veryBigName);
            add(doggy);
            add(kik);
            add(liza);
            add(oz);
            add(chicka);
            add(smallBird);
            add(acula);
            add(fisheron);
            add(kokomi);
            add(bigJadeSpider);
            add(broodMother);
            add(buka);
            add(kate);
        }};

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Empty list")
    public void emptyList() {
        List<Animal> animals = new ArrayList<>();

        List<Animal> actual = Task16.animalListSortedByTypeBySexByName(animals);
        List<Animal> expected = new ArrayList<>();

        Assertions.assertEquals(expected, actual);
    }
}
