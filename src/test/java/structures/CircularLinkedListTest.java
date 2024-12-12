package structures;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import structures.LinkedStructures.CircularLinkedList;

class CircularLinkedListTest {

    @Test
    void testAdd() {
        CircularLinkedList<Integer> list = new CircularLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        assertEquals(3, list.size());
        assertEquals("[1, 2, 3]", list.toString());
    }

    @Test
    void testAddAt() {
        CircularLinkedList<Integer> list = new CircularLinkedList<>();
        list.add(1);
        list.add(3);
        list.addAt(1, 2);

        assertEquals(3, list.size());
        assertEquals("[1, 2, 3]", list.toString());

        list.addAt(0, 0);
        assertEquals("[0, 1, 2, 3]", list.toString());
    }

    @Test
    void testRemove() {
        CircularLinkedList<Integer> list = new CircularLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        int removed = list.remove(1);
        assertEquals(2, removed);
        assertEquals("[1, 3]", list.toString());

        removed = list.remove(0);
        assertEquals(1, removed);
        assertEquals("[3]", list.toString());
    }

    @Test
    void testGet() {
        CircularLinkedList<Integer> list = new CircularLinkedList<>();
        list.add(10);
        list.add(20);
        list.add(30);

        assertEquals(10, list.get(0));
        assertEquals(20, list.get(1));
        assertEquals(30, list.get(2));
    }

    @Test
    void testIsEmpty() {
        CircularLinkedList<Integer> list = new CircularLinkedList<>();
        assertTrue(list.isEmpty());

        list.add(1);
        assertFalse(list.isEmpty());
    }

    @Test
    void testCircularProperty() {
        CircularLinkedList<Integer> list = new CircularLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        assertEquals(list.get(0), list.get(3 % list.size())); // Circular behavior
        assertEquals(list.get(1), list.get(4 % list.size()));
    }
}
