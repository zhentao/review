package com.zhentao.review.facebook;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <b>54. Spiral Matrix</b> Given a matrix of m x n elements (m rows, n
 * columns), return all elements of the matrix in spiral order.
 *
 * <pre>
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
 * @author zhentao.li
 *
 */
public class LeetCode0054 {
    public static void main(String[] args) {
        int[][] matrix = {{ 1 },
                { 5 },
                { 9 }};
        LeetCode0054 lc = new LeetCode0054();
        System.out.println(lc.spiralOrder(matrix));
    }
    public List<Integer> spiralOrder(int[][] matrix) {
        int row = matrix.length;
        if (row == 0) {
            return Collections.emptyList();
        }
        int column = matrix[0].length;
        List<Integer> list = new ArrayList<>(row * column);

        int startRow = 0;
        int startColumn = 0;
        int topRow = 0;
        int bottomRow = row;
        int rightColumn = column;
        int leftColumn = -1;
        int total = row * column;
        int steps = 0;

        while (steps < total) {
            while (startColumn < rightColumn && steps < total) {
                list.add(matrix[startRow][startColumn]);
                startColumn++;
                steps++;
            }
            rightColumn--;
            startColumn--;//back to the last column
            startRow++;

            while(startRow < bottomRow && steps < total) {
                list.add(matrix[startRow][startColumn]);
                startRow++;
                steps++;
            }
            bottomRow--;
            startRow--;
            startColumn--;

            while (startColumn > leftColumn && steps < total) {
                list.add(matrix[startRow][startColumn]);
                startColumn--;
                steps++;
            }
            leftColumn++;
            startColumn++;
            startRow--;

            while(startRow > topRow && steps < total) {
                list.add(matrix[startRow][startColumn]);
                startRow--;
                steps++;
            }
            topRow++;
            startRow++;
            startColumn++;
        }

        return list;
    }
}
