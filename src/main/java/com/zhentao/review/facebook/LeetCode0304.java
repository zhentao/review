package com.zhentao.review.facebook;

/**
 * <b>304. Range Sum Query 2D - Immutable</b> Given a 2D matrix matrix, find the
 * sum of the elements inside the rectangle defined by its upper left corner
 * (row1, col1) and lower right corner (row2, col2).
 *
 * Range Sum Query 2D The above rectangle (with the red border) is defined by
 * (row1, col1) = (2, 1) and (row2, col2) = (4, 3), which contains sum = 8.
 *
 * <pre>
Example:

Given matrix = [
  [3, 0, 1, 4, 2],
  [5, 6, 3, 2, 1],
  [1, 2, 0, 1, 5],
  [4, 1, 0, 1, 7],
  [1, 0, 3, 0, 5]
]

sumRegion(2, 1, 4, 3) -> 8
sumRegion(1, 1, 2, 2) -> 11
sumRegion(1, 2, 2, 4) -> 12

Note:

    You may assume that the matrix does not change.
    There are many calls to sumRegion function.
    You may assume that row1 ≤ row2 and col1 ≤ col2.
 * </pre>
 *
 * @author zhentao.li
 *
 */
public class LeetCode0304 {
    int[][] dp;

    public static void main(String[] args) {
        int[][] matrix = { { 3, 0, 1, 4, 2 }, { 5, 6, 3, 2, 1 }, { 1, 2, 0, 1, 5 }, { 4, 1, 0, 1, 7 },
                { 1, 0, 3, 0, 5 } };

        LeetCode0304 lc = new LeetCode0304(matrix);
        System.out.println(lc.sumRegion(2, 1, 4, 3));
        System.out.println(lc.sumRegion(1, 1, 2, 2));
        System.out.println(lc.sumRegion(1, 2, 2, 4));
    }

    public LeetCode0304(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return;
        }

        dp = new int[matrix.length + 1][matrix[0].length + 1];
        for (int i = 0; i < matrix.length; i++) {
            for (int m = 0; m < matrix[0].length; m++) {
                dp[i + 1][m + 1] = matrix[i][m] + dp[i][m + 1] + dp[i + 1][m] - dp[i][m];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return dp[row2+1][col2+1] - dp[row1][col2+1] - dp[row2+1][col1] + dp[row1][col1];
    }

}
