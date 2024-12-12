package structures;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import structures.ArrayBasedStructures.RingQueue;

public class RingQueueTest {
    @Test
    void testPushAndShift() {
        RingQueue<Integer> queue = new RingQueue<>();
        queue.push(1);
        queue.push(2);
        queue.push(3);

        assertEquals(1, queue.shift());
        assertEquals(2, queue.shift());
        assertEquals(3, queue.shift());
    }

    @Test
    void testEmpty() {
        RingQueue<Integer> queue = new RingQueue<>();
        assertTrue(queue.empty());
        queue.push(1);
        assertFalse(queue.empty());
    }

    @Test
    void testGrow() {
        RingQueue<Integer> queue = new RingQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.push(i);
        }

        for (int i = 0; i < 10; i++) {
            assertEquals(i, queue.shift());
        }
    }
}