package structures.Utils;

public class ArrayWrapper<T> {
    private T[] data;
    private int size;

    @SuppressWarnings("unchecked")
    public ArrayWrapper() {
        this.data = (T[]) new Object[0];
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
        @SuppressWarnings("unchecked")
        T[] newData = (T[]) new Object[size + 1];
        System.arraycopy(data, 0, newData, 0, size);
        newData[size] = value;
        data = newData;
        size++;
    }

    public int size() {
        return size;
    }
}
