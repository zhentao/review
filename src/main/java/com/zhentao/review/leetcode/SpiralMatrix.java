package com.zhentao.review.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <b>54. Spiral Matrix</b>
 * 
 * <pre>
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

Example 1:

Input:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
Output: [1,2,3,6,9,8,7,4,5]
Example 2:

Input:
[
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9,10,11,12]
]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 * </pre>
 * 
 * @author zhentao
 *
 */
public class SpiralMatrix {
    public List<Integer> spiralOrder(final int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return Collections.emptyList();
        }
        final int rows = matrix.length;
        final int columns = matrix[0].length;
        final boolean[][] visited = new boolean[rows][columns];
        int i = 0;
        int j = 0;
        final int total = rows * columns;
        int count = 0;
        final ArrayList<Integer> list = new ArrayList<>();
        while (count < total) {
            for (; j < columns && !visited[i][j]; j++) {
                list.add(matrix[i][j]);
                visited[i][j] = true;
                count++;
            }
            j--;
            i++;
            for (; i < rows && !visited[i][j]; i++) {
                list.add(matrix[i][j]);
                visited[i][j] = true;
                count++;
            }

            j--;
            i--;
            for (; j >= 0 && !visited[i][j]; j--) {
                list.add(matrix[i][j]);
                visited[i][j] = true;
                count++;
            }
            j++;
            i--;
            for (; i >= 0 && !visited[i][j]; i--) {
                list.add(matrix[i][j]);
                visited[i][j] = true;
                count++;
            }
            j++;
            i++;
        }
        return list;
    }
}
