

import cache.Cache;
import cache.CustomCache;
import cacheOne.Comparator;
import cacheOne.LRU;
import cacheOne.MRU;

public class DriverOne {

	public static void main(String[] args) {
		
		
		// TODO: Fix off by one error with capacity
		// TODO: more thorough testing. Add testcases.
		
		Comparator strategy = new MRU();
		int capacity = 3;
		
		
		Cache<String, String> myCache 
			= new CustomCache<String, String>( capacity, strategy);
		
		
		myCache.put("1", "One");
		myCache.put("2", "Two");
		myCache.put("3", "Three");
		myCache.put("4", "Four");
		myCache.put("5", "Five");
		myCache.put("6", "Six");

		System.out.println(myCache.toString());
	}

}
