package structures;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import structures.ArrayBasedStructures.ArrayStack;

public class ArrayStackTest {
    @Test
    void testPushAndPop() {
        ArrayStack<Integer> stack = new ArrayStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertEquals(3, stack.pop());
        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());
    }

    @Test
    void testPeek() {
        ArrayStack<String> stack = new ArrayStack<>();
        stack.push("Hello");
        stack.push("World");

        assertEquals("World", stack.peek());
        assertEquals("World", stack.pop());
        assertEquals("Hello", stack.peek());
    }

    @Test
    void testEmpty() {
        ArrayStack<Double> stack = new ArrayStack<>();
        assertTrue(stack.empty());

        stack.push(3.14);
        assertFalse(stack.empty());

        stack.pop();
        assertTrue(stack.empty());
    }

    @Test
    void testPopOnEmpty() {
        ArrayStack<Integer> stack = new ArrayStack<>();
        assertThrows(RuntimeException.class, stack::pop);
    }
}
