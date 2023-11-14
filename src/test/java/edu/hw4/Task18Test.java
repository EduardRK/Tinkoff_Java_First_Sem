package edu.hw4;

import edu.hw4.Tasks.Task18;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Task18Test {
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

        List<Animal> animalsFirst = new ArrayList<>() {{
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

        Animal veryVeryBigFish = new Animal("Very Very Big Fish", Animal.Type.FISH, Animal.Sex.M, 120, 300, 800, false);
        Animal anotherDog = new Animal("Another Dog", Animal.Type.DOG, Animal.Sex.M, 12, 30, 21, true);
        Animal anotherFish = new Animal("Another Fish", Animal.Type.FISH, Animal.Sex.M, 3, 45, 90, false);
        Animal anotherSpider = new Animal("Another Spider", Animal.Type.SPIDER, Animal.Sex.F, 7, 15, 2, false);
        Animal fishka = new Animal("Fishka", Animal.Type.FISH, Animal.Sex.F, 21, 120, 100, true);

        List<Animal> animalsSecond = new ArrayList<>() {{
            add(veryVeryBigFish);
            add(anotherDog);
            add(anotherFish);
            add(anotherSpider);
            add(fishka);
        }};

        Animal actual = Task18.heaviestFishInSeveralLists(animalsFirst, animalsSecond);
        Assertions.assertEquals(veryVeryBigFish, actual);
    }

    @Test
    @DisplayName("Lists without fish")
    public void listsWithoutFish() {
        Animal kik = new Animal("Kik", Animal.Type.DOG, Animal.Sex.M, 10, 70, 60, true);
        Animal doggy = new Animal("Doggy", Animal.Type.DOG, Animal.Sex.M, 12, 30, 50, false);
        Animal sam = new Animal("Sam", Animal.Type.CAT, Animal.Sex.M, 7, 49, 12, true);
        Animal oz = new Animal("Oz", Animal.Type.BIRD, Animal.Sex.M, 21, 30, 8, false);
        Animal broodMother = new Animal("Brood Mother", Animal.Type.SPIDER, Animal.Sex.F, 56, 150, 40, true);
        Animal snegok = new Animal("Snegok", Animal.Type.CAT, Animal.Sex.M, 4, 24, 6, false);
        Animal chicka = new Animal("Chicka", Animal.Type.BIRD, Animal.Sex.F, 2, 30, 4, false);
        Animal kate = new Animal("Kate", Animal.Type.SPIDER, Animal.Sex.F, 3, 30, 4, true);
        Animal buka = new Animal("Buka", Animal.Type.SPIDER, Animal.Sex.F, 1, 12, 2, true);
        Animal liza = new Animal("Liza", Animal.Type.DOG, Animal.Sex.F, 1, 30, 4, true);
        Animal veryBigName = new Animal("Very Big Name", Animal.Type.CAT, Animal.Sex.F, 6, 64, 8, true);
        Animal smallBird = new Animal("Small Bird", Animal.Type.BIRD, Animal.Sex.F, 3, 10, 1, false);
        Animal bigJadeSpider = new Animal("Big Jade Spider", Animal.Type.SPIDER, Animal.Sex.M, 9, 90, 85, true);

        List<Animal> animalsFirst = new ArrayList<>() {{
            add(kik);
            add(doggy);
            add(chicka);
            add(kate);
            add(sam);
            add(buka);
            add(oz);
            add(broodMother);
            add(liza);
            add(veryBigName);
            add(smallBird);
            add(snegok);
            add(bigJadeSpider);
        }};

        Animal anotherDog = new Animal("Another Dog", Animal.Type.DOG, Animal.Sex.M, 12, 30, 21, true);
        Animal anotherSpider = new Animal("Another Spider", Animal.Type.SPIDER, Animal.Sex.F, 7, 15, 2, false);

        List<Animal> animalsSecond = new ArrayList<>() {{
            add(anotherDog);
            add(anotherSpider);
        }};

        Animal actual = Task18.heaviestFishInSeveralLists(animalsFirst, animalsSecond);
        Assertions.assertNull(actual);
    }

    @Test
    @DisplayName("Some lists without fish")
    public void someListsWithoutFish() {
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

        List<Animal> animalsFirst = new ArrayList<>() {{
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

        Animal anotherDog = new Animal("Another Dog", Animal.Type.DOG, Animal.Sex.M, 12, 30, 21, true);
        Animal anotherSpider = new Animal("Another Spider", Animal.Type.SPIDER, Animal.Sex.F, 7, 15, 2, false);

        List<Animal> animalsSecond = new ArrayList<>() {{
            add(anotherDog);
            add(anotherSpider);
        }};

        Animal actual = Task18.heaviestFishInSeveralLists(animalsFirst, animalsSecond);
        Assertions.assertEquals(fisheron, actual);
    }
}
