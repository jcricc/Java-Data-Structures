package structures.ArrayBasedStructures;

import java.util.ArrayList;
import java.util.Collections;

import structures.Interfaces.Set;

public class ArraySet<T extends Comparable<T>> implements Set<T> {
    private final ArrayList<T> data;

    public ArraySet() {
        this.data = new ArrayList<>();
    }

    @Override
    public Set<T> add(T item) {
        if (!contains(item)) {
            data.add(item);
            Collections.sort(data);
        }
        return this;
    }

    @Override
    public Set<T> remove(T item) {
        data.remove(item);
        return this;
    }

    @Override
    public Set<T> union(Set<T> other) {
        ArraySet<T> result = new ArraySet<>();
        for (T item : this.data) {
            result.add(item);
        }
        for (T item : ((ArraySet<T>) other).data) {
            result.add(item);
        }
        return result;
    }

    @Override
    public Set<T> intersection(Set<T> other) {
        ArraySet<T> result = new ArraySet<>();
        for (T item : this.data) {
            if (other.contains(item)) {
                result.add(item);
            }
        }
        return result;
    }

    @Override
    public boolean contains(T item) {
        return Collections.binarySearch(data, item) >= 0;
    }

    @Override
    public boolean subset(Set<T> other) {
        for (T item : this.data) {
            if (!other.contains(item)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean superset(Set<T> other) {
        return other.subset(this);
    }

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
