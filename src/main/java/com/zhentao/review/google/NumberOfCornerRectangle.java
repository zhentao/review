package com.zhentao.review.google;

/**
 * <b>750. Number Of Corner Rectangles</b>
 * 
 * <pre>
 * Given a grid where each entry is only 0 or 1, find the number of corner rectangles.

A corner rectangle is 4 distinct 1s on the grid that form an axis-aligned rectangle. 
Note that only the corners need to have the value 1. Also, all four 1s used must be distinct.

 

Example 1:

Input: grid = 
[[1, 0, 0, 1, 0],
 [0, 0, 1, 0, 1],
 [0, 0, 0, 1, 0],
 [1, 0, 1, 0, 1]]
Output: 1
Explanation: There is only one corner rectangle, with corners grid[1][2], grid[1][4], grid[3][2], grid[3][4].
 

Example 2:

Input: grid = 
[[1, 1, 1],
 [1, 1, 1],
 [1, 1, 1]]
Output: 9
Explanation: There are four 2x2 rectangles, four 2x3 and 3x2 rectangles, and one 3x3 rectangle.
 

Example 3:

Input: grid = 
[[1, 1, 1, 1]]
Output: 0
Explanation: Rectangles must have four distinct corners.
 

Note:

The number of rows and columns of grid will each be in the range [1, 200].
Each grid[i][j] will be either 0 or 1.
The number of 1s in the grid will be at most 6000.
 * </pre>
 * 
 * @author zhentao
 *
 */
public class NumberOfCornerRectangle {
    public static int bruteForce(int[][] grid) {
        if (grid == null) {
            return 0;
        }
        int rows = grid.length;
        if (rows <= 1) {
            return 0;
        }
        int cols = grid[0].length;
        if (cols <= 1) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < rows - 1; i++) {
            for (int j = 0; j < cols - 1; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }
                for (int m = j + 1; m < cols; m++) {
                    if (grid[i][m] == 0) {
                        continue;
                    }
                    for (int n = i + 1; n < rows; n++) {
                        if (grid[n][j] == 1 && grid[n][m] == 1) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }

    /**
     * The idea is to find # of rectangles for any 2 rows. If and only if at the
     * same column, the grids for both rows are 1, it forms a rectangle. Then use
     * combination(count, 2) to calculate # of rectangles for those 2 rows.
     * 
     * @param grid
     * @return
     */
    public static int countCornerRectangles(int[][] grid) {
        if (grid == null) {
            return 0;
        }
        int rows = grid.length;
        if (rows <= 1) {
            return 0;
        }
        int cols = grid[0].length;
        if (cols <= 1) {
            return 0;
        }
        int total = 0;
        for (int i = 0; i < rows - 1; i++) {
            for (int j = i + 1; j < rows; j++) {
                int count = 0;
                for (int k = 0; k < cols; k++) {
                    if (grid[i][k] == grid[j][k] && grid[i][k] == 1) {
                        count++;
                    }
                }
                total += count * (count - 1) / 2;
            }
        }
        return total;
    }
}
