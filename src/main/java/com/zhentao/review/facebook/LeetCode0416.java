package com.zhentao.review.facebook;

/**
 * <b>416. Partition Equal Subset Sum</b> Given a non-empty array containing
 * only positive integers, find if the array can be partitioned into two subsets
 * such that the sum of elements in both subsets is equal.
 *
 * <pre>
Note:

    Each of the array element will not exceed 100.
    The array size will not exceed 200.


Example 1:

Input: [1, 5, 11, 5]

Output: true

Explanation: The array can be partitioned as [1, 5, 5] and [11].


Example 2:

Input: [1, 2, 3, 5]

Output: false

Explanation: The array cannot be partitioned into equal sum subsets.
 * </pre>
 *
 * @author zhentao.li
 *
 */
public class LeetCode0416 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        // odd sum
        if (sum % 2 == 1) {
            return false;
        }
        int subSum = sum / 2;

        return dfs(nums, nums.length - 1, subSum);
    }

    private boolean dfs(int[] num, int index, int subSum) {
        if (subSum == 0) {
            return true;
        }
        if (index == 0 || subSum < 0) {
            return false;
        }
        //This problem is converted to find the sum of the elements to be sum/2
        //For one element, it may or may not be used to find sum/2.
        //include nums[index] || not include nums[index]
        return dfs(num, index - 1, subSum - num[index]) || dfs(num, index - 1, subSum);
    }

    public boolean canPartitionDP(int[] nums) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        // odd sum
        if (sum % 2 == 1) {
            return false;
        }
        int subSum = sum / 2;

        boolean[][] dp = new boolean[nums.length+1][subSum+1];
        //empty array is true
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i < dp.length; i++) {
            int current = nums[i - 1];
            for (int j = 1; j < dp[0].length; j++) {
                if (current > j) {
                    //not include current element since it is greater than the sum,
                    //so it is same as previous element
                    dp[i][j] = dp[i-1][j];
                } else {
                    //include current element || not include the current element
                    dp[i][j] = dp[i-1][j-current] || dp[i-1][j];
                }
            }
        }
        return dp[nums.length][subSum];
    }

    public boolean canPartitionDP1D(int[] nums) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        // odd sum
        if (sum % 2 == 1) {
            return false;
        }
        int subSum = sum / 2;

        boolean[] dp = new boolean[subSum+1];
        //empty array is true
        dp[0] = true;

        for (int x : nums) {
            //from left to right means dp[i][j] = dp[i][j-nums[i-1]])
            //form right to left means dp[i][j] = dp[i-1][j-nums[i-1]]
            for (int j = subSum; j >= x; j--) {
                dp[j] = dp[j] || dp[j-x];
            }
        }
        return dp[subSum];
    }
}
