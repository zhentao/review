package com.zhentao.review.dp;

/**
 * <b> 198. House Robber </b>
 *
 * You are a professional robber planning to rob houses along a street. Each house has a certain
 * amount of money stashed, the only constraint stopping you from robbing each of them is that
 * adjacent houses have security system connected and it will automatically contact the police if
 * two adjacent houses were broken into on the same night.
 *
 * Given a list of non-negative integers representing the amount of money of each house, determine
 * the maximum amount of money you can rob tonight without alerting the police.
 *
 * <pre>
 * Example 1:
 *
 * Input: [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 * Total amount you can rob = 1 + 3 = 4.
 *
 * Example 2:
 *
 * Input: [2,7,9,3,1]
 * Output: 12
 * Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and
 * rob house 5 (money = 1).
 * Total amount you can rob = 2 + 9 + 1 = 12.
 * </pre>
 *
 * @author zhentao.li
 *
 */
public class HouseRobber {

    public static void main(String[] args) {
        int[] input = new int[]{2,7,9,3,1};
        System.out.println(recurviveSolution(input));
        System.out.println(dp(input));

        input = new int[]{1,2,3,1};
        System.out.println(recurviveSolution(input));
        System.out.println(dp(input));

        input = new int[] {7, 1, 1, 9};
        System.out.println(recurviveSolution(input));
        System.out.println(dp(input));
    }
    public static int recurviveSolution(int[] input) {

        return rescursiveSolution(input, input.length -1);
    }

    private static int rescursiveSolution(int[] input, int i) {
        if (i == 0) {
            return input[0];
        }
        if (i == 1) {
            return Math.max(input[0], input[1]);
        }

        return Math.max(rescursiveSolution(input, i-2) + input[i], rescursiveSolution(input, i-1));
    }

    public static int dp(int[] input) {

        if (input == null) {
            return 0;
        }
        int length = input.length;

        if (length == 0) {
            return 0;
        }

        int f0 = input[0];
        if (length == 1) {
            return f0;
        }

        int f1 = Math.max(input[1], input[0]);

        for (int i = 2; i < length; i++) {
            int f = Math.max(f0 + input[i], f1);
            f0 = f1;
            f1 = f;
        }
        return Math.max(f0, f1);
    }
}
