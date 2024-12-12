package structures;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import structures.ArrayBasedStructures.ArrayList;

public class ArrayListTest {

    @Test
    void testAddAndGet() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);

        assertEquals(3, arrayList.size());
        assertEquals(1, arrayList.get(0));
        assertEquals(2, arrayList.get(1));
        assertEquals(3, arrayList.get(2));
    }

    @Test
    void testPut() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);

        arrayList.put(1, 10);
        assertEquals(10, arrayList.get(1));
    }

    @Test
    void testDynamicGrowth() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            arrayList.add(i);
        }

        assertEquals(10, arrayList.size());
        for (int i = 0; i < 10; i++) {
            assertEquals(i, arrayList.get(i));
        }
    }

    @Test
    void testMapFunction() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);

        ArrayList<String> mappedList = arrayList.map(Object::toString);

        assertEquals("1", mappedList.get(0));
        assertEquals("2", mappedList.get(1));
        assertEquals("3", mappedList.get(2));
    }

    @Test
    void testIterator() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);

        int sum = 0;
        for (int value : arrayList) {
            sum += value;
        }

        assertEquals(6, sum);
    }
}