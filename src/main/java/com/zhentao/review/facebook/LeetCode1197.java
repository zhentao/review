package com.zhentao.review.facebook;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;

/**
 * <b>1197 Minimum Knight Moves</b><br/>
 * In an infinite chess board with coordinates from -infinity to +infinity, you
 * have a knight at square [0, 0].
 *
 * A knight has 8 possible moves it can make, as illustrated below. Each move is
 * two squares in a cardinal direction, then one square in an orthogonal
 * direction.
 *
 * Return the minimum number of steps needed to move the knight to the square
 * [x, y]. It is guaranteed the answer exists.
 *
 * <pre>
Example 1:

Input: x = 2, y = 1
Output: 1
Explanation: [0, 0] → [2, 1]

Example 2:

Input: x = 5, y = 5
Output: 4
Explanation: [0, 0] → [2, 1] → [4, 2] → [3, 4] → [5, 5]



Constraints:

    |x| + |y| <= 300
 * </pre>
 *
 * @author zhentao.li
 *
 */
public class LeetCode1197 {
    public static void main(String[] args) {
        LeetCode1197 lc = new LeetCode1197();
        System.out.println(lc.minKnightMoves(5, 5));
    }

    public int minKnightMoves(int x, int y) {
//        x (+/-) 1
//        y (+/-) 2
//
//        x (+/-) 2
//        y (+/-) 1
        Point start = new Point(0, 0);
        Set<Point> visited = new HashSet<>();
        visited.add(start);
        Queue<Point> queue = new LinkedList<>();
        queue.add(start);
        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Point p = queue.remove();
                if (p.x == x && p.y == y) {
                    return steps;
                }

                add(queue, p, visited);

            }
            steps++;
        }
        return 0;
    }

    private void add(Queue<Point> queue, Point start, Set<Point> visited) {
        addToQueue(queue, visited, new Point(start.x + 1, start.y + 2));
        addToQueue(queue, visited, new Point(start.x + 1, start.y - 2));
        addToQueue(queue, visited, new Point(start.x - 1, start.y + 2));
        addToQueue(queue, visited, new Point(start.x - 1, start.y - 2));
        addToQueue(queue, visited, new Point(start.x + 2, start.y + 1));
        addToQueue(queue, visited, new Point(start.x + 2, start.y - 1));
        addToQueue(queue, visited, new Point(start.x - 2, start.y + 1));
        addToQueue(queue, visited, new Point(start.x - 2, start.y - 1));
    }

    private void addToQueue(Queue<Point> queue, Set<Point> visited, Point point) {
        if (!visited.contains(point)) {
            queue.add(point);
            visited.add(point);
        }
    }

    private static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public boolean equals(Object o) {
            Point that = (Point) o;
            return x == that.x && y == that.y;
        }
    }
}
