package HackerRank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AnagramDifference {

	public static void main(String[] args) {
		List<String> a = new ArrayList<String>();
		List<String> b = new ArrayList<String>();
 		a.add("abc"); 
 		b.add("bba");
		 
		getMinimumDifference(a,b);
	}

	public static List<Integer> getMinimumDifference(List<String> a, List<String> b) {
		// Write your code here
		List<Integer> result = new ArrayList<Integer>();
		int min = Math.min(a.size(), b.size());
		for(int i=0;i <min; i++) {
			String aStr = a.get(i); 
			String bStr = b.get(i); 
			
			if(aStr.length() == bStr.length()) {
			int misHaps = 0; 
			HashMap<Character, Integer> aHash = new HashMap<Character, Integer>();
			for(int j=0;j<aStr.length(); j++) {
				aHash.put(aStr.charAt(j), aHash.containsKey(aStr.charAt(j))? aHash.get(aStr.charAt(j))+ 1 : 1); 
			}
			
			for(int j=0;j<bStr.length(); j++) {
				if(!aHash.containsKey(bStr.charAt(j))) {
					misHaps++; 
				}else {
					int size = aHash.get(bStr.charAt(j));
					if(size > 1)
					{
						aHash.put(bStr.charAt(j), size-1);
					}else {
						aHash.remove(bStr.charAt(j));
					}
				}
			}
			result.add(misHaps);
			
			}else {
				result.add(-1);
			}
			
		}
		
		for(int i =0; i < Math.max(a.size(), b.size()) - min; i++) {
			result.add(-1);
		}
		for(int i=0; i<result.size(); i++) {
			System.out.println(result.get(i));
		}
		
		return result;
	}

}
