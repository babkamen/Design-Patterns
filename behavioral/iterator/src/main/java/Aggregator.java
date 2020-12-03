import java.util.Iterator;

public interface Aggregator {
    Iterator<String> getIterator();
    Iterator<String> getReverseIterator();
}
