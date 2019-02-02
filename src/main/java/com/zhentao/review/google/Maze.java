package com.zhentao.review.google;

/**
 * <b>490. The Maze</b>
 * 
 * <pre>
 * There is a ball in a maze with empty spaces and walls. The ball can go through empty spaces by rolling up, down, left or right, but it won't stop rolling until hitting a wall. When the ball stops, it could choose the next direction.

Given the ball's start position, the destination and the maze, determine whether the ball could stop at the destination.

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

Output: true
Explanation: One possible way is : left -> down -> left -> down -> right -> down -> right.

 

Example 2

Input 1: a maze represented by a 2D array

0 0 1 0 0
0 0 0 0 0
0 0 0 1 0
1 1 0 1 1
0 0 0 0 0

Input 2: start coordinate (rowStart, colStart) = (0, 4)
Input 3: destination coordinate (rowDest, colDest) = (3, 2)

Output: false
Explanation: There is no way for the ball to stop at the destination.

 

Note:

There is only one ball and one destination in the maze.
Both the ball and the destination exist on an empty space, and they will not be at the same position initially.
The given maze does not contain border (like the red rectangle in the example pictures), but you could assume the border of the maze are all walls.
The maze contains at least 2 empty spaces, and both the width and height of the maze won't exceed 100.
 * </pre>
 * 
 * @author zhentao
 *
 */
public class Maze {
    public boolean hasPath(final int[][] maze, final int[] start, final int[] destination) {
        final int[][] visited = new int[maze.length][maze[0].length];
        return dfs(maze, start[0], start[1], destination[0], destination[1], visited);
    }

    private boolean dfs(final int[][] maze, final int si, final int sj, final int di, final int dj, final int[][] visited) {
        if (si == di && sj == dj) {
            return true;
        }

        if (visited[si][sj] != 1) {
            visited[si][sj] = 1;

            int top = si;
            while (top >= 0 && maze[top][sj] != 1) {
                top--;
            }
            if (top + 1 != si) {
                if (dfs(maze, top + 1, sj, di, dj, visited)) {
                    return true;
                }
            }

            int bottom = si;
            while (bottom < maze.length && maze[bottom][sj] != 1) {
                bottom++;
            }
            if (bottom - 1 != si) {
                if (dfs(maze, bottom - 1, sj, di, dj, visited)) {
                    return true;
                }
            }
            
            int left = sj;
            while (left >= 0 && maze[si][left] != 1) {
                left--;
            }
            if (left+1 != sj) {
                if (dfs(maze, si, left+1, di,dj, visited)) {
                    return true;
                }
            }
            
            int right = sj;
            while (right < maze[0].length && maze[si][right] != 1) {
                right++;
            }
            if (right-1 != sj) {
                if (dfs(maze, si, right-1, di, dj, visited)) {
                    return true;
                }
            }
        }
        return false;
    }
}
