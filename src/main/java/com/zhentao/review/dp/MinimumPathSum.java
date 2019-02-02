package com.zhentao.review.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * <b>64. Minimum Path Sum</b>
 * 
 * <pre>
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

Example:

Input:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
Output: 7
Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 * </pre>
 * 
 * @author zhentao
 *
 */
public class MinimumPathSum {
    public static void main(final String[] args) {
        final int[][] cost = {
                {1,3,1},
                {1,5,1},
                {4,2,1}
              };
        System.out.println(new MinimumPathSum().minPathSumWithParent(cost));
    }
    public int minPathSum(final int[][] cost) {
        final int m = cost.length;
        final int n = cost[0].length;

        final int[][] memo = new int[m][n];
        memo[0][0] = cost[0][0];
        
        for (int j = 1; j < n; j++) {
            memo[0][j] = cost[0][j] + memo[0][j - 1];
        }
        for (int i = 1; i < m; i++) {
            memo[i][0] = cost[i][0] + memo[i - 1][0];
            for (int j = 1; j < n; j++) {
                memo[i][j] = cost[i][j] + Math.min(memo[i - 1][j], memo[i][j - 1]);
            }
        }
        return memo[m - 1][n - 1];
    }
    
    public List<int[]> minPathSumWithParent(final int[][] cost) {
        final int m = cost.length;
        final int n = cost[0].length;

        final ArrayList<int[]> paths = new ArrayList<>();
        paths.add(new int[] {0,0});
        final int[][] memo = new int[m][n];
        memo[0][0] = cost[0][0];
        final boolean[][] path = new boolean[m][n];
        
        for (int j = 1; j < n; j++) {
            memo[0][j] = cost[0][j] + memo[0][j - 1];
        }
        for (int i = 1; i < m; i++) {
            memo[i][0] = cost[i][0] + memo[i - 1][0];
            for (int j = 1; j < n; j++) {
                if (memo[i-1][j] < memo[i][j-1]) {
                    paths.add(new int[] {i-1, j});
                } else {
                    paths.add(new int[] {i, j-1});
                }
                memo[i][j] = cost[i][j] + Math.min(memo[i - 1][j], memo[i][j - 1]);
            }
        }
        return paths;
    }
}
