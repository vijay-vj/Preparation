package Sorting;

public class InsertionSort {
	public static void main(String[] args) {
		int arr1[] = { 5, 1, 4, 2, 8 }; 
		insertionSort(arr1);
	}
	
	public static void insertionSort(int[] arr1) {
		
		for(int i=0; i<arr1.length; i++) {
			 for(int j=i+1; j < arr1.length; j++ ) {
				 if(arr1[j] < arr1[i] ) {
					 int temp =arr1[j]; 
					 arr1[j]= arr1[i]; 
					 arr1[i]= temp;
				 }
			 }
		}
		for (int i = 0; i < arr1.length; i++) {
			System.out.println(arr1[i]);
		}
		
	}
		
}
