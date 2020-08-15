package com.zhentao.review.facebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 56. Merge Intervals Medium
 *
 * Given a collection of intervals, merge all overlapping intervals.
 *
 * Example 1:
 *
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]] Output:
 * [[1,6],[8,10],[15,18]] Explanation: Since intervals [1,3] and [2,6] overlaps,
 * merge them into [1,6].
 *
 * Example 2:
 *
 * Input: intervals = [[1,4],[4,5]] Output: [[1,5]] Explanation: Intervals [1,4]
 * and [4,5] are considered overlapping.
 *
 * NOTE: input types have been changed on April 15, 2019. Please reset to
 * default code definition to get new method signature.
 *
 *
 *
 * Constraints:
 *
 * intervals[i][0] <= intervals[i][1]
 *
 *
 * @author zhentao.li
 *
 */
public class LeetCode0056 {
    public static void main(String[] args) {
        int[][] intervals = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
        int[][] results = new LeetCode0056().merge(intervals);
        System.out.println(Arrays.toString(results));
    }

    public int[][] merge(int[][] intervals) {
        if (intervals == null) {
            return null;
        }
        if (intervals.length == 0) {
            return new int[0][0];
        }
        Arrays.sort(intervals, (i, j) -> Integer.compare(i[0], j[0]));

        List<int[]> merged = new ArrayList<>();
        merged.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            int[] last = merged.get(merged.size() - 1);
            if (last[1] >= interval[0]) {
                if (last[1] < interval[1]) {
                    last[1] = interval[1];
                }
            } else {
                merged.add(interval);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }
}
