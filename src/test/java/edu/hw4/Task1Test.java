package edu.hw4;

import java.util.ArrayList;
import java.util.List;
import edu.hw4.Tasks.Task1;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Task1Test {
    @Test
    @DisplayName("Sort animals by height")
    public void sortAnimalsByHeight() {
        Animal kik = new Animal("Kik", Animal.Type.DOG, Animal.Sex.M, 10, 70, 50, true);
        Animal sam = new Animal("Sam", Animal.Type.CAT, Animal.Sex.M, 7, 49, 12, true);
        Animal oz = new Animal("Oz", Animal.Type.BIRD, Animal.Sex.M, 21, 30, 8, false);
        Animal brooda = new Animal("Brooda", Animal.Type.SPIDER, Animal.Sex.F, 56, 150, 40, true);
        Animal kokomi = new Animal("Kokomi", Animal.Type.FISH, Animal.Sex.F, 17, 160, 45, false);
        Animal liza = new Animal("Liza", Animal.Type.DOG, Animal.Sex.F, 1, 30, 4, true);
        Animal veryBigName = new Animal("VeryBigNameAnimal", Animal.Type.CAT, Animal.Sex.F, 6, 64, 8, true);
        Animal smallBird = new Animal("SmallBird", Animal.Type.BIRD, Animal.Sex.F, 3, 10, 1, false);

        List<Animal> actual = new ArrayList<>() {{
            add(kik);
            add(sam);
            add(oz);
            add(brooda);
            add(kokomi);
            add(liza);
            add(veryBigName);
            add(smallBird);
        }};
        Task1.sortAnimalsHeight(actual);
        List<Animal> expected = new ArrayList<>() {{
            add(smallBird);
            add(oz);
            add(liza);
            add(sam);
            add(veryBigName);
            add(kik);
            add(brooda);
            add(kokomi);
        }};
        Assertions.assertEquals(expected, actual);
    }
}
