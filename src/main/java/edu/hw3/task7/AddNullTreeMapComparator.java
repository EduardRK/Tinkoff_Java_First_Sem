package edu.hw3.task7;

import java.util.Comparator;

public class AddNullTreeMapComparator implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        if (o1 == null) {
            return 0;
        }
        if (o2 == null) {
            return 1;
        }
        return o1.compareToIgnoreCase(o2);
    }
}