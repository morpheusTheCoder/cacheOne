package util;

public class CustomValue<V> {
	
	
	
	public CustomValue(V value, long creationTime2, long accessTime2) {
		this.data = value;
		this.creationTime= creationTime2;
		this.accessTime = accessTime2;
	}
	V data;
	long creationTime;
	long accessTime;

}
