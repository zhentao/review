package com.zhentao.review.dp;

/**
 * <b>357. Count Numbers with Unique Digits</b>
 * 
 * <pre>
 *Given a non-negative integer n, count all numbers with unique digits, x, where 0 ≤ x < 10^n.

Example:

Input: 2
Output: 91 
Explanation: The answer should be the total numbers in the range of 0 ≤ x < 100, 
             excluding 11,22,33,44,55,66,77,88,99


 * </pre>
 * @author zhentao.li
 *
 */
public class UniqueDigits {
	public static void main(String[] args) {
		System.out.println(find(3));
	}
	
	public static int find(int n) {
		
		int availableDigits = 10; //only 10 different answers since there are only 10 digits from 0 to 9
		int[] dp = new int[availableDigits + 1]; 
		dp[1] = 10;
		dp[2] = 81;
		for (int i = 3; i <= availableDigits; i++) {
			dp[i] = dp[i-1] * (availableDigits - i + 1); 
		}
		
		int[] lookup = new int[availableDigits + 1];
		lookup[1] = 10;
		for (int i = 2; i <= availableDigits; i++) {
			lookup[i] = lookup[i-1] + dp[i];
		}
		if (n > 10) {
			n = 10;
		}
		return lookup[n];
	}
}
