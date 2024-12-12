package structures.TreeStructures;

import java.util.function.Consumer;

import structures.Interfaces.BinTree;

public record BinLeaf<T extends Comparable<T>>() implements BinTree<T> {
    
    @Override
    public boolean isLeaf() {
        return true;
    }
    
    @Override
    public boolean contains(T item) {
        return false;
    }

    @Override
    public BinTree<T> insert(T item) {
        return new BinBranch<>(item, this, this);
    }

    @Override
    public BinTree<T> remove(T item) {
        return this;
    }

    @Override
    public BinTree<T> merge(BinTree<T> other) {
        return other;
    }

    @Override
    public T data() {
        throw new RuntimeException("No data in leaf");
    }

    @Override
    public BinTree<T> left() {
        throw new RuntimeException("No left in leaf");
    }

    @Override
    public BinTree<T> right() {
        throw new RuntimeException("No right in leaf");
    }

    @Override
    public void each(Consumer<T> op) {

    }

    @Override
    public String toString() {
        return ".";
    }
}
