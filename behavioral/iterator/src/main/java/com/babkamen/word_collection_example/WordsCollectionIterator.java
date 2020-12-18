package com.babkamen.word_collection_example;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class WordsCollectionIterator implements Iterator<String> {

    private int index;
    private WordsCollection wordsCollection;
    private int itemsSize;
    private boolean reverseOrder;

    public WordsCollectionIterator(final WordsCollection wordsCollection, final boolean reverseOrder) {
        this.wordsCollection = wordsCollection;
        this.index = reverseOrder ? wordsCollection.getItems().size() - 1 : 0;
        this.reverseOrder = reverseOrder;
        this.itemsSize = wordsCollection.getItems().size();
    }

    @Override
    public boolean hasNext() {
        return reverseOrder ? index >= 0 : index < wordsCollection.getItems().size();
    }

    @Override
    public String next() {
        checkForComodification();
        List<String> items = wordsCollection.getItems();
        if (index < 0 || index >= items.size()) {
            throw new NoSuchElementException();
        }
        return items.get(reverseOrder ? index-- : index++);
    }

    private void checkForComodification() {
        if (itemsSize != wordsCollection.getItems().size()) {
            throw new ConcurrentModificationException();
        }
    }
}
