package structures.ArrayBasedStructures;

import java.util.Arrays;

import structures.Interfaces.Deque;

public class ArrayDeque<T> implements Deque<T> {
    private T[] data;
    private int front;
    private int back;
    private int size;

    @SuppressWarnings("unchecked")
    public ArrayDeque() {
        this.data = (T[]) new Object[4];
        this.front = 0;
        this.back = 0;
        this.size = 0;
    }

    @Override
    public void push(T item) {
        if (size == data.length) {
            grow();
        }
        data[back] = item;
        back = (back + 1) % data.length;
        size++;
    }

    @Override
    public T pop() {
        if (empty()) {
            throw new RuntimeException("Cannot pop from an empty deque");
        }
        back = (back - 1 + data.length) % data.length;
        T item = data[back];
        data[back] = null;
        size--;
        return item;
    }

    @Override
    public void unshift(T item) {
        if (size == data.length) {
            grow();
        }
        front = (front - 1 + data.length) % data.length;
        data[front] = item;
        size++;
    }

    @Override
    public T shift() {
        if (empty()) {
            throw new RuntimeException("Cannot shift from an empty deque");
        }
        T item = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        return item;
    }

    @Override
    public T first() {
        if (empty()) {
            throw new RuntimeException("Cannot peek from an empty deque");
        }
        return data[front];
    }

    @Override
    public T last() {
        if (empty()) {
            throw new RuntimeException("Cannot peek from an empty deque");
        }
        return data[(back - 1 + data.length) % data.length];
    }

    @Override
    public boolean empty() {
        return size == 0;
    }

    private void grow() {
        @SuppressWarnings("unchecked")
        T[] newData = (T[]) new Object[data.length * 2];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(front + i) % data.length];
        }
        front = 0;
        back = size;
        data = newData;
    }

    @Override
    public String toString() {
        return Arrays.toString(data);
    }
}
