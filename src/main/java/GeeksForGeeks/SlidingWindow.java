package GeeksForGeeks;

public class SlidingWindow {
		
	public static void main(String[] args) {
		int  arr[] = {1, 4, 2, 10, 23, 3, 1, 0, 20}; 
		int arr1[] = {1,2,4,10,23,0,5,20,15,3};
		System.out.println(slidingWindow(arr1,4));
		
	}
	
	public static int slidingWindow(int[] arr, int k) { 
		
		int maxSum = 0;
		int currStartVal = 0; 
		if(k > arr.length ) {
			System.out.println("InValid");
		}
		int runningSum = 0; 
		for(int i=0; i<arr.length; i++) {
		
			if( i <= k-1) {
				maxSum = maxSum + arr[i];
				runningSum = maxSum; 
			}else {
				runningSum = runningSum - arr[currStartVal] + arr[i]; 
				if(runningSum > maxSum) {
					maxSum = runningSum;
				}
				currStartVal++;
			}
		}
		return maxSum;
	}
	
	
}
