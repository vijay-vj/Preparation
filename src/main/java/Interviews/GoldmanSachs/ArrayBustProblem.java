package Interviews.GoldmanSachs;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;

public class ArrayBustProblem {

	public static void main(String[] args) {
		// [a, b, e, e, e, e, e, b, b, b, b, d, d, f, f, f, f, f, d, d, d, k, l, m, m,
		// m, m, m, t, s]
		// 5
		// a k l t s
		List<String> inputArray = new ArrayList<String>();
		inputArray.add("a");
		inputArray.add("b");
		inputArray.add("e");
		inputArray.add("e");
		inputArray.add("e");
		inputArray.add("e");
		inputArray.add("e");
		inputArray.add("b");
		inputArray.add("b");
		inputArray.add("b");
		inputArray.add("b");
		inputArray.add("d");
		inputArray.add("d");
		inputArray.add("f");
		inputArray.add("f");
		inputArray.add("f");
		inputArray.add("f");
		inputArray.add("f");
		inputArray.add("d");
		inputArray.add("d");
		inputArray.add("d");
		inputArray.add("k");
		inputArray.add("l");
		inputArray.add("m");
		inputArray.add("m");
		
		List<String> inputArray1 = new ArrayList<String>();
		inputArray1.add("a");
		inputArray1.add("b");
		inputArray1.add("c");
		inputArray1.add("b");
		
		getShrunkArrayV2(inputArray1, 2);
	}

	public static List<String> getShrunkArray(List<String> inputArray, int burstLength) {
		List<String> output = new ArrayList<String>();
		int count = 1;
		// Keep Inserting into a the output List if the prev != curr and the count of
		// curr < burstLength
		// else remove burstLength-1 times

		if (inputArray.size() > 0) {
			String prev = inputArray.get(0);
			output.add(prev);
			if (count == burstLength) {
				output.remove(prev);
			}
			for (int i = 1; i < inputArray.size(); i++) {
				if (prev.equals("")) {
					prev = inputArray.get(i);
				}
				String curr = inputArray.get(i);
				if (!curr.equals(prev)) {
					count = 1;
					output.add(curr);
					prev = curr;
				} else if ((count > burstLength - 1 && !curr.equals(inputArray.get(i + 1))) || (count == burstLength - 1
						&& i < inputArray.size() - 1 && !curr.equals(inputArray.get(i + 1)))) {

					for (int j = 0; j < count; j++) {
						output.remove(output.size() - 1);
					}

					count = 1;
					prev = output.get(output.size() - 1);
					for (int j = output.size() - 2; j > 0; j--) {
						if (prev.equals(output.get(j))) {
							count++;
						} else {
							break;
						}
					}
					// i=i-count;

				} else {
					output.add(curr);
					count++;
				}

				if (i == inputArray.size() - 1 && count == burstLength) {

					for (int j = 0; j < count; j++) {
						output.remove(output.size() - 1);
					}
				}

			}

		}
		System.out.println(output);
		return output;
	}

	public static List<String> getShrunkArrayV2(List<String> inputArray, int burstLength) {
		List<String> output = new ArrayList<String>();
		LinkedHashMap<String, Integer> resultant = new LinkedHashMap<String, Integer>();
		String curr = ""; 
		for(int i=0; i<inputArray.size(); i++) {
		 curr = inputArray.get(i); 
			resultant.put(curr, resultant.containsKey(curr) ? resultant.get(curr) + 1 : 1);
			
			if(resultant.get(curr) >= burstLength && ( i < inputArray.size() -1 &&curr != inputArray.get(i+1))){
				resultant.remove(curr);  
			}
			
			if(i == inputArray.size()-1) {
				if(resultant.get(curr) >= burstLength) {
					resultant.remove(curr);
				}
			}
			
		}
		for( Entry<String, Integer> a : resultant.entrySet()) {
			for(int i=0;i<a.getValue(); i++)
				output.add(a.getKey());
		}
		System.out.println(output);
		return output; 
	}
}
