package com.zhentao.review.dp;

/**
 * <b>486. Predict the Winner</b>
 * 
 * <pre>
 * Given an array of scores that are non-negative integers. Player 1 picks one of the numbers from either end of the array 
 * followed by the player 2 and then player 1 and so on. Each time a player picks a number, that number will not be 
 * available for the next player. This continues until all the scores have been chosen. The player with the maximum score 
 * wins.

Given an array of scores, predict whether player 1 is the winner. You can assume each player plays to maximize his score.

Example 1:

Input: [1, 5, 2]
Output: False
Explanation: Initially, player 1 can choose between 1 and 2. 
If he chooses 2 (or 1), then player 2 can choose from 1 (or 2) and 5. If player 2 chooses 5, then player 1 will be left with 1 (or 2). 
So, final score of player 1 is 1 + 2 = 3, and player 2 is 5. 
Hence, player 1 will never be the winner and you need to return False.

Example 2:

Input: [1, 5, 233, 7]
Output: True
Explanation: Player 1 first chooses 1. Then player 2 have to choose between 5 and 7. No matter which number player 2 choose, player 1 can choose 233.
Finally, player 1 has more score (234) than player 2 (12), so you need to return True representing player1 can win.

Note:

    1 <= length of the array <= 20.
    Any scores in the given array are non-negative integers and will not exceed 10,000,000.
    If the scores of both players are equal, then player 1 is still the winner.
 * 
 * </pre>
 * 
 * @author zhentao.li
 *
 */
public class WinnerPrediction {
	public static void main(String[] args) {
		int[] input = { 1, 5, 2 };
		System.out.println(predicate(input));
		System.out.println(PredictTheWinnerTopDown(input));

		input = new int[] { 1, 5, 233, 7 };
		System.out.println(predicate(input));
		System.out.println(PredictTheWinnerTopDown(input));

		input = new int[] { 3, 5, 3 };
		System.out.println(predicate(input));
		System.out.println(PredictTheWinnerTopDown(input));
	}

	public static boolean predicate(int[] input) {
		int length = input.length;
		int[][] memo = new int[length][length];
		return calculate(input, 0, length - 1, memo) >= 0;
	}

	private static int calculate(int[] input, int start, int end, int[][] memo) {
		if (start == end) {
			return input[start];
		}

		if (memo[start][end] != 0) {
			return memo[start][end];
		}

		int chooseStart = input[start] - calculate(input, start + 1, end, memo);
		int chooseEnd = input[end] - calculate(input, start, end - 1, memo);
		memo[start][end] = Math.max(chooseStart, chooseEnd);
		return memo[start][end];
	}

	/**
	 * dynamic programming with 2-D array bottom up
	 * 
	 * @param nums
	 * @return
	 */
	public static boolean PredictTheWinner(int[] nums) {
		int length = nums.length;
		int[][] dp = new int[length][length];
		for (int s = length - 1; s >= 0; s--) {
			dp[s][s] = nums[s];
			for (int e = s + 1; e < length; e++) {
				int a = nums[s] - dp[s + 1][e];
				int b = nums[e] - dp[s][e - 1];
				dp[s][e] = Math.max(a, b);
			}
		}
		return dp[0][length - 1] >= 0;
	}

	/**
	 * top down
	 * @param nums
	 * @return
	 */
	public static boolean PredictTheWinnerTopDown(int[] nums) {
		int length = nums.length;
		int[][] dp = new int[length][length];
		for (int e = 0; e < length; e++) {
			dp[e][e] = nums[e];
			for (int s = e - 1; s >= 0; s--) {
				int a = nums[s] - dp[s + 1][e];
				int b = nums[e] - dp[s][e - 1];
				dp[s][e] = Math.max(a, b);
			}
		}
		return dp[0][length - 1] >= 0;
	}
	
	public static boolean oneDArray(int[] nums) {
		int[] dp = new int[nums.length];
		for (int s = nums.length - 1; s >= 0; s--) {
			dp[s] = nums[s];
			for (int e = s + 1; e < nums.length; e++) {
				int a = nums[s] - dp[e]; // in the loop, s is not changed so s can be removed.
				int b = nums[e] - dp[e - 1];
				dp[e] = Math.max(a, b);
			}
		}
		return dp[nums.length - 1] >= 0;
	}
}
