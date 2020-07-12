package GeeksForGeeks;

import java.util.Stack;

public class MaxAreaInHistorgram {

	
	public static void main(String[] args) {
		//long[] arr = {6,2,5,4,5,1,6};
		long[] arr = {1,2,1,2,1,2,1};
		
		long maxArea = maxArea(arr);
		System.out.println(maxArea);
	}
	
	public static long maxArea(long[] arr) {
	    Stack<Integer> stack = new Stack<>();
	    long maxArea = 0L;
	    int i = 0;
	    int n = arr.length;
	    
	    while (i < n) {
	        if (stack.isEmpty() || arr[i] >= arr[stack.peek()]) {
	            stack.push(i);
	            i++;
	        }
	        else {
	            int p = stack.pop();
	            long h = arr[p];
	            long w = (long)(stack.isEmpty() ? i : i - stack.peek() - 1);
	            maxArea = Math.max(maxArea, h * w);
	        }
	    }
	    
	    while (!stack.isEmpty()) {
	        int p = stack.pop();
	        long h = arr[p];
	        long w = stack.isEmpty() ? i : i - stack.peek() - 1;
	        maxArea = Math.max(maxArea, h * w);
	    }
	    
	    return maxArea;
	}
}
