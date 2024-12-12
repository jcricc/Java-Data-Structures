package structures.TreeStructures;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

import structures.Interfaces.BinTree;

public class PrefixTrie implements BinTree<Character> {
    private final Map<Character, BinTree<Character>> children = new HashMap<>();
    private boolean isEndOfWord = false;

    @Override
    public boolean isLeaf() {
        return children.isEmpty();
    }

    @Override
    public boolean contains(Character item) {
        throw new UnsupportedOperationException("Use search(String word) for Trie operations.");
    }

    @Override
    public BinTree<Character> insert(Character item) {
        throw new UnsupportedOperationException("Use insert(String word) for Trie operations.");
    }

    @Override
    public BinTree<Character> remove(Character item) {
        throw new UnsupportedOperationException("Remove operation not supported for Trie.");
    }

    @Override
    public BinTree<Character> merge(BinTree<Character> other) {
        throw new UnsupportedOperationException("Merge operation not supported for Trie.");
    }

    @Override
    public Character data() {
        throw new UnsupportedOperationException("Trie nodes do not store individual data.");
    }

    @Override
    public BinTree<Character> left() {
        throw new UnsupportedOperationException("Trie does not support left child.");
    }

    @Override
    public BinTree<Character> right() {
        throw new UnsupportedOperationException("Trie does not support right child.");
    }

    @Override
    public void each(Consumer<Character> op) {
        throw new UnsupportedOperationException("Use traversal methods specific to Trie.");
    }

    @Override
    public Map<Character, BinTree<Character>> children() {
        return children;
    }

    @Override
    public void insert(String word) {
        BinTree<Character> current = this;
        for (char ch : word.toCharArray()) {
            current.children().putIfAbsent(ch, new PrefixTrie());
            current = current.children().get(ch);
        }
        current.setEndOfWord(true);
    }

    @Override
    public boolean search(String word) {
        BinTree<Character> current = getNode(word);
        return current != null && current.isEndOfWord();
    }

    @Override
    public boolean startsWith(String prefix) {
        return getNode(prefix) != null;
    }

    @Override
    public boolean isEndOfWord() {
        return isEndOfWord;
    }

    @Override
    public void setEndOfWord(boolean isEnd) {
        this.isEndOfWord = isEnd;
    }

    private BinTree<Character> getNode(String word) {
        BinTree<Character> current = this;
        for (char ch : word.toCharArray()) {
            current = current.children().get(ch);
            if (current == null) {
                return null;
            }
        }
        return current;
    }
}