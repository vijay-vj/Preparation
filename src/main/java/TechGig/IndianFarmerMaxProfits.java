package TechGig;

public class IndianFarmerMaxProfits {

	public static void main(String[] args) {
		indianFarmerMaxProfits(10, 10, 5, 2, 2, 14, 3, 1, 25);
	}

	public static void indianFarmerMaxProfits(int l, int f, int p, int f1, int p1, int s1, int f2, int p2, int s2) {
		// Find Max Rice amount first and left out money
		double maxRice = maxRice(l, f, p, f2, p2, s2);

		System.out.println(maxRice);
		int totalProfit = 0;
		// get the difference and see who will give more profits
		if (maxRice > l) {
			totalProfit = l * s2;
		} else {
			int remainingf = f - (int) maxRice;
			int remainingp = p - (int) maxRice;
			
		}

	}

	public static double maxWheat(int l, int f, int p, int f1, int p1, int s1) {
		return Math.round((f + p) * 100 / (f1 + p1)) * s1 / 100.0;

	}

	public static double maxRice(int l, int f, int p, int f2, int p2, int s2) {
		// return Math.round((f+p) *100/ (f2+p2) )*s2/100.0 ;
		double maxf = Math.round(f / f2);
		double maxp = Math.round(p / p2);

		System.out.println(maxf);
		System.out.println(maxp);
		return Math.min(maxf, maxp);

	}
	
	public static double getProfitFromWheat() {
		double profit = 0.0; 
		
		return profit; 
	}
	public static double getProfitFromRice() {
		double profit = 0.0;  
		return profit; 
	}

}
