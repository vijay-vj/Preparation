package HackerRank;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;


public class CountDuplicateNumbers {

	public static void main(String[] args) {
		List<Integer> numbers = new ArrayList<Integer>() ;
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
		numbers.add(3);
		numbers.add(2);
		numbers.add(2);
		numbers.add(1);
		countDuplicate(numbers);
		
	}

	public static int countDuplicate(List<Integer> numbers) {
		// Write your code here
		int countOfRepeats = 0; 
		HashMap<Integer, Integer> numbersHash = new HashMap<Integer, Integer>();
		try {
			for(int i=0; i<numbers.size(); i++) {
				int value = 0;
				try {
					value = numbersHash.get(numbers.get(i)) ;
				} catch (Exception e) {
					// TODO: handle exception
				} 
				if( value == 1) {
					countOfRepeats++;
				}; 
				numbersHash.put(numbers.get(i), value+1);
				
			}
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		return countOfRepeats; 
	}
}
