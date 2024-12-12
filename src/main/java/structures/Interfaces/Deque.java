package structures.Interfaces;

public interface Deque<T> {
    void push(T item);
    T pop();
    void unshift(T item);
    T shift();
    T first();
    T last();
    boolean empty();
}
