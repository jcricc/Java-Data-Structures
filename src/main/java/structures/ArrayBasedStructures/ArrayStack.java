package structures.ArrayBasedStructures;

import java.util.ArrayList;

import structures.Interfaces.Stack;

public class ArrayStack<T> implements Stack<T> {
    private final ArrayList<T> data;

    public ArrayStack() {
        this.data = new ArrayList<>();
    }

    @Override
    public void push(T item) {
        data.add(item);
    }

    @Override
    public T pop() {
        if (data.isEmpty()) {
            throw new RuntimeException("Cannot pop from an empty stack");
        }
        return data.remove(data.size() - 1);
    }

    @Override
    public T peek() {
        if (data.isEmpty()) {
            throw new RuntimeException("Cannot peek from an empty stack");
        }
        return data.get(data.size() - 1);
    }

    @Override
    public boolean empty() {
        return data.isEmpty();
    }

    @Override
    public int size() {
        return data.size();
    }
}
