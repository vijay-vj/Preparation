package Interviews.GoldmanSachs;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class StringEncoding {
	public static void main(String[] args) {
		
		String inputString = "GGGTTGGGG";
		//inputString = "GGGGGrrrrrrrrrrrrrrt";
		System.out.println(collapseString(inputString));
	}

	public static String collapseString(String inputString) {
		System.out.println(inputString);
		String outputString = "";
		if (inputString.length() > 0) {
			Character prev = inputString.charAt(0);

			LinkedHashMap<Character, Integer> resultant = new LinkedHashMap<Character, Integer>();
			for (int i = 0; i < inputString.length(); i++) {
				Character curr = inputString.charAt(i);
				resultant.put(curr, resultant.containsKey(curr) ? resultant.get(curr) + 1 : 1);
				if (!curr.equals(prev)) {
					outputString = outputString.concat(Integer.toString(resultant.get(prev)) + prev);
					resultant.remove(prev);
					prev = curr;
				}
			}

			for (Entry<Character, Integer> a : resultant.entrySet()) {
				outputString = outputString.concat(Integer.toString(a.getValue()) + a.getKey());
			}
		}
		
		return outputString;
	}

}