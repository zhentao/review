package com.zhentao.review.facebook;

import java.util.Arrays;

/**
 * <b>311. Sparse Matrix Multiplication</b>
 *
 * Given two sparse matrices A and B, return the result of AB.
 *
 * You may assume that A's column number is equal to B's row number.
 *
 * <pre>
Example:

A = [
  [ 1, 0, 0],
  [-1, 0, 3]
]

B = [
  [ 7, 0, 0 ],
  [ 0, 0, 0 ],
  [ 0, 0, 1 ]
]

     |  1 0 0 |   | 7 0 0 |   |  7 0 0 |
AB = | -1 0 3 | x | 0 0 0 | = | -7 0 3 |
                  | 0 0 1 |
 * </pre>
 *
 * @author zhentao.li
 *
 */
public class LeetCode0311 {
    public static void main(String[] args) {
        int[][] a = {{1, 0, 0}, {-1, 0, 3}};
        int[][] b = {{7, 0, 0}, {0, 0, 0}, { 0, 0, 1}};
        LeetCode0311 lc = new LeetCode0311();
        System.out.println(Arrays.deepToString(lc.multiply(a, b)));
    }
    public int[][] multiply(int[][] a, int[][] b) {
        int[][] result = new int[a.length][b[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                if (a[i][j] != 0) {
                    for (int k = 0; k < b[0].length; k++) {
                        if (b[j][k] != 0) {
                            result[i][k] += a[i][j] * b[j][k];
                        }
                    }
                }
            }
        }
        return result;
    }
}
