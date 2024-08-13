package tree;

import difIterators.*;

public interface Tree<T> extends Prototype<Tree<T>> {
    IteratorInterface<T> createIterator(String type);
}