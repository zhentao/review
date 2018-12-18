package com.zhentao.review.dp;

/**
 * Given a cost matrix cost[][] and a position (m, n) in cost[][], write a function that returns
 * cost of minimum cost path to reach (m, n) from (0, 0). Each cell of the matrix represents a cost
 * to traverse through that cell. Total cost of a path to reach (m, n) is sum of all the costs on
 * that path (including both source and destination). You can only traverse down, right and
 * diagonally lower cells from a given cell, i.e., from a given cell (i, j), cells (i+1, j), (i,
 * j+1) and (i+1, j+1) can be traversed. You may assume that all costs are positive integers.
 *
 * For example, in the following figure, what is the minimum cost path to (2, 2)?
 *
 * @author zhentao.li
 *
 */
public class MinCostPath {
    public static void main(String[] args) {
        int[][] cost = {{1, 2, 3}, {4, 8, 2}, {1, 5, 3}};
        System.out.println(findBruteForce(cost));
        System.out.println(findMemo(cost));
        System.out.println(findBottomUp(cost));

        cost = new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};

        System.out.println(findBruteForce(cost));
        System.out.println(findMemo(cost));
        System.out.println(findBottomUp(cost));
    }

    public static int findBruteForce(int[][] cost) {

        return findBruteForce(cost, cost.length - 1, cost[0].length - 1);
    }

    private static int findBruteForce(int[][] cost, int m, int n) {
        if (n < 0 || m < 0) {
            return Integer.MAX_VALUE;
        }
        if (m == 0 && n == 0) {
            return cost[0][0];
        }
        return cost[m][n] + min(findBruteForce(cost, m - 1, n), findBruteForce(cost, m - 1, n - 1),
                        findBruteForce(cost, m, n - 1));
    }

    public static int findMemo(int[][] cost) {
        int m = cost.length - 1;
        int n = cost[0].length - 1;
        int[][] memo = new int[m + 1][n + 1];
        return findMemo(cost, m, n, memo);
    }

    private static int findMemo(int[][] cost, int m, int n, int[][] memo) {
        if (n < 0 || m < 0) {
            return Integer.MAX_VALUE;
        }
        if (m == 0 && n == 0) {
            memo[0][0] = cost[0][0];
            return cost[0][0];
        }
        if (memo[m][n] > 0) {
            return memo[m][n];
        }
        memo[m][n] = cost[m][n] + min(findMemo(cost, m - 1, n, memo), findMemo(cost, m - 1, n - 1, memo),
                        findMemo(cost, m, n - 1, memo));
        return memo[m][n];
    }

    public static int findBottomUp(int[][] cost) {
        int m = cost.length;
        int n = cost[0].length;

        int[][] memo = new int[m][n];
        memo[0][0] = cost[0][0];

        for (int j = 1; j < n; j++) {
            memo[0][j] = cost[0][j] + memo[0][j - 1];
        }
        for (int i = 1; i < m; i++) {
            memo[i][0] = cost[i][0] + memo[i - 1][0];
            for (int j = 1; j < n; j++) {
                memo[i][j] = cost[i][j] + min(memo[i - 1][j], memo[i - 1][j - 1], memo[i][j - 1]);
            }
        }
        return memo[m - 1][n - 1];
    }

    private static int min(int a, int b, int c) {
        if (a >= b) {
            return Math.min(b, c);
        } else {
            return Math.min(a, c);
        }
    }
}
