package edu.hw4.ValidationError;

import edu.hw4.Animal;
import java.util.HashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

public class ValidationErrorChecker {
    private static final int ASCII_CODE_FIRST_UPPER_CASE_LETTER = 65;
    private static final int ASCII_CODE_LAST_UPPER_CASE_LETTER = 90;
    private static final int ASCII_CODE_FIRST_LOWER_CASE_LETTER = 97;
    private static final int ASCII_CODE_LAST_LOWER_CASE_LETTER = 122;
    private static final int ASCII_CODE_SPACE = 32;
    private static final int ASCII_CODE_DASH = 45;

    private static final int MAX_NAME_LENGTH = 100;
    private static final int MAX_AGE = 60;
    private static final int CAT_MAX_HEIGHT = 100;
    private static final int CAT_MAX_WEIGHT = 300;
    private static final int DOG_MAX_HEIGHT = 130;
    private static final int DOG_MAX_WEIGHT = 400;
    private static final int BIRD_MAX_HEIGHT = 150;
    private static final int BIRD_MAX_WEIGHT = 120;
    private static final int FISH_MAX_HEIGHT = 1_000;
    private static final int FISH_MAX_WEIGHT = 35_000;
    private static final int SPIDER_MAX_HEIGHT = 40;
    private static final int SPIDER_MAX_WEIGHT = 10;
    private static final Map<Animal.Type, Integer> MAX_HEIGHT_OF_ANIMAL = new HashMap<>();
    private static final Map<Animal.Type, Integer> MAX_WEIGHT_OF_ANIMAL = new HashMap<>();

    static {
        MAX_HEIGHT_OF_ANIMAL.put(Animal.Type.CAT, CAT_MAX_HEIGHT);
        MAX_HEIGHT_OF_ANIMAL.put(Animal.Type.DOG, DOG_MAX_HEIGHT);
        MAX_HEIGHT_OF_ANIMAL.put(Animal.Type.BIRD, BIRD_MAX_HEIGHT);
        MAX_HEIGHT_OF_ANIMAL.put(Animal.Type.FISH, FISH_MAX_HEIGHT);
        MAX_HEIGHT_OF_ANIMAL.put(Animal.Type.SPIDER, SPIDER_MAX_HEIGHT);
    }

    static {
        MAX_WEIGHT_OF_ANIMAL.put(Animal.Type.CAT, CAT_MAX_WEIGHT);
        MAX_WEIGHT_OF_ANIMAL.put(Animal.Type.DOG, DOG_MAX_WEIGHT);
        MAX_WEIGHT_OF_ANIMAL.put(Animal.Type.BIRD, BIRD_MAX_WEIGHT);
        MAX_WEIGHT_OF_ANIMAL.put(Animal.Type.FISH, FISH_MAX_WEIGHT);
        MAX_WEIGHT_OF_ANIMAL.put(Animal.Type.SPIDER, SPIDER_MAX_WEIGHT);
    }

    private ValidationErrorChecker() {
    }

    public static boolean isAnimalNameValid(Animal animal) {
        return isAnimalNameSymbolsValid(animal) && isAnimalNameLengthValid(animal);
    }

    public static boolean isAnimalAgeValid(@NotNull Animal animal) {
        return (animal.age() > 0 && animal.age() <= MAX_AGE);
    }

    public static boolean isAnimalHeightValid(@NotNull Animal animal) {
        return (animal.height() > 0 && animal.height() <= MAX_HEIGHT_OF_ANIMAL.get(animal.type()));
    }

    public static boolean isAnimalWeightValid(@NotNull Animal animal) {
        return (animal.weight() > 0 && animal.weight() <= MAX_WEIGHT_OF_ANIMAL.get(animal.type()));
    }

    private static boolean isAnimalNameLengthValid(@NotNull Animal animal) {
        return (animal.name().length() > 1 && animal.name().length() <= MAX_NAME_LENGTH);
    }

    private static boolean isAnimalNameSymbolsValid(@NotNull Animal animal) {
        char[] animalNameArray = animal.name().toCharArray();

        for (char letter : animalNameArray) {
            if (!(isLetter(letter) || isSpecialSymbol(letter))) {
                return false;
            }
        }

        return true;
    }

    private static boolean isLetter(char letter) {
        return
            ((int) letter >= ASCII_CODE_FIRST_UPPER_CASE_LETTER
                && (int) letter <= ASCII_CODE_LAST_UPPER_CASE_LETTER)
                || ((int) letter >= ASCII_CODE_FIRST_LOWER_CASE_LETTER
                && (int) letter <= ASCII_CODE_LAST_LOWER_CASE_LETTER);
    }

    private static boolean isSpecialSymbol(char letter) {
        return ((int) letter == ASCII_CODE_DASH || (int) letter == ASCII_CODE_SPACE);
    }
}
