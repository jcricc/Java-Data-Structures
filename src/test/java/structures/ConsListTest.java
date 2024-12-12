package structures;

import java.util.function.BiPredicate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import structures.LinkedStructures.ConsList;

public class ConsListTest {

    @Test
    void testOfAndLength() {
        ConsList<Integer> list = ConsList.of(1, 2, 3, 4);
        assertEquals(4, list.length());
    }

    @Test
    void testGet() {
        ConsList<Integer> list = ConsList.of(10, 20, 30, 40);
        assertEquals(10, list.get(0));
        assertEquals(30, list.get(2));
        assertThrows(RuntimeException.class, () -> list.get(4));
    }

    @Test
    void testMaxBy() {
        ConsList<Integer> list = ConsList.of(10, 20, 5, 15);
        BiPredicate<Integer, Integer> cmp = (a, b) -> a > b;
        assertEquals(20, list.maxBy(cmp));
    }

    @Test
    void testInsertionSortBy() {
        ConsList<Integer> list = ConsList.of(3, 1, 4, 2);
        BiPredicate<Integer, Integer> cmp = (a, b) -> a < b; // Sort ascending
        ConsList<Integer> sorted = list.insertionSortBy(cmp);

        assertEquals(1, sorted.get(0));
        assertEquals(2, sorted.get(1));
        assertEquals(3, sorted.get(2));
        assertEquals(4, sorted.get(3));
    }

    @Test
    void testEmptyList() {
        ConsList<Integer> empty = ConsList.of();
        assertTrue(empty.isEmpty());
        assertEquals(0, empty.length());
        assertThrows(RuntimeException.class, empty::first);
        assertThrows(RuntimeException.class, empty::rest);
        assertThrows(RuntimeException.class, () -> empty.maxBy((a, b) -> a > b));
    }
}