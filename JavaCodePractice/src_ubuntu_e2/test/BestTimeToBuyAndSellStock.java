package test;

public class BestTimeToBuyAndSellStock {
	public class Solution {
		public int maxProfit(int[] prices) {
			int maxProfit = 0;
			int minIndex = 0;
			int buy = 0;
			int sell = 0;
			for (int i = 0; i < prices.length; i++) {
				if (prices[i] < prices[minIndex])
					minIndex = i;
				int diff = prices[i] - prices[minIndex];
				if (diff > maxProfit) {
					maxProfit = diff;
					buy = minIndex;
					sell = i;
				}
			}
			return maxProfit;
		}
	}
}
