

import cache.Cache;
import cache.CustomCache;

public class DriverOne {

	public static void main(String[] args) {
		
		CacheBehavior<String> LRU = new LRU();
		Cache<String, String> myCache = new CustomCache<String, String>(3, LRU);
		
		
		myCache.put("1", "One");
		myCache.put("2", "Two");
		myCache.put("3", "Three");
		myCache.put("4", "Four");
		myCache.put("5", "Five");
		
		
		String t = myCache.get("1");
		System.out.println(t);

		
		print(myCache);
		
		
	}

	private static void print(Cache<String, String> myCache) {
		System.out.println(myCache.toString());
		
	}

}
