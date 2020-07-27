package HackerRank;

import java.util.ArrayList;
import java.util.List;

public class MaxSumPaypal { 

	static int maxSubArraySum(List<Integer> inputArray) 
	{ 	
		int size= inputArray.size(); 
		int max_so_far = Integer.MIN_VALUE, 
		max_ending_here = 0,start = 0, 
		end = 0, s = 0; 

		for (int i = 0; i < size; i++) 
		{ 
			max_ending_here += inputArray.get(i); 

			if (max_so_far < max_ending_here) 
			{ 
				max_so_far = max_ending_here; 
				start = s; 
				end = i; 
			} 

			if (max_ending_here < 0) 
			{ 
				max_ending_here = 0; 
				s = i + 1; 
			} 
		} 
		return max_so_far; 
	} 

	// Driver code 
	public static void main(String[] args) 
	{ 
		int a[] = { -2, -3, 4, -1, -2, 1, 5, -3 }; 
		
		List<Integer> inputArray = new ArrayList<Integer>();
		inputArray.add(-2);
		inputArray.add(-3);
		inputArray.add(4);
		inputArray.add(-1);
		inputArray.add(-2);
		inputArray.add(1);
		inputArray.add(5);
		inputArray.add(-3);
				
		System.out.println(maxSubArraySum(inputArray)); 
	} 
} 

// This code is contributed by prerna saini 
