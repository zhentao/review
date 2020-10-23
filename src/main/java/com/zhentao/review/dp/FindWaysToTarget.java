package com.zhentao.review.dp;

/**
 * Given a value N, if we want to make change for N cents, and we have infinite supply of each of S
 * = { S1, S2, .. , Sm} valued coins, how many ways can we make the change? The order of coins
 * doesn’t matter.
 *
 * For example, for N = 4 and S = {1,2,3}, there are four solutions: {1,1,1,1},{1,1,2},{2,2},{1,3}.
 * So output should be 4. For N = 10 and S = {2, 5, 3, 6}, there are five solutions: {2,2,2,2,2},
 * {2,2,3,3}, {2,2,6}, {2,3,5} and {5,5}. So the output should be 5.
 *
 * @author zhentao.li
 *
 */
public class FindWaysToTarget {

    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        int sum = 5;
        // System.out.println(ways(a, sum));
        // System.out.println(coinChange(a, sum));
        //
        // System.out.println(coinChange(new int[]{2, 5, 3, 6}, 10));
        // System.out.println(coinChangeMemo(new int[]{2, 5, 3, 6}, 10));
        System.out.println(ways(new int[] {3, 5, 7, 8, 9, 10, 11}, 1000));
        // System.out.println(coinChange(new int[]{3,5,7,8,9,10,11},1000));
        System.out.println(coinChangeMemo(new int[] {3, 5, 7, 8, 9, 10, 11}, 1000));



        System.out.println(possibleWays(2));
        // System.out.println(climbStairs(i));
        System.out.println(climbStairsFib(2));
    }

    /**
     *
     * @param a an array with all positive #
     * @param sum a positive #
     * @return
     */
    public static int ways(int a[], int sum) {
        // int size = a.length;
        int[] dp = new int[sum + 1];
        // base case
        //when target sum is 0, only 1 way to get it: no coins
        dp[0] = 1;

        for (int coin : a) {
            for (int x = coin; x <= sum; x++) {
                //dp[x] is the ways to make the current sum without current coin
                //dp[x-coin] is the ways to make the current sum with current coin
                //for example if there are 10 ways to make $1.00, with an additional nickel,
                //there are still 10 ways to make $1.05: just add the nickel to $1.00
                //it is the same idea as recursive implementation
                dp[x] = dp[x] + dp[x - coin];
            }
        }

        return dp[sum];

        // Pick all coins one by one and update the table[]
        // values after the index greater than or equal to
        // the value of the picked coin
        // for (int i=0; i<m; i++)
        // for (int j=S[i]; j<=n; j++)
        // table[j] += table[j-S[i]];
        // return table[n]
    }

    // https://www.geeksforgeeks.org/coin-change-dp-7/
    /**
     * A child is climbing up a staircase with n steps, and can hop either 1 step, 2 steps, or 3
     * steps at a time. Implement a method to count how many possible ways the child can jump up the
     * stairs.
     *
     * Approach:
     *
     * Say child has to take n steps. At every step the child has 3 options, to take 1 step, 2 step
     * or 3 steps. So if child take 1 step then find the number of ways to complete n-1 steps .
     * Similarly if child take 2 steps then find the number of ways to complete n-2 steps . If child
     * take 3 step then find the number of ways to complete n-3 steps. So total number of ways to
     * complete n steps = No of ways to complete (n-1)steps + No of ways to complete (n-2)steps + No
     * of ways to complete (n-3)steps .
     *
     *
     * @param n
     * @param dyn
     * @return
     */
    private static int possibleWaysDyna(int n, int[] dyn) {
        if (n < 1) {
            return 0;
        }
        if (dyn[n] > 0) {
            return dyn[n];
        }
        dyn[n] = possibleWaysDyna(n - 1, dyn) + possibleWaysDyna(n - 2, dyn) + possibleWaysDyna(n - 3, dyn);
        System.out.println("n = " + n + ":" + dyn[n]);
        return dyn[n];
    }

    public static int possibleWays(int n) {
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;
        if (n == 3)
            return 4;
        int[] memo = new int[n + 1];

        memo[1] = 1;
        memo[2] = 2;
        memo[3] = 4;
        return possibleWaysDyna(n, memo);
    }

    public static int climbStairs(int n) {
        int memo[] = new int[n + 1];
        return climb_Stairs(0, n, memo);
    }

    /**
     * Top down by memoization
     *
     * @param i
     * @param n
     * @param memo
     * @return
     */
    public static int climb_Stairs(int i, int n, int[] memo) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        if (memo[i] > 0) {
            return memo[i];
        }
        memo[i] = climb_Stairs(i + 1, n, memo) + climb_Stairs(i + 2, n, memo) + climb_Stairs(i + 3, n, memo);
        return memo[i];
    }

    /**
     * bottom up by iteration tabulation
     *
     * @param n
     * @return
     */
    public static int climbStairsFib(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (n == 3) {
            return 4;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 4; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        return dp[n];
    }

    public static int coinChange(int[] coins, int target) {

        return coinChange(coins, target, coins.length - 1);

    }

    /**
     * recursive
     *
     * @param coins
     * @param target
     * @param lastIndex
     * @return
     */
    private static int coinChange(int[] coins, int target, int lastIndex) {
        if (target < 0) {
            return 0;
        }

        if (lastIndex == 0) {
            if ((target / coins[0]) * coins[0] == target) {
                return 1;
            } else {
                return 0;
            }
        }
        int last = coins[lastIndex];

        return coinChange(coins, target - last, lastIndex) + coinChange(coins, target, lastIndex - 1);
    }

    private static int coinChange(int[] coins, int target, int lastIndex, int[][] memo) {
        if (target < 0) {
            return 0;
        }
        // if (target == 0) return 1;
        if (lastIndex == 0) {
            if ((target / coins[0]) * coins[0] == target) {
                return 1;
            } else {
                return 0;
            }
        }
        if (memo[lastIndex][target] > 0)
            return memo[lastIndex][target];
        int last = coins[lastIndex];

        memo[lastIndex][target] = coinChange(coins, target - last, lastIndex, memo)
                        + coinChange(coins, target, lastIndex - 1, memo);
        return memo[lastIndex][target];
    }

    public static long coinChangeMemo(int[] coins, int target) {
        if (target == 0)
            return 1;
        if (coins == null || coins.length == 0) {
            return 0;
        }
        int[][] memo = new int[coins.length][target + 1];
        memo[0][0] = 1;
        return coinChange(coins, target, coins.length - 1, memo);
    }
}
