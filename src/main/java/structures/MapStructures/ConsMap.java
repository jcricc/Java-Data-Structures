package structures.MapStructures;

import java.util.HashSet;
import java.util.Set;

import structures.Interfaces.Map;
import structures.LinkedStructures.ConsList;

public class ConsMap<K, V> implements Map<K, V> {
    private ConsList<Entry<K, V>> data;

    public ConsMap() {
        this.data = ConsList.of();
    }

    @Override
    public void set(K key, V val) {
        Entry<K, V> entry = findEntry(key);
        if (entry != null) {
            data = data.remove(entry);
        }
        data = data.add(new Entry<>(key, val));
    }

    @Override
    public V get(K key) {
        Entry<K, V> entry = findEntry(key);
        if(entry == null) {
            throw new RuntimeException("Key not found");
        }
        return entry.val();
    }

    @Override
    public void del(K key) {
        Entry<K, V> entry = findEntry(key);
        if (entry != null) {
            data = data.remove(entry);
        }
    }

    @Override
    public int size() {
        return data.length();
    }

    @Override
    public boolean containsKey(K key) {
        return findEntry(key) != null;
    }

    @Override
    public Set<K> keySet() {
        Set<K> keys = new HashSet<>();
        for (Entry<K, V> entry : data) {
            keys.add(entry.key());
        }
        return keys;
    }

private Entry<K, V> findEntry(K key) {
    for (Entry<K, V> entry : data) {
        if (entry.key().equals(key)) {
            return entry;
        }
    }
    return null;
}
}

record Entry<K, V>(K key, V val) {
    
}
