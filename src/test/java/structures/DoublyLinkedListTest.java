package structures;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import structures.LinkedStructures.DoublyLinkedList;

public class DoublyLinkedListTest {

    @Test
    void testAddFirst() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);

        assertEquals(3, list.size());
        list.traverseForward(); // Should print: 3 2 1
    }

    @Test
    void testAddLast() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);

        assertEquals(3, list.size());
        list.traverseForward(); // Should print: 1 2 3
    }

    @Test
    void testRemoveFirst() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);

        assertEquals(3, list.removeFirst());
        assertEquals(2, list.size());
        list.traverseForward(); // Should print: 2 1
    }

    @Test
    void testRemoveLast() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);

        assertEquals(3, list.removeLast());
        assertEquals(2, list.size());
        list.traverseForward(); // Should print: 1 2
    }

    @Test
    void testIsEmpty() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        assertTrue(list.isEmpty());

        list.addFirst(1);
        assertFalse(list.isEmpty());
    }

    @Test
    void testTraverseBackward() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);

        list.traverseBackward(); // Should print: 3 2 1
    }
}