package cache;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;

import util.CustomValue;
import cacheOne.Comparator;

public class CustomCache<K, V> {
	
	
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
	
	
	
	/*
	 * 
	 LIST should have custom value and not key
	 *
	 */
	
	
	private HashMap<K, CustomValue<K, V>> myHashMap = new HashMap<K, CustomValue<K, V>>();
	private LinkedList<CustomValue<K, V>> myList = new LinkedList<CustomValue<K, V>>();
	private Comparator myComparator = null;
	private int capacity = 0;
	
	public CustomCache(){
	}
	
	
	public CustomCache(int capacity, Comparator myCacheBehavior){
		this.myComparator = myCacheBehavior;
		this.capacity = capacity;
		
	}
	
	protected V get(K key){
		CustomValue<K, V> cValue =  myHashMap.get(key);
		if( cValue == null)
			return null;
		
		V value = cValue.data;
		cValue.accessTime = System.currentTimeMillis();
		
		if(myHashMap.size() == capacity){
			if( myComparator.compare(cValue,  myList.get(0))){
				myList.removeFirst();
				myList.add(cValue);
			}
			else{
				myList.remove(cValue);
			}
		}
		
		return value;
	}
	
	
	protected void put(K key, V value){
		
		long creationTime = System.nanoTime();
		long accessTime = creationTime;
		CustomValue cValue = new CustomValue(value, creationTime, accessTime, key);
		
		

		
		if(myHashMap.size() > capacity){
			
			//if new entry needs to be added, then one entry has to be deleted.
			if( myComparator.compare(cValue,  myList.get(0))){
				
				CustomValue one = myList.removeFirst();
				myHashMap.remove(one.key);
				
				myList.add(cValue);
				myHashMap.put(key, cValue);
				
			}

		}
		else{
			myHashMap.put(key, cValue);
			myList.add(cValue);

		}
		
		
	}
	
	
	
	
	
	@Override
	public String toString(){
		// TODO: Use a json library to convert this hashMap to json?
		
		String output = "";
		for(CustomValue<K, V> cValue: myList){
			output += cValue.data.toString() + ", ";
		}

		return output;
	}

}
