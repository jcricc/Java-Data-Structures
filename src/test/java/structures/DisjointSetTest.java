package structures;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import structures.MapStructures.DisjointedSet;

public class DisjointSetTest {
    @Test
    void testBasicOperations() {
        DisjointedSet ds = new DisjointedSet();

        ds.makeSet(1);
        ds.makeSet(2);
        ds.makeSet(3);

        assertEquals(1, ds.find(1));
        assertEquals(2, ds.find(2));
        assertEquals(3, ds.find(3));

        ds.union(1, 2);
        assertEquals(ds.find(1), ds.find(2));
        assertNotEquals(ds.find(1), ds.find(3));
    }

    @Test
    void testPathCompression() {
        DisjointedSet ds = new DisjointedSet();

        for (int i = 1; i <= 5; i++) {
            ds.makeSet(i);
        }

        ds.union(1, 2);
        ds.union(2, 3);
        ds.union(3, 4);

        // Path compression test
        assertEquals(ds.find(1), ds.find(4));
        assertEquals(ds.find(2), ds.find(4));
    }

    @Test
    void testUnionByRank() {
        DisjointedSet ds = new DisjointedSet();

        ds.makeSet(1);
        ds.makeSet(2);
        ds.makeSet(3);

        ds.union(1, 2); // Union two sets
        ds.union(2, 3); // Union larger set with smaller set

        assertTrue(ds.connected(1, 3));
        assertEquals(ds.find(1), ds.find(3));
    }

    @Test
    void testDisconnectedSets() {
        DisjointedSet ds = new DisjointedSet();

        ds.makeSet(1);
        ds.makeSet(2);
        ds.makeSet(3);
        ds.makeSet(4);

        ds.union(1, 2);

        assertFalse(ds.connected(1, 3));
        assertFalse(ds.connected(2, 4));

        ds.union(3, 4);
        assertTrue(ds.connected(3, 4));
    }
}