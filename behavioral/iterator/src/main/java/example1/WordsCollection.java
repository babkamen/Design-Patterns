package example1;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Getter
public class WordsCollection implements Aggregator {

    private List<String> items;

    public WordsCollection() {
        this.items = new ArrayList<>();
    }

    public void addItem(String item) {
        items.add(item);
    }

    @Override
    public Iterator<String> getIterator() {
        return new WordsCollectionIterator(this, false);
    }

    @Override
    public Iterator<String> getReverseIterator() {
        return new WordsCollectionIterator(this, true);
    }
}
