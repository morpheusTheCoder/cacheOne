package cache;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;

import util.CustomValue;
import cacheOne.CacheBehavior;

public class CustomCache<K, V>  implements Cache<K, V>{
	
	
	/*
	 * TODO: Cache should have some capacity
	 * should have some way to iterate over the elements
	 * when inserting capacity+1 element, it should remove the oldest element. 
	 * LRU = remove last accessed element
	 * MRU = remove first accessed element
	 * How to define a chronology in 
	 * 
	 * I will have to use a HashMap and matain a linkedList.
	 * What would the delegate do?
	 * delegate will add to hashMap and then they will check for the oldestItem and then will delete it.
	 * 
	 * delegate is just a comparator. Users passed the comparator and one each insert we maintain the order as in the comparator.
	 * And we always delete the first element from the list.
	 */
	
	private HashMap<K, CustomValue<V>> myHashMap = new HashMap<K, CustomValue<V>>();
	private LinkedList<K> myList = new LinkedList<K>();
	private CacheBehavior<K> myCacheBehavior = null;
	private int capacity = 0;
	
	public CustomCache(){
	}
	
	
	public CustomCache(int capacity, CacheBehavior<K> myCacheBehavior){
		this.myCacheBehavior = myCacheBehavior;
		this.capacity = capacity;
		
	}
	
	public V get(K key){
		CustomValue<V> cValue =  myHashMap.get(key);
		if( cValue == null)
			return null;
		
		V value = cValue.data;

		myCacheBehavior.get(myList,key);
		return value;
	}
	
	
	public void put(K key, V value){
		
		long creationTime = System.currentTimeMillis();
		long accessTime = creationTime;
		CustomValue cValue = new CustomValue(value, creationTime, accessTime);
		
		
		myHashMap.put(key, value);
		myList.add(key);
		myCacheBehavior.put();
		
		if(myHashMap.size() > capacity){
			K k1 = myList.removeFirst();
			System.out.println("Removing..." + k1);
			myHashMap.remove(k1);
		}
		
		
	}
	
	
	
	@Override
	public void insertAt(int i, K key){
		myList.add(i, key);
	}
	
	
	
	@Override
	public void remove(K key){
		myList.remove(key);
	}
	
	
	
	@Override
	public String toString(){
		// TODO: Use a json library to convert this hashMap to json?
		
		String output = "";
		for( K key : myList){
			output += key.toString() + ", ";
		}

		return output;
	}

}
