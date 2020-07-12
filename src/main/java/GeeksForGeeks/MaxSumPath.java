package GeeksForGeeks;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class MaxSumPath {
	
	public static void main(String[] args) {
		int[] arr1 = {2,3,7,10,12};
		int[] arr2 = {1,5,7,11};
		System.out.println(maxSumPath(arr1, arr2));
	}
	
	public static int maxSumPath(int[] arr1, int[] arr2) {
		int sum1 = 0; 
		int sum2 = 0; 
		int point1 = 0; 
		int point2 = 0; 
		int maxSum = 0; 
		try {
			for(int i=0; i< arr1.length + arr2.length; i++ ) {
				if( point1 < arr1.length && point2 < arr2.length) { 
					if (arr1[point1] > arr2[point2] ) {
						sum2 = sum2 + arr2[point2];
						point2++; 
					}else if(arr1[point1] < arr2[point2] ) {
						sum1 = sum1 + arr1[point1];
						point1++;
					}else {
						maxSum = maxSum + Math.max(sum2, sum1) + arr1[point1]; 
						sum1 = maxSum ; 
						sum2 = maxSum; 
						point1++; 
						point2++; 
					}
				}else if (point1 == arr1.length && point2 < arr2.length ) {
					maxSum = maxSum + arr2[point2]; 
					point2++; 
				}else if (point2 == arr2.length && point1 < arr1.length ) {
					maxSum = maxSum + arr1[point1]; 
					point1++; 
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return maxSum; 
	}
}
