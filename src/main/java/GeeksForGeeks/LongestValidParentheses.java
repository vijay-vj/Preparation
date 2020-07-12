package GeeksForGeeks;
/*
 * Need to complete
 * 
 */
public class LongestValidParentheses {
	public static void main(String[] args) {
		longestValidParentheses(")()())");
	}
	
	public static int longestValidParentheses(String input) {
		boolean openingFound = false;
		int startIndex = -1;
		int maxLength = 0; 
		for(int i=0; i < input.length(); i++) {
			if( input.charAt(i) == '(' && !openingFound) {
				openingFound = true;
				startIndex = i;  
			}else if(input.charAt(i) == ')' &  openingFound) {
				if(i-startIndex-1 > maxLength)
					maxLength = i-startIndex-1; 
			}
		}
		System.out.println(maxLength);
		return maxLength; 
	}	
	
}
