package Sorting;

public class BubbleSort {
	public static void main(String[] args) {
		int arr1[] = { 5, 1, 4, 2, 8 }; 
		buddleSort(arr1);
	}
	// 
	public static void buddleSort(int[] arr1) {
		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr1.length - i -1 ; j++) {
				if( arr1[j] > arr1[j+1]) {
					// swap
					int temp = arr1[j+1]; 
					arr1[j+1] = arr1[j]; 
					arr1[j] = temp; 
				}
			}
		}
		
		for (int i = 0; i < arr1.length; i++) {
			System.out.println(arr1[i]);
		}
		
	}
	
	
	
}
