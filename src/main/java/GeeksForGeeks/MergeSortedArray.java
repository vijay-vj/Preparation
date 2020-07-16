package GeeksForGeeks;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

public class MergeSortedArray {
	
	public static void main(String[] args) {
		int[] arr1 = {1,4,5,8,9,12};
		int[] arr2 = {2,3,6};
		mergeSortedArray(arr1, arr2);
	}
	
	public static void mergeSortedArray(int[] arr1, int[] arr2) {
		ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<Integer, Integer>(); 
		
		for(int i =0; i< arr1.length; i++) {
			map.put(arr1[i], 1);
		}
		for(int i =0; i< arr2.length; i++) {
			map.put(arr2[i], 1);
		}
		
		for(Entry a : map.entrySet()) {
			System.out.println(a.getKey());
		}
		
	}
	
}
