package com.zhentao.review.cracking;

/**
 * 8.11 Coins: Given an infinite number of quarters (25 cents), dimes (10
 * cents), nickels (5 cents), and pennies (1 cent), write code to calculate the
 * number of ways of representing n cents.
 * 
 * @author zhentao.li
 *
 */
public class Coins {
	public static void main(String[] args) {
		int[] coins = { 1, 5, 10, 25 };
		System.out.println(dp(coins, 5));
	}

	public static int dp(int[] coins, int target) {
		int[] dp = new int[target + 1];
		dp[0] = 1;
		for (int coin : coins) {
			for (int i = coin; i <= target; i++) {
				if (target >= coin) {
					dp[i] = dp[i] + dp[i - coin];
				}
			}
		}
		return dp[target];
	}
	
	public static int memo(int[] coins, int target) {
		
		return 0;
	}
}
