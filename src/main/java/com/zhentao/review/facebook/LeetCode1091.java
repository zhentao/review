package com.zhentao.review.facebook;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <b>1091. Shortest Path in Binary Matrix</b><br/>
 * In an N by N square grid, each cell is either empty (0) or blocked (1).
 *
 * A clear path from top-left to bottom-right has length k if and only if it is
 * composed of cells C_1, C_2, ..., C_k such that:
 *
 * <pre>
    Adjacent cells C_i and C_{i+1} are connected 8-directionally (ie., they are different and share an edge or corner)
    C_1 is at location (0, 0) (ie. has value grid[0][0])
    C_k is at location (N-1, N-1) (ie. has value grid[N-1][N-1])
    If C_i is located at (r, c), then grid[r][c] is empty (ie. grid[r][c] == 0).
 * </pre>
 *
 * Return the length of the shortest such clear path from top-left to
 * bottom-right. If such a path does not exist, return -1.
 *
 *
 * <pre>
Example 1:

Input: [[0,1],[1,0]]


Output: 2

Example 2:

Input: [[0,0,0],[1,1,0],[1,1,0]]


Output: 4



Note:

    1 <= grid.length == grid[0].length <= 100
    grid[r][c] is 0 or 1
 * </pre>
 *
 * @author zhentao.li
 *
 */
public class LeetCode1091 {
    public static void main(String[] args) {
        int[][] grid = {{0,1},{1,0}};
        LeetCode1091 lc = new LeetCode1091();
        System.out.println(lc.shortestPathBinaryMatrix(grid));
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Queue<Point> queue = new LinkedList<>();
        int min = 0;
        if (grid[0][0] != 1) {
            queue.add(new Point(0, 0));
            visited[0][0] = true;
            while (!queue.isEmpty()) {
                min++;
                int size = queue.size();
                for (int k = 0; k < size; k++) {
                    Point p = queue.remove();
                    if (p.i == grid.length-1 && p.j == grid[0].length-1) {
                        return min;
                    } else {
                        addAdjacentToQueue(p, visited, queue, grid);
                    }
                }
            }
        }
        return -1;
    }

        private void addAdjacentToQueue(Point p, boolean[][] visited, Queue<Point> queue, int[][] grid) {
            for (int i = p.i - 1; i <= p.i+1; i++) {
                for (int j= p.j-1; j <= p.j+1; j++) {
                    if (i >= 0 && i < visited.length && j>= 0 && j <visited[0].length && !visited[i][j] && grid[i][j] == 0) {
                        queue.add(new Point(i, j));
                        visited[i][j] = true;
                    }
                }
            }
        }


    private class Point {
        int i;
        int j;
        Point(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}
