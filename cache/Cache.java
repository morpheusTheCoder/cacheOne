package cache;

public interface Cache<K, V> {

	public V get(K key);
	
	public void put(K key, V value);
	
	public void insertAt(int a,  K key);
	
	public void remove(K key);
	
	
}
