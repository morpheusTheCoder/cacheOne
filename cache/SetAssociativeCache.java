package cache;


import java.util.ArrayList;
import java.util.List;

import cacheOne.Comparator;
import cacheOne.LRU;
import cacheOne.MRU;

public class SetAssociativeCache<K, V> implements Cache<K, V>{
	
	List<CustomCache<K, V>> myCacheOne =  new ArrayList<CustomCache<K, V>>();
	int bucketCount = 10;
	
	
	public SetAssociativeCache(int bucketCount, Comparator strategy, int capacity) {
		this.bucketCount = bucketCount;
		
		for (int i1 = 0; i1 < bucketCount; i1++){
			myCacheOne.add(new CustomCache<K, V>( capacity, strategy));
			
		}
		
	}

	public void put (K k, V v ){
		
		int bucketNumber = getBucketNumber(k);
		myCacheOne.get(bucketNumber).put(k,  v);
		
	}
	
	
	public V get(K k){
		int bucketNumber = getBucketNumber(k);
		return myCacheOne.get(bucketNumber).get(k);
	}


	private int getBucketNumber(K k) {
		return k.hashCode() % bucketCount;
	}
	
	@Override
	public String toString(){
		String t = "";
		for(int i = 0; i < bucketCount; i++){
			t += myCacheOne.get(i).toString();
			t += "\n\r";
		}
		return t;
		
	}
	
	
	
	
	

}
