package Sorting;

public class MergeSort {
	public static void main(String[] args) {
		int arr1[] = { 5, 1, 4, 2, 8 }; 
		mergeSort(arr1, 0, arr1.length-1);
	}
	
	public static void mergeSort(int[] arr1, int l, int r) {
		
		
		if( l < r) {
			int m = (l+r)/2; 
			
			mergeSort( arr1, l ,m);
			mergeSort( arr1, m + 1 , r);
			
			merge(arr1, l, m, r); 
			
		} 
	}
	
	public static void merge(int[] arr1, int l, int m, int r) {
		
		
		
		
	}
	
	
		
}
