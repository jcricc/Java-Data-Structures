package structures.MapStructures;

import java.util.HashMap;
import java.util.Map;

import structures.Interfaces.DisjointSet;

public class DisjointedSet implements DisjointSet {
    private final Map<Integer, Integer> parent;
    private final Map<Integer, Integer> rank;

    public DisjointedSet() {
        this.parent = new HashMap<>();
        this.rank = new HashMap<>();
    }

    @Override
    public void makeSet(int element) {
        if (!parent.containsKey(element)) {
            parent.put(element, element);
            rank.put(element, 0);
        }
    }

    @Override
    public int find(int element) {
        if (!parent.containsKey(element)) {
            throw new RuntimeException("Element not in set");
        }

        if (parent.get(element) != element) {
            parent.put(element, find(parent.get(element)));
        }
        return parent.get(element);
    }

    @Override
    public void union(int element1, int element2) {
        int root1 = find(element1);
        int root2 = find(element2);

        if (root1 == root2) {
            return;
        }

        int rank1 = rank.get(root1);
        int rank2 = rank.get(root2);

        if (rank1 > rank2) {
            parent.put(root2, root1);
        }
        else if (rank1 < rank2) {
            parent.put(root1, root2);
        }
        else {
            parent.put(root2, root1);
            rank.put(root1, rank1 + 1);
        }
    }

    @Override
    public boolean connected(int element1, int element2) {
        return find(element1) == find(element2);
    }

    public int size() {
        return parent.size();
    }
}
