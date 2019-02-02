package com.zhentao.review.leetcode;

/**
 * <b>59. Spiral Matrix II</b>
 * 
 * <pre>
 * Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

Example:

Input: 3
Output:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
 * </pre>
 * 
 * @author zhentao
 *
 */
public class SpiralMatrixII {
    public int[][] generateMatrix(final int n) {
        final int[][] matrix = new int[n][n];
        int i = 0;
        int j = 0;
        final int total = n * n;
        int count = 1;
        while (count <= total) {
            for (; j < n && matrix[i][j] == 0; j++) {
                matrix[i][j] = count;
                count++;
            }
            j--;
            i++;
            for (; i < n && matrix[i][j] == 0; i++) {
                matrix[i][j] = count;
                count++;
            }

            j--;
            i--;
            for (; j >= 0 && matrix[i][j] == 0; j--) {
                matrix[i][j] = count;
                count++;
            }
            j++;
            i--;
            for (; i >= 0 && matrix[i][j] == 0; i--) {
                matrix[i][j] = count;
                count++;
            }
            j++;
            i++;
        }
        
        return matrix;
    }
}
