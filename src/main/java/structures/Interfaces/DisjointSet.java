package structures.Interfaces;

public interface DisjointSet {
    void makeSet(int element);
    int find(int element);
    void union(int element1, int element2);
    boolean connected(int element1, int element2);
}
