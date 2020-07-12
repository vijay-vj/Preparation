package GeeksForGeeks;

import java.util.HashMap;
import java.util.Map;

public class CountOfConcAnagrams {
	
	public static void main(String[] args) {
		System.out.println(countOfConcAnagrams("vijayivabccijayv","vijay"));
	}
	
	public static int countOfConcAnagrams(String input , String filter) {
		
		int currentIndex = 0; 
		int countOfConcAna = 0; 
		//char[] inputChar = input.toCharArray(); 
		HashMap<Character, Integer> filterHash = new HashMap<Character,Integer>();
		for(int i=0; i<filter.length(); i++) {
			filterHash.put(filter.charAt(i), 1);
		}
		
		for(int i=0; i<input.length(); i++) {
			if( i<=filter.length()-1 )
			{
				updateHash(filterHash, input.charAt(i));
			}
			else { 
				updateHash(filterHash, input.charAt(i), input.charAt(currentIndex));
				currentIndex++;
			}
			if(checkHash(filterHash)) {
				countOfConcAna ++; 
			}
			
		}
		
		return countOfConcAna; 
	}
	
	private static void updateHash(HashMap<Character, Integer> filterHash,char inputChar) {
		updateHash(filterHash, inputChar, '\0');
	};
	private static void updateHash(HashMap<Character, Integer> filterHash, char inputChar, char removeChar) {
		if( removeChar != '\0' ) {
			if(filterHash.containsKey(removeChar)) { 
				filterHash.put(removeChar, filterHash.get(removeChar)+1); 
			}
		} 
		 if(filterHash.containsKey(inputChar))
			filterHash.put(inputChar, filterHash.get(inputChar)-1);
	 
		 
		 
	}
	private static boolean checkHash(HashMap<Character, Integer> filterHash) {
		
			boolean isPerfectHash = false; 
			for(Map.Entry<Character, Integer> entry : filterHash.entrySet()) {
				if(entry.getValue() ==0 ) {
					isPerfectHash = true; 
				}else {
					isPerfectHash = false;
					break;
				}
			}
			 
			
			return isPerfectHash; 
	}
}
