package com.zhentao.review.amazon;

import java.util.PriorityQueue;

/**
 * <b>973. K Closest Points to Origin</b>
 *
 * <pre>
 * We have a list of points on the plane.  Find the K closest points to the origin (0, 0).

(Here, the distance between two points on a plane is the Euclidean distance.)

You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)



Example 1:

Input: points = [[1,3],[-2,2]], K = 1
Output: [[-2,2]]
Explanation:
The distance between (1, 3) and the origin is sqrt(10).
The distance between (-2, 2) and the origin is sqrt(8).
Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].

Example 2:

Input: points = [[3,3],[5,-1],[-2,4]], K = 2
Output: [[3,3],[-2,4]]
(The answer [[-2,4],[3,3]] would also be accepted.)



Note:

    1 <= K <= points.length <= 10000
    -10000 < points[i][0] < 10000
    -10000 < points[i][1] < 10000
 *
 *
 * </pre>
 *
 * @author zhentao
 *
 */
public class KClosestPointsToOrigin {
    public int[][] kClosest(final int[][] points, final int K) {
        final PriorityQueue<Point> queue = new PriorityQueue<>();
        for (final int[] array : points) {
            final Point point = new Point(array);
            if (queue.size() == K) {
                final Point top = queue.peek();
                if (top.distance > point.distance) {
                    queue.remove();
                    queue.add(point);
                }
            } else {
                queue.add(point);
            }
        }
        return queue.stream().map(p -> p.getArray()).toArray(size -> new int[size][]);
    }

    private static class Point implements Comparable<Point> {
        int[] array;
        int distance; // x^2 + y^2

        Point(final int[] array) {
            this.array = array;
            distance = array[0] * array[0] + array[1] * array[1];
        }

        @Override
        public int compareTo(final Point o) {
            return Integer.compare(o.distance, distance);
        }

        int[] getArray() {
            return array;
        }
    }
}
