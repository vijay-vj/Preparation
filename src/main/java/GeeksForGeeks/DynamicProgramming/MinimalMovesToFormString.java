package GeeksForGeeks.DynamicProgramming;

public class MinimalMovesToFormString {

	public static int minimalMovesDP(String str) {

		int[] strg = new int[str.length()];

		strg[0] = 1;

		for (int i = 1; i < strg.length; i++) {
			if (str.substring(0, i / 2 + 1).equals(str.substring(i / 2 + 1, i + 1))) {
				strg[i] = strg[i / 2] + 1;
			} else {
				strg[i] = strg[i - 1] + 1;
			}
		}

		return strg[strg.length - 1];
	}

	// Driver Code
	public static void main(String args[]) {

		String s = "abcabc"; 
		int n = s.length();

		// fucntion call to return minimal number of moves
		System.out.println(minimalMovesDP(s));
	}
}