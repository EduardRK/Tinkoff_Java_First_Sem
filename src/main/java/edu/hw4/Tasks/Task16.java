package edu.hw4.Tasks;

import edu.hw4.Animal;
import java.util.List;
import java.util.stream.Collectors;

public class Task16 {
    private Task16() {
    }

    public static List<Animal> animalListSortedByTypeBySexByName(List<Animal> animals) {
        return animals.stream()
            .sorted((o1, o2) -> {
                if (!o1.type().equals(o2.type())) {
                    return o1.type().compareTo(o2.type());
                }

                if (!o1.sex().equals(o2.sex())) {
                    return o1.sex().compareTo(o2.sex());
                }

                return o1.name().compareToIgnoreCase(o2.name());
            })
            .collect(Collectors.toList());
    }
}
