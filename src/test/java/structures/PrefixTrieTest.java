package structures;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import structures.TreeStructures.PrefixTrie;

class PrefixTrieTest {

    @Test
    void testInsertAndSearch() {
        PrefixTrie trie = new PrefixTrie();
        trie.insert("apple");
        trie.insert("app");

        assertTrue(trie.search("apple"));
        assertTrue(trie.search("app"));
        assertFalse(trie.search("appl"));
        assertFalse(trie.search("banana"));
    }

    @Test
    void testStartsWith() {
        PrefixTrie trie = new PrefixTrie();
        trie.insert("apple");
        trie.insert("app");
        trie.insert("banana");

        assertTrue(trie.startsWith("app"));
        assertTrue(trie.startsWith("ban"));
        assertFalse(trie.startsWith("bat"));
        assertFalse(trie.startsWith("cat"));
    }
}
