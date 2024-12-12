package structures.Interfaces;

public interface Queue<T> {
    void push(T item);
    T shift();
    T first();
    boolean empty();
}
