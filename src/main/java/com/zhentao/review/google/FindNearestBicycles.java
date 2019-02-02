package com.zhentao.review.google;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <b>use BFS (queue) to look for shortest path</b>
 * 
 * <pre>
 * ⼀个2D数组。'.'表⽰Road，'#'表⽰Building，'B'表⽰⾃⾏车。
 * 
. . . . . #
. . E . . #
# # # . # #
. B . . . .
. . . . . B

寻找最近的⾃⾏车。
 * </pre>
 * 
 * @author zhentao
 *
 */
public class FindNearestBicycles {
    public int[] find(final char[][] map, final int[] person) {
        final Queue<int[]> queue = new LinkedList<>();
        queue.add(person);
        final int rows = map.length;
        final int columns = map[0].length;
        final boolean[][] visited = new boolean[rows][columns];
        while (!queue.isEmpty()) {
            final int[] location = queue.poll();
            final int i = location[0];
            final int j = location[1];
            visited[i][j] = true;
            if (map[i][j] == 'B') {
                return location;
            }
            // up
            if (i - 1 >= 0 && map[i - 1][j] != '#' && !visited[i - 1][j]) {
                queue.add(new int[] { i - 1, j });
            }
            // down
            if (i + 1 < rows && map[i + 1][j] != '#' && !visited[i + 1][j]) {
                queue.add(new int[] { i + 1, j });
            }
            // left
            if (j - 1 >= 0 && map[i][j - 1] != '#' && !visited[i][j - 1]) {
                queue.add(new int[] { i, j - 1 });
            }
            // right
            if (j + 1 < columns && map[i][j + 1] != '#' && !visited[i][j + 1]) {
                queue.add(new int[] { i, j + 1 });
            }
        }
        return new int[] { -1, -1 }; // not found
    }
}
