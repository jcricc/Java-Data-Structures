package structures.ArrayBasedStructures;

import java.util.Iterator;
import java.util.function.Function;

public class ArrayList<T> implements Iterable<T> {
    private T[] data;
    private int size;

    @SuppressWarnings("unchecked")
    public ArrayList() {
        this.data = (T[]) new Object[2];
        this.size = 0;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return data[index];
    }

    public void put(int index, T value) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        data[index] = value;
    }

    public void add(T value) {
        if (size == data.length) {
            grow();
        }
        data[size] = value;
        size++;
    }

    public void grow() {
        @SuppressWarnings("unchecked")
        T[] newData =(T[]) new Object[data.length * 2];
        System.arraycopy(data, 0, newData, 0, size);
        data = newData;
    }

    public <U> ArrayList<U> map(Function<T, U> op) {
        ArrayList<U> result = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            result.add(op.apply(data[i]));
        }
        return result;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < size;
            }

            @Override
            public T next() {
                return data[currentIndex++];
            }
        };
    }

    public int size() {
        return size;
    }
}
