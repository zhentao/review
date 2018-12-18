package com.zhentao.review.dp;

/**
 * <b>712. Minimum ASCII Delete Sum for Two Strings</b>
 * 
 * <pre>
 * Given two strings s1, s2, find the lowest ASCII sum of deleted characters to make two strings equal.

Example 1:

Input: s1 = "sea", s2 = "eat"
Output: 231
Explanation: Deleting "s" from "sea" adds the ASCII value of "s" (115) to the sum.
Deleting "t" from "eat" adds 116 to the sum.
At the end, both strings are equal, and 115 + 116 = 231 is the minimum sum possible to achieve this.

Example 2:

Input: s1 = "delete", s2 = "leet"
Output: 403
Explanation: Deleting "dee" from "delete" to turn the string into "let",
adds 100[d]+101[e]+101[e] to the sum.  Deleting "e" from "leet" adds 101[e] to the sum.
At the end, both strings are equal to "let", and the answer is 100+101+101+101 = 403.
If instead we turned both strings into "lee" or "eet", we would get answers of 433 or 417, which are higher.

Note:
0 < s1.length, s2.length <= 1000.
All elements of each string will have an ASCII value in [97, 122].
 * 
 * </pre>
 *
 * @author zhentao.li
 *
 */
public class MinimumASCIIDeleteSumForTwoStrings {
	public static void main(String[] args) {
		
//		System.out.println(sumMemo("delete", "leet"));
//		System.out.println(dp("delete", "leet"));
//		System.out.println(sumMemo("sea", "eat"));
		System.out.println(dp("a", "at"));
		
	}

	public static int sum(String a, String b) {

		return sum(a, a.length(), b, b.length());
	}

	private static int sum(String a, int m, String b, int n) {
		if (n == 0) {
			int total = 0;
			for (int i = 0; i < m; i++) {
				total += a.codePointAt(i);
			}
			return total;
		}
		if (m == 0) {
			int total = 0;
			for (int i = 0; i < n; i++) {
				total += b.codePointAt(i);
			}
			return total;
		}
		if (a.charAt(m - 1) == b.charAt(n - 1)) {
			return sum(a, m - 1, b, n - 1);
		} else {
			int deleteA = sum(a, m - 1, b, n) + a.codePointAt(m - 1);
			int deleteB = sum(a, m, b, n - 1) + b.codePointAt(n - 1);
			return Math.min(deleteA, deleteB);
		}
	}

	public static int sumMemo(String a, String b) {
		int[][] memo = new int[a.length()][b.length()];
		return sumMemo(a, a.length(), b, b.length(), memo);
	}

	private static int sumMemo(String a, int m, String b, int n, int[][] memo) {
		if (n == 0) {
			int total = 0;
			for (int i = 0; i < m; i++) {
				total += a.charAt(i);
			}
			return total;
		}
		if (m == 0) {
			int total = 0;
			for (int i = 0; i < n; i++) {
				total += b.codePointAt(i);
			}
			return total;
		}
		if (memo[m-1][n-1] != 0) {
			return memo[m-1][n-1];
		}
		if (a.charAt(m - 1) == b.charAt(n - 1)) {
			memo[m-1][n-1] = sumMemo(a, m - 1, b, n - 1, memo);
			return memo[m-1][n-1];
		} else {
			int deleteA = sumMemo(a, m - 1, b, n, memo) + a.codePointAt(m - 1);
			int deleteB = sumMemo(a, m, b, n - 1, memo) + b.codePointAt(n - 1);
			memo[m-1][n-1] = Math.min(deleteA, deleteB);
			return memo[m-1][n-1];
		}
	}
	
	public static int dp(String a, String b) {
		
		int lengthA = a.length();
		int lengthB = b.length();
		int[][] dp = new int[lengthA+1][lengthB+1];
		
		dp[0][0] = 0;
		for (int i = 1; i <= lengthA; i++) {
			dp[i][0] = dp[i-1][0] + a.codePointAt(i-1);
		}
		
		for (int j = 1; j <= lengthB; j++) {
			dp[0][j] = dp[0][j-1] + b.codePointAt(j-1);
		}
		
		for (int i = 0; i < lengthA; i++) {
			for (int j = 0; j < lengthB; j++) {
				if (a.charAt(i) == b.charAt(j)) {
					dp[i+1][j+1] = dp[i][j];
				} else {
					dp[i+1][j+1] = Math.min(dp[i][j+1] + a.codePointAt(i), dp[i+1][j] + b.codePointAt(j));
				}
			}
		}
		return dp[lengthA][lengthB];
	}
}
