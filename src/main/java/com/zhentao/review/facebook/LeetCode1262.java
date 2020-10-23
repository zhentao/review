package com.zhentao.review.facebook;

/**
 * <b>1262. Greatest Sum Divisible by Three</b><br>
 * Given an array nums of integers, we need to find the maximum possible sum of
 * elements of the array such that it is divisible by three.
 *
 * <pre>
Example 1:

Input: nums = [3,6,5,1,8]
Output: 18
Explanation: Pick numbers 3, 6, 1 and 8 their sum is 18 (maximum sum divisible by 3).

Example 2:

Input: nums = [4]
Output: 0
Explanation: Since 4 is not divisible by 3, do not pick any number.

Example 3:

Input: nums = [1,2,3,4,4]
Output: 12
Explanation: Pick numbers 1, 3, 4 and 4 their sum is 12 (maximum sum divisible by 3).

Constraints:

    1 <= nums.length <= 4 * 10^4
    1 <= nums[i] <= 10^4
 *
 * </pre>
 *
 * @author zhentao.li
 *
 */
public class LeetCode1262 {
    public static void main(String[] args) {
        LeetCode1262 lc = new LeetCode1262();
        System.out.println(lc.maxSumDivThree(new int[] {1,2,3,4,4}));
    }
    public int maxSumDivThree(int[] nums) {
        int[][] dp = new int[nums.length + 1][3];
        dp[0] = new int[] { 0, Integer.MIN_VALUE, Integer.MIN_VALUE };
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int remainder = num % 3;
            if (remainder == 0) {
                dp[i + 1][0] = num + dp[i][0];
                dp[i + 1][1] = num + dp[i][1];
                dp[i + 1][2] = num + dp[i][2];
            } else if (remainder == 1) {
                dp[i+1][0] = Math.max(dp[i][0], num + dp[i][2]);
                dp[i+1][1] = Math.max(dp[i][1], num + dp[i][0]);
                dp[i+1][2] = Math.max(dp[i][2], num + dp[i][1]);
            } else {
                dp[i+1][0] = Math.max(dp[i][0], num + dp[i][1]);
                dp[i+1][1] = Math.max(dp[i][1], num + dp[i][2]);
                dp[i+1][2] = Math.max(dp[i][2], num + dp[i][0]);
            }
        }
        return dp[nums.length][0];
    }
}
