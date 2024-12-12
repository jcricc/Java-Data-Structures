package structures;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import structures.MapStructures.HashMap;

public class HashMapTest {

    @Test
    public void testPutAndGet() {
        HashMap<String, Integer> map = new HashMap<>();

        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);

        assertEquals(1, map.get("one"));
        assertEquals(2, map.get("two"));
        assertEquals(3, map.get("three"));
    }

    @Test
    public void testOverwriteValue() {
        HashMap<String, Integer> map = new HashMap<>();

        map.put("key", 10);
        assertEquals(10, map.get("key"));

        map.put("key", 20); // Overwrite the value
        assertEquals(20, map.get("key"));
    }

    @Test
    public void testHasKey() {
        HashMap<String, String> map = new HashMap<>();

        map.put("name", "Alice");
        assertTrue(map.hasKey("name"));
        assertFalse(map.hasKey("age"));
    }

    @Test
    public void testDeleteKey() {
        HashMap<String, String> map = new HashMap<>();

        map.put("color", "red");
        assertTrue(map.hasKey("color"));

        map.del("color");
        assertFalse(map.hasKey("color"));
    }

    @Test
    public void testGetOrNull() {
        HashMap<String, String> map = new HashMap<>();

        map.put("animal", "dog");
        assertEquals("dog", map.getOrNull("animal"));
        assertNull(map.getOrNull("bird")); // Nonexistent key
    }

    @Test
    public void testGrowRehashing() {
        HashMap<Integer, String> map = new HashMap<>();

        // Add enough elements to trigger growth
        map.put(1, "A");
        map.put(2, "B");
        map.put(3, "C");
        map.put(4, "D"); // Load factor exceeds 0.55, growth occurs here
        map.put(5, "E");

        assertEquals("A", map.get(1));
        assertEquals("B", map.get(2));
        assertEquals("C", map.get(3));
        assertEquals("D", map.get(4));
        assertEquals("E", map.get(5));
    }

    @Test
    public void testKeys() {
        HashMap<Integer, String> map = new HashMap<>();

        map.put(100, "Value1");
        map.put(200, "Value2");
        map.put(300, "Value3");

        ArrayList<Integer> keys = map.keys();
        assertTrue(keys.contains(100));
        assertTrue(keys.contains(200));
        assertTrue(keys.contains(300));
        assertEquals(3, keys.size());
    }

    @Test
    public void testLoadFactor() {
        HashMap<String, String> map = new HashMap<>();

        map.put("A", "alpha");
        map.put("B", "beta");

        assertEquals(0.5, map.loadFactor()); // 2 elements in a map with capacity 4
    }

    @Test
    public void testCapacityAndSize() {
        HashMap<Integer, String> map = new HashMap<>();

        assertEquals(4, map.capacity());
        assertEquals(0, map.size());

        map.put(1, "one");
        map.put(2, "two");

        assertEquals(4, map.capacity());
        assertEquals(2, map.size());
    }

    @Test
    public void testExceptionOnMissingKey() {
        HashMap<String, String> map = new HashMap<>();
        assertThrows(RuntimeException.class, () -> map.get("nonexistentKey"));
    }
}