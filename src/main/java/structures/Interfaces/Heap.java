package structures.Interfaces;

public interface Heap<T extends Comparable<T>> {
    void insert(T value);
    T extract();
    T peek();
    int size();
    boolean isEmpty();
}
