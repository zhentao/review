package com.zhentao.review.dp;

import java.util.Arrays;

/**
 * <b>377. Combination Sum IV</b>
 *
 * <pre>
 *  Given an integer array with all positive numbers and no duplicates,
 *  find the number of possible combinations that add up to a positive integer target.

Example:

nums = [1, 2, 3]
target = 4

The possible combination ways are:
(1, 1, 1, 1)
(1, 1, 2)
(1, 2, 1)
(1, 3)
(2, 1, 1)
(2, 2)
(3, 1)

Note that different sequences are counted as different combinations.

Therefore the output is 7.

Follow up:
What if negative numbers are allowed in the given array?
How does it change the problem?
What limitation we need to add to the question to allow negative numbers?
 * </pre>
 *
 * @author zhentao.li
 *
 */

public class CombinationSumIV {

    public static void main(String[] args) {
        System.out.println(oneAway("a", "bc"));
        System.out.println(editDistanceDP("a", "bc"));
        System.out.println(oneAway("a", "c"));
        System.out.println(editDistanceDP("a", "c"));
        System.out.println(combinations(new int[] { 1, 2, 3, 4 }, 10));
        System.out.println(combinationsMemo(new int[] { 1, 2, 3, 4 }, 10));
        System.out.println(combDP(new int[] { 1, 2, 3, 4 }, 10));
        System.out.println(uniqueWays(new int[] { 1, 2, 3, 4 }, 10));
        System.out.println(uniqueWaysMemo(new int[] { 1, 2, 3, 4 }, 10));
    }

    public static int combDP(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int x : nums) {
            for (int i = x; i <= target; i++) {
                //dp[i] is the ways to make the current sum without current coin
                //dp[i-x] is the ways to make the current sum with current coin
                //for example if there are 10 ways to make $1.00, with an additional nickel,
                //there are still 10 ways to make $1.05: just add the nickel to $1.00
                //it is the same idea as recursive implementation
                dp[i] = dp[i] + dp[i - x];
            }
        }
        return dp[target];
    }

    public int combinationSum4(int[] nums, int target) {
        if (target == 0) {
            return 1;
        }
        int res = 0;
        for (int x : nums) {
            if (target >= x) {
                res += combinationSum4(nums, target - x);
            }
        }
        return res;
    }

    public static int combinations(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (target == 0) {
            return 1;
        }
        int answer = 0;
        for (int i = 0; i < nums.length; i++) {
            if (target >= nums[i]) {
                answer += combinations(nums, target - nums[i]);
            }
        }
        return answer;
    }

    public static int combinationsMemo(int[] nums, int target) {
        int[] memo = new int[target + 1];
        Arrays.fill(memo, -1);
        memo[0] = 1;

        return combination(nums, target, memo);
    }

    private static int combination(int[] nums, int target, int[] memo) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (target == 0) {
            return 1;
        }

        if (memo[target] != -1) {
            return memo[target];
        }
        int answer = 0;
        for (int i = 0; i < nums.length; i++) {
            if (target >= nums[i]) {
                answer += combination(nums, target - nums[i], memo);
            }
        }
        memo[target] = answer;
        return answer;
    }

    /**
     * this returns unique ways
     *
     * @param nums
     * @param target
     * @return
     */
    public static int uniqueWays(int[] nums, int target) {
        return uniqueWays(nums, target, 0);
    }

    private static int uniqueWays(int[] nums, int target, int start) {
        if (target == 0) {
            return 1;
        }

        int total = 0;
        for (int i = start; i < nums.length; i++) {
            if (target >= nums[i]) {
                total += uniqueWays(nums, target - nums[i], i);
            }
        }
        return total;
    }

    public static int uniqueWaysMemo(int[] nums, int target) {
        int[][] memo = new int[target + 1][nums.length];
        for (int[] temp : memo) {
            Arrays.fill(temp, -1);
        }
        memo[0][0] = 1;
//		for (int i = 0; i < nums.length; i++) {
//			memo[0][i] = 1;
//		}
//		for (int i = 0; i <= target; i++) {
//			memo[i][0] = 1;
//		}
        return uniqueWaysMemo(nums, target, 0, memo);
    }

    private static int uniqueWaysMemo(int[] nums, int target, int start, int[][] memo) {
        if (target == 0) {
            return 1;
        }
        if (memo[target][start] != -1) {
            return memo[target][start];
        }
        int total = 0;
        for (int i = start; i < nums.length; i++) {
            if (target >= nums[i]) {
                total += uniqueWaysMemo(nums, target - nums[i], i, memo);
            }
        }
        memo[target][start] = total;
        return total;
    }

    public static boolean oneAway(String a, String b) {

        return editDistance(a, a.length() - 1, b, b.length() - 1) == 1;
    }

    private static int editDistance(String a, int m, String b, int n) {

        if (m < 0)
            return n + 1;
        if (n < 0)
            return m + 1;

        if (a.charAt(m) == b.charAt(n)) {
            return editDistance(a, m - 1, b, n - 1);
        } else {
            int delete = editDistance(a, m - 1, b, n);
            int replace = editDistance(a, m - 1, b, n - 1);
            int insert = editDistance(a, m, b, n - 1);
            return 1 + min(delete, replace, insert);
        }

    }

    public static boolean editDistanceDP(String a, String b) {
        int[][] dp = new int[a.length() + 1][b.length() + 1];
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j < dp[0].length; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + min(dp[i - 1][j - 1], dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[a.length()][b.length()] == 1;
    }

    private static int min(int a, int b, int c) {
        if (a >= b) {
            return Math.min(b, c);
        } else {
            return Math.min(a, c);
        }
    }
}
