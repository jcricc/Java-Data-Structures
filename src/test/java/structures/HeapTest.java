package structures;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import structures.HeapStructures.MaxHeap;
import structures.HeapStructures.MinHeap;

class HeapTest {
    @Test
    void testMinHeap() {
        MinHeap<Integer> minHeap = new MinHeap<>();
        minHeap.insert(10);
        minHeap.insert(5);
        minHeap.insert(20);
        minHeap.insert(3);

        assertEquals(3, minHeap.peek());
        assertEquals(3, minHeap.extract());
        assertEquals(5, minHeap.extract());
        assertEquals(10, minHeap.extract());
        assertEquals(20, minHeap.extract());
        assertTrue(minHeap.isEmpty());
    }

    @Test
    void testMaxHeap() {
        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        maxHeap.insert(10);
        maxHeap.insert(5);
        maxHeap.insert(20);
        maxHeap.insert(3);

        assertEquals(20, maxHeap.peek());
        assertEquals(20, maxHeap.extract());
        assertEquals(10, maxHeap.extract());
        assertEquals(5, maxHeap.extract());
        assertEquals(3, maxHeap.extract());
        assertTrue(maxHeap.isEmpty());
    }
}