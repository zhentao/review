package com.zhentao.review.google;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <b>56. Merge Intervals</b>
 * 
 * <pre>
 * Given a collection of intervals, merge all overlapping intervals.

Example 1:

Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
Example 2:

Input: [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 * </pre>
 * 
 * @author zhentao
 *
 */
public class MergeIntervals {
    public List<Interval> merge(final List<Interval> intervals) {
        Collections.sort(intervals, (a, b) -> a.start - b.start);
        final List<Interval> list = new ArrayList<>();
        for (final Interval interval : intervals) {
            if(list.isEmpty()) {
                list.add(interval);
            } else {
                final Interval prev = list.get(list.size()-1);
                if (prev.end >= interval.start) {
                    if (prev.end < interval.end) {
                        prev.end = interval.end;
                    }
                } else {
                    list.add(interval);
                }
            }
        }
        return list;
    }
}

class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(final int s, final int e) {
        start = s;
        end = e;
    }
}
