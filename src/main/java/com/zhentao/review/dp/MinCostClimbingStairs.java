package com.zhentao.review.dp;

/**
 * On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed).
 *
 * Once you pay the cost, you can either climb one or two steps. You need to find minimum cost to
 * reach the top of the floor, and you can either start from the step with index 0, or the step with
 * index 1.
 *
 * <pre>
 * Example 1:
 *
 * Input: cost = [10, 15, 20] Output: 15
 * Explanation: Cheapest is start on cost[1], pay that cost and go to the top.
 *
 * Example 2:
 *
 * Input: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1] Output: 6
 * Explanation: Cheapest is start on cost[0], and only step on 1s, skipping cost[3].
 * </pre>
 *
 * @author zhentao.li
 *
 */
public class MinCostClimbingStairs {

    public static void main(String[] args) {
        int[] cost = new int[] {10, 15, 20};
        System.out.println(minCostClimbingStairs(cost));
        System.out.println(findMinCost(cost));

        cost = new int[] {1, 3, 4, 5, 1, 2, 5, 10};
        System.out.println(minCostClimbingStairs(cost));
        System.out.println(findMinCost(cost));

        cost = new int[] {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println(minCostClimbingStairs(cost));
        System.out.println(findMinCost(cost));
    }


    public static int minCostClimbingStairs(int[] cost) {
        int f1 = 0, f2 = 0;
        for (int i = cost.length - 1; i >= 0; --i) {
            int f0 = cost[i] + Math.min(f1, f2);
            f2 = f1;
            f1 = f0;
        }
        return Math.min(f1, f2);
    }

    public static int findMinCost(int[] cost) {
        int length = cost.length;
        if (cost == null || length == 0) {
            return 0;
        }
        int[] memo = new int[length];
        return Math.min(findMinCost(cost, 0, memo, length), findMinCost(cost, 1, memo, length)) ;
    }

    private static int findMinCost(int[] cost, int i, int[] memo, int length) {
        if (i >=  length) {
            return 0;
        }
        if (memo[i] != 0) {
            return memo[i];
        }
        memo[i] = Math.min(findMinCost(cost, i+1, memo, length), findMinCost(cost, i+2, memo, length)) + cost[i];
        return memo[i];
    }
}
