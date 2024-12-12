package structures.Interfaces;

import java.util.Map;
import java.util.function.Consumer;

public interface BinTree<T extends Comparable<T>> {
    // Binary Tree Methods
    boolean isLeaf();
    boolean contains(T item);
    BinTree<T> insert(T item);
    BinTree<T> remove(T item);
    BinTree<T> merge(BinTree<T> other);
    T data();
    BinTree<T> left();
    BinTree<T> right();
    void each(Consumer<T> op);

    // Trie Methods with default unsupported implementations
    default Map<Character, BinTree<T>> children() {
        throw new UnsupportedOperationException("children() is not supported for binary trees.");
    }

    default void insert(String word) {
        throw new UnsupportedOperationException("insert(String) is not supported for binary trees.");
    }

    default boolean search(String word) {
        throw new UnsupportedOperationException("search(String) is not supported for binary trees.");
    }

    default boolean startsWith(String prefix) {
        throw new UnsupportedOperationException("startsWith(String) is not supported for binary trees.");
    }

    default boolean isEndOfWord() {
        throw new UnsupportedOperationException("isEndOfWord() is not supported for binary trees.");
    }

    default void setEndOfWord(boolean isEnd) {
        throw new UnsupportedOperationException("setEndOfWord(boolean) is not supported for binary trees.");
    }
}