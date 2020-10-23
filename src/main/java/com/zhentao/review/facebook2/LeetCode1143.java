package com.zhentao.review.facebook2;

/**
 * 1143. Longest Common Subsequence<br>
 *
 * Given two strings text1 and text2, return the length of their longest common
 * subsequence.
 *
 * A subsequence of a string is a new string generated from the original string
 * with some characters(can be none) deleted without changing the relative order
 * of the remaining characters. (eg, "ace" is a subsequence of "abcde" while
 * "aec" is not). A common subsequence of two strings is a subsequence that is
 * common to both strings.
 *
 *
 *
 * If there is no common subsequence, return 0.
 *
 *
 * <pre>
Example 1:

Input: text1 = "abcde", text2 = "ace"
Output: 3
Explanation: The longest common subsequence is "ace" and its length is 3.

Example 2:

Input: text1 = "abc", text2 = "abc"
Output: 3
Explanation: The longest common subsequence is "abc" and its length is 3.

Example 3:

Input: text1 = "abc", text2 = "def"
Output: 0
Explanation: There is no such common subsequence, so the result is 0.

Constraints:

    1 <= text1.length <= 1000
    1 <= text2.length <= 1000
    The input strings consist of lowercase English characters only.
 *
 * </pre>
 *
 * @author zhentao.li
 *
 */
public class LeetCode1143 {
    public static void main(String[] args) {
        String text1 = "bsbi";
        String text2 = "abc";
        int result = new LeetCode1143().l2(text1, text2);
        System.out.println(result);
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int length1 = text1.length();
        int length2 = text2.length();
        int[][] dp = new int[length1+1][length2+1];

        for (int i = 0; i < length1; i++) {
            for (int j = 0; j < length2; j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i+1][j+1] = dp[i][j] + 1;
                } else {
                    dp[i+1][j+1] = Math.max(dp[i+1][j], dp[i][j+1]);
                }
            }
        }

        return dp[length1][length2];
    }
    public int l2(String text1, String text2) {
        int length1 = text1.length();
        int length2 = text2.length();
        int memo[] = new int[length2 + 1];

        for (int i = 0; i < length1; i++) {
            int prev = 0;
            for (int j = 0; j < length2; j++) {
                int temp = memo[j+1];
                if (text1.charAt(i) == text2.charAt(j)) {
                    memo[j+1] = prev + 1;
                } else {
                    memo[j+1] = Math.max(memo[j+1], memo[j]);
                }
                prev = temp;
            }
        }
        return memo[length2];
    }
}
