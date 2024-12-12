package structures;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

import structures.Utils.ArrayWrapper;

public class ArrayWrapperTest {

    @Test
    void testAddAndGet() {
        ArrayWrapper<Integer> arrayWrapper = new ArrayWrapper<>();
        arrayWrapper.add(1);
        arrayWrapper.add(2);
        arrayWrapper.add(3);

        assertEquals(3, arrayWrapper.size());
        assertEquals(1, arrayWrapper.get(0));
        assertEquals(2, arrayWrapper.get(1));
        assertEquals(3, arrayWrapper.get(2));
    }

    @Test
    void testPut() {
        ArrayWrapper<Integer> arrayWrapper = new ArrayWrapper<>();
        arrayWrapper.add(1);
        arrayWrapper.add(2);
        arrayWrapper.add(3);

        arrayWrapper.put(1, 10);
        assertEquals(10, arrayWrapper.get(1));
    }

    @Test
    void testGetOutOfBounds() {
        ArrayWrapper<Integer> arrayWrapper = new ArrayWrapper<>();
        arrayWrapper.add(1);

        assertThrows(IndexOutOfBoundsException.class, () -> arrayWrapper.get(2));
    }

    @Test
    void testPutOutOfBounds() {
        ArrayWrapper<Integer> arrayWrapper = new ArrayWrapper<>();
        arrayWrapper.add(1);

        assertThrows(IndexOutOfBoundsException.class, () -> arrayWrapper.put(2, 10));
    }
}