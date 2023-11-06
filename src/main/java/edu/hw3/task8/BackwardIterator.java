package edu.hw3.task8;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class BackwardIterator<T> implements Iterator<T> {
    private final List<T> collectionList;
    private int indexNextElement;

    public BackwardIterator(Collection<T> collection) {
        this.collectionList = new ArrayList<>(collection);
        this.indexNextElement = collection.size() - 1;
    }

    @Override
    public boolean hasNext() {
        return (indexNextElement >= 0);
    }

    @Override
    public T next() {
        return collectionList.get(indexNextElement--);
    }
}
