package structures.TreeStructures;

import java.util.function.Consumer;

import structures.Interfaces.BinTree;

public record BinBranch<T extends Comparable<T>>(T data, BinTree<T> left, BinTree<T> right)
        implements BinTree<T> {

    @Override
    public boolean isLeaf() {
        return false;
    }

    @Override
    public boolean contains(T item) {
        int cmp = item.compareTo(this.data);
        if (cmp == 0) {
            return true;
        }
        if (cmp < 0) {
            return this.left.contains(item);
        }
        return this.right.contains(item);
    }

    @Override
    public BinTree<T> insert(T item) {
        int cmp =item.compareTo(this.data);
        if (cmp == 0) {
            return this;
        }
        if (cmp < 0) {
            return new BinBranch<>(this.data, this.left.insert(item), this.right);
        }
        return new BinBranch<>(this.data, this.left, this.right.insert(item));
    }

    @Override
    public BinTree<T> remove(T item) {
        int cmp = item.compareTo(this.data);
        if (cmp == 0) {
            return this.left.merge(this.right);
        }
        if (cmp < 0) {
            return new BinBranch<>(this.data, this.left.remove(item), this.right);
        }
        return new BinBranch<>(this.data, this.left, this.right.remove(item));
    }

    @Override
    public BinTree<T> merge(BinTree<T> other) {
        if (other.isLeaf()) {
            return this;
        }
        return this.insert(other.data())
                     .merge(other.left())
                     .merge(other.right());
    }

    @Override
    public void each(Consumer<T> op) {
        this.left.each(op);
        op.accept(this.data);
        this.right.each(op);
    }

    @Override
    public String toString() {
        String leftStr = this.left.isLeaf() ? "." : this.left.toString();
        String rightStr = this.right.isLeaf() ? "." : this.right.toString();
        return "(" + leftStr + " " + this.data + " " + rightStr + ")";
    }
}
