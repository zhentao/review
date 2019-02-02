package com.zhentao.review.google.high;

import java.util.TreeMap;
import java.util.concurrent.ThreadLocalRandom;

/**
 * <b>497. Random Point in Non-overlapping Rectangles</b>
 * 
 * <pre>
 * Given a list of non-overlapping axis-aligned rectangles rects, write a function pick which randomly and uniformily picks an integer point in the space covered by the rectangles.

Note:

An integer point is a point that has integer coordinates. 
A point on the perimeter of a rectangle is included in the space covered by the rectangles. 
ith rectangle = rects[i] = [x1,y1,x2,y2], where [x1, y1] are the integer coordinates of the bottom-left corner, and [x2, y2] are the integer coordinates of the top-right corner.
length and width of each rectangle does not exceed 2000.
1 <= rects.length <= 100
pick return a point as an array of integer coordinates [p_x, p_y]
pick is called at most 10000 times.
Example 1:

Input: 
["Solution","pick","pick","pick"]
[[[[1,1,5,5]]],[],[],[]]
Output: 
[null,[4,1],[4,1],[3,3]]
Example 2:

Input: 
["Solution","pick","pick","pick","pick","pick"]
[[[[-2,-2,-1,-1],[1,0,3,0]]],[],[],[],[],[]]
Output: 
[null,[-1,-2],[2,0],[-2,-1],[3,0],[-2,-2]]
 * </pre>
 * 
 * @author zhentao
 *
 */
public class RandomPointInNonOverlappingRectangles {
    private final TreeMap<Integer, int[]> map;
    int sum = -1;

    public RandomPointInNonOverlappingRectangles(final int[][] rects) {
        map = new TreeMap<>();
        for (final int[] rect : rects) {
            final int length = rect[2] - rect[0] + 1;
            final int height = rect[3] - rect[1] + 1;
            final int area = length * height;
            sum += area;
            map.put(sum, rect);

        }
    }
 // convert matrix to one dimensional array
//  for (int j = rect[1]; j <= rect[3]; j++) {
//      for (int i = rect[0]; i <= rect[2]; i++) {
//          (j - rect[1]) * (rect[2] - rect[0] +1) + i - rect[0];
//      }
//  }
    public int[] pick() {
        final int random = ThreadLocalRandom.current().nextInt(sum);
        final int key = map.ceilingKey(random);
        final int[] rect = map.get(key);
        //for sum starts from 1: also change to nextInt(sum) + 1;
        //final int index = key - random; 
        final int index = random - (key - (rect[2] - rect[0] + 1) * rect[3] - rect[1] + 1);

        final int lengthX = rect[2] - rect[0] + 1;

        final int x = rect[0] + index % lengthX;
        final int y = rect[1] + index / lengthX;

        return new int[] { x, y };
    }
}
