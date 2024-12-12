package structures.Interfaces;

import java.util.Set;

public interface Map<K, V> {
    void set(K key, V val);
    V get(K key);
    void del(K key);
    int size();
    boolean containsKey(K key);
    Set<K> keySet();
}
