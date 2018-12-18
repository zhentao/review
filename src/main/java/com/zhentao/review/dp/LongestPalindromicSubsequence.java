package com.zhentao.review.dp;

/**
 * <b>516. Longest Palindromic Subsequence</b>
 * 
 * <pre>
 *  Given a string s, find the longest palindromic subsequence's length in s. You may assume that the maximum length of s is 1000.

Example 1:
Input:

"bbbab"

Output:

4

One possible longest palindromic subsequence is "bbbb".

Example 2:
Input:

"cbbd"

Output:

2

One possible longest palindromic subsequence is "bb".
 * </pre>
 * 
 * @author zhentao.li
 *
 */
public class LongestPalindromicSubsequence {
	public static void main(String[] args) {
		System.out.println(longestPalindromeSubseq("bbbab"));
		System.out.println(longestPalindromeSubseq("cbbd"));
	}
	public static int longestPalindromeSubseq(String s) {
		int length = s.length();
		int[][] memo = new int[length][length];
		return longestPalindromeSubseq(s, 0, length-1, memo);
	}
	
	/**
	 * 
	 * otherwise, choose either start or end and return the max
	 * @param s
	 * @param i
	 * @param j
	 * @param memo
	 * @return
	 */
	private static int longestPalindromeSubseq(String s, int i, int j, int[][] memo) {
		if (i > j) {
			return 0;
		}
		if (i == j) {
			return 1;
		}
		
		if (memo[i][j] != 0) {
			return memo[i][j];
		}
		if (s.charAt(i) == s.charAt(j)) {
			//if the chars at start and end position are same, they must be in the palindromic subsequence
			memo[i][j] = longestPalindromeSubseq(s, i + 1, j - 1, memo) + 2;
		} else {
			//otherwise, try either start+1 or end-1 and return the max
			memo[i][j] = Math.max(longestPalindromeSubseq(s, i+1, j, memo), longestPalindromeSubseq(s, i, j-1, memo));
		}
		return memo[i][j];
	}
}
