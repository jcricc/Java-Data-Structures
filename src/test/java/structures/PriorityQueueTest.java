package structures;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class PriorityQueueTest {

    @Test
    public void testInsertAndPeek() {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.insert(5);
        pq.insert(3);
        pq.insert(8);
        pq.insert(1);

        assertEquals(1, pq.peek());
    }

    @Test
    public void testRemove() {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.insert(5);
        pq.insert(3);
        pq.insert(8);
        pq.insert(1);

        assertEquals(1, pq.remove());
        assertEquals(3, pq.remove());
        assertEquals(5, pq.remove());
        assertEquals(8, pq.remove());
    }

    @Test
    public void testIsEmpty() {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        assertTrue(pq.isEmpty());

        pq.insert(10);
        assertFalse(pq.isEmpty());

        pq.remove();
        assertTrue(pq.isEmpty());
    }

    @Test
    public void testSize() {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        assertEquals(0, pq.size());

        pq.insert(4);
        pq.insert(2);
        pq.insert(7);
        assertEquals(3, pq.size());

        pq.remove();
        assertEquals(2, pq.size());
    }

    @Test
    public void testPeekAndRemoveEmpty() {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        assertThrows(RuntimeException.class, pq::peek);
        assertThrows(RuntimeException.class, pq::remove);
    }
}
