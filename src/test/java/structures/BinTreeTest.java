package structures;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import structures.Interfaces.BinTree;
import structures.TreeStructures.BinLeaf;

class BinTreeTest {

    @Test
    void testInsert() {
        BinTree<Integer> tree = new BinLeaf<>();
        tree = tree.insert(10);
        tree = tree.insert(5);
        tree = tree.insert(15);

        assertTrue(tree.contains(10));
        assertTrue(tree.contains(5));
        assertTrue(tree.contains(15));
        assertFalse(tree.contains(20));
    }

    @Test
    void testRemove() {
        BinTree<Integer> tree = new BinLeaf<>();
        tree = tree.insert(10);
        tree = tree.insert(5);
        tree = tree.insert(15);
        tree = tree.remove(5);

        assertFalse(tree.contains(5));
        assertTrue(tree.contains(10));
        assertTrue(tree.contains(15));
    }

    @Test
    void testMerge() {
        BinTree<Integer> tree1 = new BinLeaf<>();
        BinTree<Integer> tree2 = new BinLeaf<>();
        tree1 = tree1.insert(10);
        tree1 = tree1.insert(5);
        tree2 = tree2.insert(15);
        tree2 = tree2.insert(20);

        BinTree<Integer> mergedTree = tree1.merge(tree2);

        assertTrue(mergedTree.contains(10));
        assertTrue(mergedTree.contains(5));
        assertTrue(mergedTree.contains(15));
        assertTrue(mergedTree.contains(20));
    }

    @Test
    void testEach() {
        BinTree<Integer> tree = new BinLeaf<>();
        tree = tree.insert(10);
        tree = tree.insert(5);
        tree = tree.insert(15);

        ArrayList<Integer> elements = new ArrayList<>();
        tree.each(elements::add);

        assertEquals(3, elements.size());
        assertTrue(elements.contains(10));
        assertTrue(elements.contains(5));
        assertTrue(elements.contains(15));
    }

    @Test
    void testToString() {
        BinTree<Integer> tree = new BinLeaf<>();
        tree = tree.insert(10);
        tree = tree.insert(5);
        tree = tree.insert(15);

        assertEquals("((. 5 .) 10 (. 15 .))", tree.toString());
    }
}
