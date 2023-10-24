package edu.hw3.task8;

import java.util.Collection;
import java.util.Iterator;

public class BackwardIterator<T> implements Iterator<T> {
    private final T[] collectionArray;
    private int indexNextElement;

    public BackwardIterator(Collection<T> collection) {
        this.collectionArray = (T[]) collection.toArray();
        this.indexNextElement = collection.size() - 1;
    }

    @Override
    public boolean hasNext() {
        return (indexNextElement >= 0);
    }

    @Override
    public T next() {
        int i = indexNextElement;
        --indexNextElement;
        return collectionArray[i];
    }
}
