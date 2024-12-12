package structures;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import structures.ArrayBasedStructures.ArrayDeque;

public class ArrayDequeTest {
    @Test
    void testPushAndPop() {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.push(1);
        deque.push(2);
        deque.push(3);

        assertEquals(3, deque.pop());
        assertEquals(2, deque.pop());
        assertEquals(1, deque.pop());
    }

    @Test
    void testUnshiftAndShift() {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.unshift(1);
        deque.unshift(2);
        deque.unshift(3);

        assertEquals(3, deque.shift());
        assertEquals(2, deque.shift());
        assertEquals(1, deque.shift());
    }

    @Test
    void testFirstAndLast() {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.unshift(1);
        deque.push(2);

        assertEquals(1, deque.first());
        assertEquals(2, deque.last());
    }

    @Test
    void testEmpty() {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        assertTrue(deque.empty());

        deque.push(1);
        assertFalse(deque.empty());

        deque.pop();
        assertTrue(deque.empty());
    }
}