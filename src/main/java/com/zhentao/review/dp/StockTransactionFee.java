package com.zhentao.review.dp;

/**
 * <b>714. Best Time to Buy and Sell Stock with Transaction Fee</b>
 * 
 * <pre>
You are given an array of integers prices, for which the i-th element is the price of a given stock on day i; 
and a non-negative integer fee representing a transaction fee.

You may complete as many transactions as you like, but you need to pay the transaction fee for each transaction. 
You may not buy more than 1 share of a stock at a time (ie. you must sell the stock share before you buy again.)

Return the maximum profit you can make.

Example 1:

Input: prices = [1, 3, 2, 8, 4, 9], fee = 2
Output: 8
Explanation: The maximum profit can be achieved by:
Buying at prices[0] = 1
Selling at prices[3] = 8
Buying at prices[4] = 4
Selling at prices[5] = 9
The total profit is ((8 - 1) - 2) + ((9 - 4) - 2) = 8.

Note:
0 < prices.length <= 50000.
0 < prices[i] < 50000.
0 <= fee < 50000.
 * </pre>
 * 
 * @author zhentao.li
 *
 */
public class StockTransactionFee {
	public static void main(String[] args) {
		int[] prices = { 4, 5, 2, 4, 3, 3, 1, 2, 5, 4 };
		int fee = 1;
//		System.out.println(trade(prices, fee) == 4);
//		System.out.println(tradeRecursive(prices, fee));
//
//		fee = 2;
//		prices = new int[] { 2, 2, 1, 1, 5, 5, 3, 1, 5, 4 };
//		System.out.println(trade(prices, fee) == 4);

		fee = 2;
		prices = new int[] { 1, 3, 2, 8, 4, 9 };
		//System.out.println(trade(prices, fee) == 8);
		System.out.println(tradeRecursive(prices, fee));
	}

	public static int trade(int[] prices, int fee) {
		int[] dp = new int[prices.length];
		int cost = prices[0];
		for (int i = 1; i < prices.length; i++) {
			cost = Math.min(cost, prices[i] - dp[i - 1]);
			dp[i] = Math.max(dp[i - 1], prices[i] - fee - cost);
		}

		return dp[prices.length - 1];
	}

	/**
	 * NOT correct
	 * @param prices
	 * @param fee
	 * @return
	 */
	public static int tradeRecursive(int[] prices, int fee) {

		
		int length = prices.length-1;
		return tradeRecursive(prices, fee, length);
	}

	private static int tradeRecursive(int[] prices, int fee, int day) {
		if (day == 0) {
			return 0;
		}
		
		return Math.max(tradeRecursive(prices, fee, day-1), prices[day] - fee);
	}
}
