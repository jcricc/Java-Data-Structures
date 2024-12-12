package structures.Interfaces;

public interface CircularList<T> {
    int size();
    boolean isEmpty();
    void add(T data);
    void addAt(int index, T data);
    T remove(int index);
    T get(int index);
    String toString();
}
