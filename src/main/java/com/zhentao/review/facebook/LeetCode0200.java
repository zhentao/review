package com.zhentao.review.facebook;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * <b>200. Number of Islands</b>
 *
 * <pre>
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally
 * or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

Input:
11110
11010
11000
00000

Output: 1
Example 2:

Input:
11000
11000
00100
00011

Output: 3
 * </pre>
 *
 * @author zhentao
 *
 */
public class LeetCode0200 {
    public static void main(String[] args) {
        char[][] grid = { { '1', '1', '1', '1', '0' }, { '1', '1', '0', '1', '0' }, { '1', '1', '0', '0', '0' },
                { '0', '0', '0', '0', '0' } };
        int count = new LeetCode0200().numIslands2(grid);
        System.out.print(count);
    }

    public int numIslands(char[][] grid) {
        if (grid == null) {
            return 0;
        }
        int row = grid.length;
        if (row == 0) {
            return 0;
        }
        int column = grid[0].length;
        boolean[][] visited = new boolean[row][column];
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    dfs(grid, visited, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, boolean[][] visited, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || visited[i][j] || grid[i][j] == '0') {
            return;
        }
        visited[i][j] = true;
        dfs(grid, visited, i - 1, j);// up
        dfs(grid, visited, i + 1, j);// down
        dfs(grid, visited, i, j - 1);// left
        dfs(grid, visited, i, j + 1);// right
    }

    public int  numIslands2(char[][] grid) {
        if (grid == null) {
            return 0;
        }
        int row = grid.length;
        if (row == 0) {
            return 0;
        }
        int column = grid[0].length;
        boolean[][] visited = new boolean[row][column];
        AtomicInteger result = new AtomicInteger(0);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    dfs2(grid, visited, i, j, result);
                }
            }
        }
        return result.get();
    }

    private void dfs2(char[][] grid, boolean[][] visited, int i, int j, AtomicInteger result) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || visited[i][j] || grid[i][j] == '0') {
            return;
        }
        visited[i][j] = true;
        result.getAndIncrement();
        dfs2(grid, visited, i - 1, j, result);// up
        dfs2(grid, visited, i + 1, j, result);// down
        dfs2(grid, visited, i, j - 1, result);// left
        dfs2(grid, visited, i, j + 1, result);// right
    }
}
