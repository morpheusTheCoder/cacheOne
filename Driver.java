import cache.SetAssociativeCache;
import cacheOne.Comparator;
import cacheOne.LRU;


public class Driver {
	public static void main(String[] args) {

		Comparator strategy = new LRU();
		SetAssociativeCache myCache = new SetAssociativeCache(10, strategy, 3);
		
//		myCache.put ("1", "One");
//		myCache.put ("2", "Two");
//		myCache.put ("3", "Three");
		
		for ( int i = 0; i < 100; i++){
			myCache.put(String.valueOf(i), String.valueOf(i));
		}
		
		
		System.out.println(myCache.toString());

	}
}
