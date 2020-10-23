package com.zhentao.review.facebook;

import java.util.Arrays;

/**
 * <b>74. Search a 2D Matrix</b>
 *
 * Write an efficient algorithm that searches for a value in an m x n matrix.
 * This matrix has the following properties:
 *
 * <pre>
    Integers in each row are sorted from left to right.
    The first integer of each row is greater than the last integer of the previous row.

Example 1:

Input:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 3
Output: true

Example 2:

Input:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 13
Output: false
 * </pre>
 *
 * @author zhentao.li
 *
 */
public class LeetCode0074 {
    public static void main(String[] args) {
        int[][] matrix = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 50 } };
        LeetCode0074 lc = new LeetCode0074();
        System.out.println(lc.searchMatrix(matrix, 3));

        matrix = new int[][] { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 50 } };
        System.out.println(lc.searchMatrix(matrix, 13));

        matrix = new int[][] { { 1 }, { 3 } };
        System.out.println(lc.searchMatrix(matrix, 3));

        matrix = new int[][] { { 1 }, { 3 }, { 5 } };
        System.out.println(lc.searchMatrix(matrix, 5));

        matrix = new int[][] {{1,3,5,7},{10,11,16,20},{23,30,34,50}};
        System.out.println(lc.searchMatrix(matrix, 11));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
        if (matrix[0].length == 0) {
            return false;
        }

        int row = matrix.length - 1;
        int column = matrix[0].length - 1;
        if (target < matrix[0][0] || target > matrix[row][column]) {
            return false;
        }

        int topRow = 0;
        int bottomRow = row;
        int mid = topRow;
        while (topRow <= bottomRow) {
            mid = topRow + (bottomRow - topRow) / 2;
            //target is less than the least num in this row
            if (target < matrix[mid][0] ) {
                bottomRow = mid - 1;
            } else if (target > matrix[mid][column]) {
              //target is greater than the largest number in this row
                topRow = mid+1;

            } else {
                return Arrays.binarySearch(matrix[mid], target) >= 0;
            }
        }

        return false;
    }
}
