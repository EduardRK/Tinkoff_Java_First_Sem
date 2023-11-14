package edu.hw4;

import edu.hw4.Tasks.Task17;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Task17Test {
    @Test
    @DisplayName("Biting spiders more than biting dogs")
    public void bitingSpiderMoreThanBitingDogs() {
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

        boolean actual = Task17.isSpidersBiteOftenDogs(animals);
        Assertions.assertTrue(actual);
    }

    @Test
    @DisplayName("Biting spiders less than biting dogs")
    public void bitingSpiderLessThanBitingDogs() {
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
        Animal notBitingSpider = new Animal("Not Biting Spider", Animal.Type.SPIDER, Animal.Sex.M, 17, 27, 50, false);
        Animal bitingDog = new Animal("Biting Dog", Animal.Type.DOG, Animal.Sex.F, 12, 50, 40, true);
        Animal aggressiveDog = new Animal("Aggressive Dog", Animal.Type.DOG, Animal.Sex.M, 10, 42, 50, true);

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
            add(notBitingSpider);
            add(bitingDog);
            add(aggressiveDog);
        }};

        boolean actual = Task17.isSpidersBiteOftenDogs(animals);
        Assertions.assertFalse(actual);
    }

    @Test
    @DisplayName("Biting spiders equal than biting dogs")
    public void bitingSpiderEqualThanBitingDogs() {
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
        Animal notBitingSpider = new Animal("Not Biting Spider", Animal.Type.SPIDER, Animal.Sex.M, 17, 27, 50, false);
        Animal bitingDog = new Animal("Biting Dog", Animal.Type.DOG, Animal.Sex.F, 12, 50, 40, true);
        Animal peacefulSpider = new Animal("Peaceful Spider", Animal.Type.SPIDER, Animal.Sex.F, 4, 5, 2, false);

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
            add(notBitingSpider);
            add(bitingDog);
            add(peacefulSpider);
        }};

        boolean actual = Task17.isSpidersBiteOftenDogs(animals);
        Assertions.assertFalse(actual);
    }

    @Test
    @DisplayName("Cannot compare (spiders)")
    public void cannotCompareSpiders() {
        Animal kik = new Animal("Kik", Animal.Type.DOG, Animal.Sex.M, 10, 70, 60, true);
        Animal doggy = new Animal("Doggy", Animal.Type.DOG, Animal.Sex.M, 12, 30, 50, false);
        Animal fisheron = new Animal("Fisheron", Animal.Type.FISH, Animal.Sex.M, 19, 100, 101, true);
        Animal sam = new Animal("Sam", Animal.Type.CAT, Animal.Sex.M, 7, 49, 12, true);
        Animal oz = new Animal("Oz", Animal.Type.BIRD, Animal.Sex.M, 21, 30, 8, false);
        Animal kokomi = new Animal("Kokomi", Animal.Type.FISH, Animal.Sex.F, 17, 160, 45, false);
        Animal snegok = new Animal("Snegok", Animal.Type.CAT, Animal.Sex.M, 4, 24, 6, false);
        Animal acula = new Animal("Acula", Animal.Type.FISH, Animal.Sex.M, 14, 121, 50, true);
        Animal chicka = new Animal("Chicka", Animal.Type.BIRD, Animal.Sex.F, 2, 30, 4, false);
        Animal liza = new Animal("Liza", Animal.Type.DOG, Animal.Sex.F, 1, 30, 4, true);
        Animal veryBigName = new Animal("Very Big Name", Animal.Type.CAT, Animal.Sex.F, 6, 64, 8, true);
        Animal smallBird = new Animal("Small Bird", Animal.Type.BIRD, Animal.Sex.F, 3, 10, 1, false);
        Animal bitingDog = new Animal("Biting Dog", Animal.Type.DOG, Animal.Sex.F, 12, 50, 40, true);

        List<Animal> animals = new ArrayList<>() {{
            add(kik);
            add(doggy);
            add(acula);
            add(chicka);
            add(sam);
            add(oz);
            add(fisheron);
            add(kokomi);
            add(liza);
            add(veryBigName);
            add(smallBird);
            add(snegok);
            add(bitingDog);
        }};

        boolean actual = Task17.isSpidersBiteOftenDogs(animals);
        Assertions.assertFalse(actual);
    }

    @Test
    @DisplayName("Cannot compare (dogs)")
    public void cannotCompareDogs() {
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
        Animal veryBigName = new Animal("Very Big Name", Animal.Type.CAT, Animal.Sex.F, 6, 64, 8, true);
        Animal smallBird = new Animal("Small Bird", Animal.Type.BIRD, Animal.Sex.F, 3, 10, 1, false);
        Animal bigJadeSpider = new Animal("Big Jade Spider", Animal.Type.SPIDER, Animal.Sex.M, 9, 90, 85, true);
        Animal notBitingSpider = new Animal("Not Biting Spider", Animal.Type.SPIDER, Animal.Sex.M, 17, 27, 50, false);
        Animal peacefulSpider = new Animal("Peaceful Spider", Animal.Type.SPIDER, Animal.Sex.F, 4, 5, 2, false);

        List<Animal> animals = new ArrayList<>() {{
            add(acula);
            add(chicka);
            add(kate);
            add(sam);
            add(buka);
            add(oz);
            add(broodMother);
            add(fisheron);
            add(kokomi);
            add(veryBigName);
            add(smallBird);
            add(snegok);
            add(bigJadeSpider);
            add(notBitingSpider);
            add(peacefulSpider);
        }};

        boolean actual = Task17.isSpidersBiteOftenDogs(animals);
        Assertions.assertFalse(actual);
    }
}
