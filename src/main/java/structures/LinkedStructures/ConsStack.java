package structures.LinkedStructures;

import structures.Interfaces.Stack;

public class ConsStack<T> implements Stack<T> {
    private ConsList<T> top;

    public ConsStack() {
        this.top = ConsList.of();
    }

    @Override
    public void push(T item) {
        this.top = top.add(item);
    }

    @Override
    public T pop() {
        if (top.isEmpty()) {
            throw new RuntimeException("Cannot pop from an empty stack");
        }
        T value = top.first();
        top = top.rest();
        return value;
    }

    @Override
    public T peek() {
        if (top.isEmpty()) {
            throw new RuntimeException("Cannot peek from an empty stack");
        }
        return top.first();
    }

    @Override
    public boolean empty() {
        return top.isEmpty();
    }

    @Override
    public int size() {
        return top.length();
    }
}
