package structures.Interfaces;

public interface Set<T> {
    Set<T> add(T item);
    Set<T> remove(T item);
    Set<T> union(Set<T> other);
    Set<T> intersection(Set<T> other);
    boolean contains(T item);
    boolean subset(Set<T> other);
    boolean superset(Set<T> other);
    int size();
}
