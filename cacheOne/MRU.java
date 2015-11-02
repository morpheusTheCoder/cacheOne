package cacheOne;

import java.util.LinkedList;

import util.CustomValue;

public class MRU implements Comparator {

	
	public boolean compare(CustomValue value1, CustomValue value2){
		return value1.accessTime < value2.accessTime;
	}
	
	

}
