package com.zhentao.review.dp;

/**
 * <b>62. Unique Paths</b>
 * <pre>
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?

Note: m and n will be at most 100.

Example 1:

Input: m = 3, n = 2
Output: 3
Explanation:
From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Right -> Down
2. Right -> Down -> Right
3. Down -> Right -> Right

Example 2:

Input: m = 7, n = 3
Output: 28


 * </pre>
 * @author zhentao.li
 *
 */
public class UniquePaths {

	public static void main(String[] args) {
		System.out.println(count(3, 2));
		System.out.println(count(7, 3));
	}
	public static int count(int m, int n) {
		int[][] memo = new int[m][n];
		memo[0][0] = 1;
		for (int i = 1; i < m; i++) {
			memo[i][0] = 1;
		}
		for (int i = 1; i < n; i++) {
			memo[0][i] = 1;
		}
		
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				memo[i][j] = memo[i][j-1] + memo[i-1][j];
			}
		}
		return memo[m-1][n-1];
	}
}
