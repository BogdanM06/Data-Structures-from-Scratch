package structures;

@SuppressWarnings("unchecked")
public class HashMap<K extends Comparable<K>, V> implements IMap<K, V> {

    private static class Entry<K, V> {
        K key;
        V value;
        Entry<K, V> next;

        Entry(K key, V value, Entry<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    private Entry<K, V>[] table;
    private int size;

    public HashMap() {
        this(2003);
    }

    public HashMap(int capacity) {
        table = (Entry<K, V>[]) new Entry[capacity];
        size = 0;
    }

    private int hash(K key) {
        int code = key.hashCode();
        return (code & 0x7fffffff) % table.length;
    }

    @Override
    public void add(K key, V value) {
        int index = hash(key);
        Entry<K, V> current = table[index];

        //search the chain to check whether this key already exists.
        while (current != null) {
            //if it exixts replace old value with the new value
            if (current.key.compareTo(key) == 0) {
                current.value = value;
                return;
            }

            current = current.next;
        }

        //key was not found, so add a new entry at the front of the chain.
        table[index] = new Entry<K, V>(key, value, table[index]);
        size++;
    }

    @Override
    public V get(K key) {
        int index = hash(key);
        Entry<K, V> current = table[index];

        //walk through the linked list chain until the key is found
        while (current != null) {
            if (current.key.compareTo(key) == 0) {
                return current.value;
            }

            current = current.next;
        }
        return null;
    }

    @Override
    public boolean containsKey(K key) {
        return get(key) != null;
    }

    @Override
    public boolean remove(K key) {
        int index = hash(key);
        Entry<K, V> current = table[index];
        Entry<K, V> previous = null;

        //search through the chain for the key
        while (current != null) {
            if (current.key.compareTo(key) == 0) {

                //if previous is null, the entry being removed is first in the chain
                if (previous == null) {
                    table[index] = current.next;
                } else {
                    previous.next = current.next;
                }

                size--;
                return true;
            }

            previous = current;
            current = current.next;
        }

        return false;
    }

    @Override
    public int size() {
        return size;
    }
}
