package com.zhentao.review.dp;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 * Note: Given n will be a positive integer.
 *
 * <pre>
 * Example 1:
 *
 * Input: 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 *
 * Example 2:
 *
 * Input: 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 * </pre>
 *
 * @author zhentao.li
 *
 */
public class WaysToClimbStairs {
    public static void main(String[] args) {
        System.out.println(waysRecursive(4));
        System.out.println(ways(4));
    }

    /**
     * Brute force solution which is same as Fibonacci number: f(n) = f(n-1) + f(n-2)
     * @param n
     * @return
     */
    public static int waysRecursive(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return waysRecursive(n - 1) + waysRecursive(n - 2);
    }

    public static int ways(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int f1 = 1;
        int f2 = 2;

        for (int i = 3; i <= n; i++) {
            int f = f1 + f2;
            f1 = f2;
            f2 = f;
        }
        return f2;
    }
}
