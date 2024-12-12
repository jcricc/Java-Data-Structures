package structures.MapStructures;

import java.util.ArrayList;
import java.lang.reflect.Array;

public class HashMap<K, V> {
    private Entry<K, V>[] data; // Generic array of Entry objects
    private int size;
    private final Entry<K, V> empty; // Instance-specific EMPTY value
    private final Entry<K, V> tomb;  // Instance-specific TOMB value

    @SuppressWarnings("unchecked")
    public HashMap() {
        this.empty = new Empty<>();
        this.tomb = new Tomb<>();
        this.data = (Entry<K, V>[]) Array.newInstance(Entry.class, 4);
        this.size = 0;

        // Initialize with EMPTY values
        for (int i = 0; i < this.data.length; i++) {
            this.data[i] = this.empty;
        }
    }

    @SuppressWarnings("unchecked")
    private void grow() {
        var prevData = this.data;
        this.data = (Entry<K, V>[]) Array.newInstance(Entry.class, 2 * prevData.length);
        this.size = 0;

        // Initialize with EMPTY values
        for (int i = 0; i < this.data.length; i++) {
            this.data[i] = this.empty;
        }

        // Rehash existing entries
        for (Entry<K, V> entry : prevData) {
            if (entry.isPair()) {
                reinsert(entry);
            }
        }
    }

    private void reinsert(Entry<K, V> entry) {
        if (entry.isPair()) {
            K key = entry.key();
            V value = entry.val();
            int code = key.hashCode();

            for (int i = 0; i < data.length; i++) {
                int idx = modn(code + i);
                if (data[idx].isEmpty()) {
                    data[idx] = entry;
                    break;
                }
            }
        }
    }

    public void put(K key, V val) {
        if (loadFactor() > 0.55) {
            grow();
        }

        var newEntry = new Pair<>(key, val);
        int code = key.hashCode();

        for (int i = 0; i < capacity(); i++) {
            int idx = modn(code + i);

            if (data[idx].isEmpty() || data[idx].isTomb()) {
                data[idx] = newEntry;
                size++;
                return;
            }

            if (data[idx].isPair() && data[idx].key().equals(key)) {
                data[idx] = newEntry;
                return;
            }
        }
        throw new RuntimeException("HashMap is full");
    }

    public boolean hasKey(K key) {
        return getOrNull(key) != null;
    }

    public V get(K key) {
        V value = getOrNull(key);
        if (value == null) {
            throw new RuntimeException("Key not found");
        }
        return value;
    }

    public V getOrNull(K key) {
        int code = key.hashCode();

        for (int i = 0; i < capacity(); i++) {
            int idx = modn(code + i);
            var entry = data[idx];

            if (entry.isEmpty()) {
                return null;
            }

            if (entry.isPair() && entry.key().equals(key)) {
                return entry.val();
            }
        }
        return null;
    }

    public void del(K key) {
        int code = key.hashCode();

        for (int i = 0; i < capacity(); i++) {
            int idx = modn(code + i);
            var entry = data[idx];

            if (entry.isEmpty()) {
                return;
            }

            if (entry.isPair() && entry.key().equals(key)) {
                data[idx] = this.tomb;
                size--;
                return;
            }
        }
    }

    public ArrayList<K> keys() {
        var keys = new ArrayList<K>();
        for (var entry : data) {
            if (entry.isPair()) {
                keys.add(entry.key());
            }
        }
        return keys;
    }

    public double loadFactor() {
        return (double) size / capacity();
    }

    public int capacity() {
        return data.length;
    }

    public int size() {
        return size;
    }

    private int modn(int val) {
        return Math.floorMod(val, data.length);
    }

    // Entry Interface and Its Implementations
    private interface Entry<K, V> {
        default boolean isEmpty() {
            return false;
        }

        default boolean isTomb() {
            return false;
        }

        default boolean isPair() {
            return false;
        }

        default K key() {
            throw new RuntimeException("Not a pair");
        }

        default V val() {
            throw new RuntimeException("Not a pair");
        }
    }

    private record Empty<K, V>() implements Entry<K, V> {
        @Override
        public boolean isEmpty() {
            return true;
        }
    }

    private record Tomb<K, V>() implements Entry<K, V> {
        @Override
        public boolean isTomb() {
            return true;
        }
    }

    private record Pair<K, V>(K key, V val) implements Entry<K, V> {
        @Override
        public boolean isPair() {
            return true;
        }
    }
}
