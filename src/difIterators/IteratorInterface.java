package difIterators;

import java.util.Iterator;

// Interface do Iterator
public interface IteratorInterface<T> extends Iterator<T> {
    boolean hasNext();
    T next();
}