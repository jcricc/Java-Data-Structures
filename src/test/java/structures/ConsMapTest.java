package structures;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import structures.MapStructures.ConsMap;

public class ConsMapTest {
    @Test
    void testSetAndGet() {
        ConsMap<String, Integer> map = new ConsMap<>();
        map.set("A", 1);
        map.set("B", 2);

        assertEquals(1, map.get("A"));
        assertEquals(2, map.get("B"));
    }

    @Test
    void testContainsKey() {
        ConsMap<String, Integer> map = new ConsMap<>();
        map.set("A", 1);

        assertTrue(map.containsKey("A"));
        assertFalse(map.containsKey("B"));
    }

    @Test
    void testKeySet() {
        ConsMap<String, Integer> map = new ConsMap<>();
        map.set("A", 1);
        map.set("B", 2);

        java.util.Set<String> keys = map.keySet();
        assertTrue(keys.contains("A"));
        assertTrue(keys.contains("B"));
    }
}