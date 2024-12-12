package structures.LinkedStructures;

import java.util.Iterator;
import java.util.function.BiPredicate;

public interface ConsList<T> extends Iterable<T> {
    boolean isEmpty();
    T first();
    ConsList<T> rest();
    int length();

    T get(int index);
    T maxBy(BiPredicate<T, T> cmp);
    ConsList<T> insertionSortBy(BiPredicate<T, T> cmp);
    ConsList<T> insertSorted(T value, BiPredicate<T, T> cmp);
    ConsList<T> remove(T value);
    ConsList<T> add(T value);

    @SafeVarargs
    static <T> ConsList<T> of(T... args) {
        ConsList<T> list = new Empty<>();
        for (int i = args.length - 1; i >= 0; i--) {
            list = new Cell<>(args[i], list);
        }
        return list;
    }
}

class Empty<T> implements ConsList<T> {
    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public T first() {
        throw new RuntimeException("Empty list has no first element");
    }

    @Override
    public ConsList<T> rest() {
        throw new RuntimeException("Empty list has no rest");
    }

    @Override
    public int length() {
        return 0;
    }

    @Override
    public T get(int index) {
        throw new IndexOutOfBoundsException("Index out of bounds");
    }

    @Override
    public T maxBy(BiPredicate<T, T> cmp) {
        throw new RuntimeException("Empty list has no maximum element");
    }

    @Override
    public ConsList<T> insertionSortBy(BiPredicate<T, T> cmp) {
        return this;
    }

    @Override
    public ConsList<T> insertSorted(T value, BiPredicate<T, T> cmp) {
        return new Cell<>(value, this);
    }

    @Override
    public ConsList<T> remove(T value) {
        return new Cell<>(value, this);
    }

    @Override
    public ConsList<T> add(T value) {
        return new Cell<>(value, this);
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            @Override
            public boolean hasNext() {
                return false;
            }
            @Override
            public T next() {
                throw new RuntimeException("No next element");
            }
        };
    }
}

class Cell<T> implements ConsList<T> {
    private final T first;
    private final ConsList<T> rest;

    public Cell(T first, ConsList<T> rest) {
        this.first = first;
        this.rest = rest;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public T first() {
        return first;
    }

    @Override
    public ConsList<T> rest() {
        return rest;
    }

    @Override
    public int length() {
        return 1 + rest.length();
    }

    @Override
    public T get(int index) {
        if (index == 0) {
            return first;
        }
        return rest.get(index - 1);
    }

    @Override
    public T maxBy(BiPredicate<T, T> cmp) {
        T maxRest = rest.isEmpty() ? first : rest.maxBy(cmp);
        return cmp.test(first, maxRest) ? first : maxRest;
    }

    @Override
    public ConsList<T> insertionSortBy(BiPredicate<T, T> cmp) {
        if (rest.isEmpty()) {
            return this;
        }
        ConsList<T> sortedRest = rest.insertionSortBy(cmp);
        return sortedRest.insertSorted(first, cmp);
    }

    @Override
    public ConsList<T> insertSorted(T value, BiPredicate<T, T> cmp) {
        if (isEmpty() || cmp.test(value, first())) {
            return new Cell<>(value, this);
        }
        return new Cell<>(first(), rest().insertSorted(value, cmp));
    }

    @Override
    public ConsList<T> remove(T value) {
        if (first.equals(value)) {
            return rest;
        }
        return new Cell<>(first, rest.remove(value));
    }

    @Override
    public ConsList<T> add(T value) {
        return new Cell<>(value, this);
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            private ConsList<T> current = Cell.this;

            @Override
            public boolean hasNext() {
                return !current.isEmpty();
            }

            @Override
            public T next() {
                if (current.isEmpty()) {
                    throw new RuntimeException("No next element");
                }
                T value = current.first();
                current = current.rest();
                return value;
            }
        };
    }
}
