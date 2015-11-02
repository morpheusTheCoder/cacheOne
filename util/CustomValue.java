package util;

public class CustomValue<K, V> {
	
	
	
	public CustomValue(V value, long creationTime2, long accessTime2, K key) {
		this.data = value;
		this.creationTime= creationTime2;
		this.accessTime = accessTime2;
		this.key = key; 
	}
	public V data;
	public long creationTime;
	public long accessTime;
	public K key;

}
