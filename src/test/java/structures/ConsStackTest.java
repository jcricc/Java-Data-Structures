package structures;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import structures.LinkedStructures.ConsStack;

public class ConsStackTest {
    @Test
    void testPushAndPop() {
        ConsStack<Integer> stack = new ConsStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertEquals(3, stack.pop());
        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());
    }

    @Test
    void testPeek() {
        ConsStack<String> stack = new ConsStack<>();
        stack.push("Hello");
        stack.push("World");

        assertEquals("World", stack.peek());
        assertEquals("World", stack.pop());
        assertEquals("Hello", stack.peek());
    }

    @Test
    void testEmpty() {
        ConsStack<Double> stack = new ConsStack<>();
        assertTrue(stack.empty());

        stack.push(3.14);
        assertFalse(stack.empty());

        stack.pop();
        assertTrue(stack.empty());
    }

    @Test
    void testPopOnEmpty() {
        ConsStack<Integer> stack = new ConsStack<>();
        assertThrows(RuntimeException.class, stack::pop);
    }
}
