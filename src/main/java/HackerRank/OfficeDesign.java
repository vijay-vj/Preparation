package HackerRank;

import java.util.ArrayList;
import java.util.List;

public class OfficeDesign {

	public static void main(String[] args) {
		List<Integer> prices = new ArrayList<Integer>();
		// 2, 2, 5, 1, 1, 2, 1
		prices.add(2);
		prices.add(3);
		prices.add(5);
		prices.add(1);
		prices.add(1);
		prices.add(2);
		prices.add(1);
		System.out.println(getMaxColors(prices, 7));
	}

	public static int getMaxColors(List<Integer> prices, int money) {
		// Write your code here

		int maxColours = 0;
		int currStartColour = 0;
		int runningCostSum = 0;
		for (int i = 0; i < prices.size(); i++) {

			runningCostSum = runningCostSum + prices.get(i);

			if (runningCostSum > money) {
				while (runningCostSum > money) {
					runningCostSum = runningCostSum - prices.get(currStartColour);
					currStartColour++; 
				}
			}
			
			if( i - currStartColour >= maxColours )
				maxColours = i - currStartColour +1;

		}

		return maxColours;
	}
}
