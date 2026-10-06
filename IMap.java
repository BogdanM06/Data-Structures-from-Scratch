package structures;

public interface IMap<K extends Comparable<K>, V> {

    /**
     * Adds a new key-value pair, or replaces the value if the key already exists.
     * @param key the key to store under
     * @param value the value to store
     */
    public void add(K key, V value);

    /**
     * Gets the value stored under a key.
     * @param key the key to search for
     * @return the matching value, or null if the key is not found
     */
    public V get(K key);

    /**
     * Checks whether the map contains a key.
     * @param key the key to search for
     * @return true if the key exists, false otherwise
     */
    public boolean containsKey(K key);

    /**
     * Removes a key-value pair from the map.
     * @param key the key to remove
     * @return true if something was removed, false otherwise
     */
    public boolean remove(K key);

    /**
     * Gets the number of key-value pairs stored in the map.
     * @return the number of entries
     */
    public int size();
}