package structures;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import structures.ArrayBasedStructures.ArraySet;

public class ArraySetTest {
    @Test
    void testAddAndContains() {
        ArraySet<Integer> set = new ArraySet<>();
        set.add(1).add(2).add(3);

        assertTrue(set.contains(1));
        assertTrue(set.contains(2));
        assertFalse(set.contains(4));
    }

    @Test
    void testUnion() {
        ArraySet<Integer> set1 = new ArraySet<>();
        set1.add(1).add(2);
        ArraySet<Integer> set2 = new ArraySet<>();
        set2.add(2).add(3);

        ArraySet<Integer> result = (ArraySet<Integer>) set1.union(set2);
        assertTrue(result.contains(1));
        assertTrue(result.contains(2));
        assertTrue(result.contains(3));
    }

    @Test
    void testIntersection() {
        ArraySet<Integer> set1 = new ArraySet<>();
        set1.add(1).add(2);
        ArraySet<Integer> set2 = new ArraySet<>();
        set2.add(2).add(3);

        ArraySet<Integer> result = (ArraySet<Integer>) set1.intersection(set2);
        assertTrue(result.contains(2));
        assertFalse(result.contains(1));
        assertFalse(result.contains(3));
    }
}