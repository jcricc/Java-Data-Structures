package structures;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

import structures.Utils.ListUtils;

class ListUtilsTest {

    @Test
    void testAdd1ToAll() {
        List<Integer> input = List.of(1, 2, 3, 4);
        List<Integer> expected = List.of(2, 3, 4, 5);
        assertEquals(expected, ListUtils.add1ToAll(input));
    }

    @Test
    void testAdd1ToEach() {
        List<Integer> input = new ArrayList<>(List.of(1, 2, 3, 4));
        List<Integer> expected = List.of(2, 3, 4, 5);
        ListUtils.add1ToEach(input);
        assertEquals(expected, input);
    }

    @Test
    void testCountOccurrences() {
        List<Integer> input = List.of(1, 1, 1, 2, 4, 2);
        List<Integer> expected = List.of(3, 3, 3, 2, 1, 2);
        assertEquals(expected, ListUtils.countOccurrences(input));
    }

    @Test
    void testSecondLargest() {
        List<Integer> input = List.of(10, 20, 30, 40, 50);
        int expected = 40;
        assertEquals(expected, ListUtils.secondLargest(input));
    }

    @Test
    void testSecondLargestWithNegativeNumbers() {
        List<Integer> input = List.of(-10, -20, -30, -40, -50);
        int expected = -20;
        assertEquals(expected, ListUtils.secondLargest(input));
    }

    @Test
    void testSecondLargestWithDuplicateLargest() {
        List<Integer> input = List.of(50, 50, 40, 40, 30);
        int expected = 40;
        assertEquals(expected, ListUtils.secondLargest(input));
    }

    @Test
    void testSecondLargestWithException() {
        List<Integer> input = List.of(5); // Single-element list
        assertThrows(IllegalArgumentException.class, () -> ListUtils.secondLargest(input));
    }
}