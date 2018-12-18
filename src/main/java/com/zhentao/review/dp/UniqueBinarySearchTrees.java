package com.zhentao.review.dp;

/**
 * <b>96. Unique Binary Search Trees</b>
 * <pre>
 * Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?

Example:

Input: 3
Output: 5
Explanation:
Given n = 3, there are a total of 5 unique BST's:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3


 * </pre>
 * @author zhentao.li
 *
 */
public class UniqueBinarySearchTrees {

	public static void main(String[] args) {
		System.out.println(numTrees(3));
	}
	public static int numTrees(int n) {
		int[][] memo = new int[n+1][n+1];
		memo[1][1] = 1;
		numTrees(1, n, memo);
		return memo[1][n];
	}
	
	private static int numTrees(int start, int end, int[][] memo) {
		if (start > end) {
			return 1;
		}
		if (start == end) {
			memo[start][end] = 1;
			return memo[start][end];
		}
		if (memo[start][end] != 0) {
			return memo[start][end];
		}
		for (int i = start; i <= end; i++) {
		    memo[start][end] += numTrees(start, i-1, memo) * numTrees(i+1, end, memo);
		}
		return memo[start][end];
	}
}
