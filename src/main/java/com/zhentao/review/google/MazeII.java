package com.zhentao.review.google;

import java.util.Arrays;

/**
 * <b>505. The Maze II</b>
 * 
 * <pre>
 * There is a ball in a maze with empty spaces and walls. The ball can go through empty spaces by rolling up, down, left or right, but it won't stop rolling until hitting a wall. When the ball stops, it could choose the next direction.

Given the ball's start position, the destination and the maze, find the shortest distance for the ball to stop at the destination. The distance is defined by the number of empty spaces traveled by the ball from the start position (excluded) to the destination (included). If the ball cannot stop at the destination, return -1.

The maze is represented by a binary 2D array. 1 means the wall and 0 means the empty space. You may assume that the borders of the maze are all walls. The start and destination coordinates are represented by row and column indexes.

Example 1

Input 1: a maze represented by a 2D array

0 0 1 0 0
0 0 0 0 0
0 0 0 1 0
1 1 0 1 1
0 0 0 0 0

Input 2: start coordinate (rowStart, colStart) = (0, 4)
Input 3: destination coordinate (rowDest, colDest) = (4, 4)

Output: 12
Explanation: One shortest way is : left -> down -> left -> down -> right -> down -> right.
             The total distance is 1 + 1 + 3 + 1 + 2 + 2 + 2 = 12.


 

Example 2

Input 1: a maze represented by a 2D array

0 0 1 0 0
0 0 0 0 0
0 0 0 1 0
1 1 0 1 1
0 0 0 0 0

Input 2: start coordinate (rowStart, colStart) = (0, 4)
Input 3: destination coordinate (rowDest, colDest) = (3, 2)

Output: -1
Explanation: There is no way for the ball to stop at the destination.
 * </pre>
 * 
 * @author zhentao
 *
 */
public class MazeII {
    public int shortestDistance(final int[][] maze, final int[] start, final int[] destination) {
        final int[][] distances = new int[maze.length][maze[0].length];
        final int[][] visited = new int[maze.length][maze[0].length];
        for (final int[] row : distances) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        dfs(maze, start[0], start[1], destination[0], destination[1], distances, visited);
        return distances[start[0]][start[1]] == Integer.MAX_VALUE ? -1 : distances[start[0]][start[1]];
    }

    private int dfs(final int[][] maze, final int si, final int sj, final int di, final int dj, final int[][] distances,
            final int[][] visited) {
        if (si == di && sj == dj) {
            distances[si][sj] = 0;
            return 0;
        }
        if (distances[si][sj] != Integer.MAX_VALUE) {
            return distances[si][sj];
        }
        if (visited[si][sj] == 0) {
            visited[si][sj] = 1;
            int top = si;
            while (top >= 0 && maze[top][sj] != 1) {
                top--;
            }
            if (top + 1 != si) {
                int distance = dfs(maze, top + 1, sj, di, dj, distances, visited);
                if (distance != Integer.MAX_VALUE) {
                    distance += si - (top + 1);
                }
                distances[si][sj] = Math.min(distances[si][sj], distance);
            }

            int bottom = si;
            while (bottom < maze.length && maze[bottom][sj] != 1) {
                bottom++;
            }
            if (bottom - 1 != si) {
                 int distance = dfs(maze, bottom - 1, sj, di, dj, distances, visited);
                 if (distance != Integer.MAX_VALUE) {
                     distance += (bottom - 1) - si;
                 }
                distances[si][sj] = Math.min(distances[si][sj], distance);
            }

            int left = sj;
            while (left >= 0 && maze[si][left] != 1) {
                left--;
            }
            if (left + 1 != sj) {
                int distance = dfs(maze, si, left + 1, di, dj, distances, visited);
                if (distance != Integer.MAX_VALUE) {
                    distance += sj - (left + 1);
                }
                distances[si][sj] = Math.min(distances[si][sj], distance);
            }

            int right = sj;
            while (right < maze[0].length && maze[si][right] != 1) {
                right++;
            }
            if (right - 1 != sj) {
                int distance = dfs(maze, si, right - 1, di, dj, distances, visited);
                if (distance != Integer.MAX_VALUE) {
                    distance += (right - 1) - sj;
                }
                distances[si][sj] = Math.min(distances[si][sj], distance);
            }
        }
        return distances[si][sj];
    }

}
