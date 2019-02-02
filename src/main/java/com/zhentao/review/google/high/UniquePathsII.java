package com.zhentao.review.google.high;

/**
 * <b>63. Unique Paths II</b>
 * 
 * <pre>
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach 
the bottom-right corner of the grid (marked 'Finish' in the diagram below).

Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and empty space is marked as 1 and 0 respectively in the grid.

Note: m and n will be at most 100.

Example 1:

Input:
[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
Output: 2
Explanation:
There is one obstacle in the middle of the 3x3 grid above.
There are two ways to reach the bottom-right corner:
1. Right -> Right -> Down -> Down
2. Down -> Down -> Right -> Right
 * </pre>
 * 
 * @author zhentao
 *
 */
public class UniquePathsII {
    public int uniquePathsWithObstacles(final int[][] obstacleGrid) {
        final int rows = obstacleGrid.length;
        final int columns = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        final int[][] memo = new int[rows][columns];
        memo[0][0] = 1;
        for (int i = 1; i < rows; i++) {
            if (obstacleGrid[i][0] == 0) {
                memo[i][0] = 1;
            } else {
                break;
            }
        }
        for (int i = 1; i < columns; i++) {
            if (obstacleGrid[0][i] == 0) {
                memo[0][i] = 1;
            } else {
                break;
            }
        }
        
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < columns; j++) {
                if (obstacleGrid[i][j] == 1) {
                    memo[i][j] = 0;
                } else {
                    memo[i][j] = memo[i-1][j] + memo[i][j-1];
                }
                
            }
        }
        return memo[rows-1][columns-1];
    }
}
