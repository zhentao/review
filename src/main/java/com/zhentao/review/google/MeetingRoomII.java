package com.zhentao.review.google;

import java.util.Arrays;
import java.util.TreeMap;

/**
 * <b>253. Meeting Rooms II</b>
 * 
 * <pre>
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.

For example,
Given [[0, 30],[5, 10],[15, 20]],
return 2.
 * </pre>
 * 
 * @author zhentao
 *
 */
public class MeetingRoomII {
    public int minMeetingRoomsWithmap(final int[][] intervals) {
        final TreeMap<Integer, Integer> map = new TreeMap<>();
        for (final int[] interval : intervals) {
            map.put(interval[0], map.getOrDefault(interval[0], 0) + 1);
            map.put(interval[1], map.getOrDefault(interval[1], 0) - 1);
        }
        int res = 0;
        int rooms = 0;
        for (final int m : map.values()) {
            res = Math.max(res,rooms += m);
        }
        return res;
    }
    
    public int minMeetingRooms(final int[][] intervals) {
        final int length = intervals.length;
        final int[] start = new int[length];
        final int[] end = new int[length];
        for (int i = 0; i < length; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int total=0;
        int endpos = 0;
        for (int i = 0; i < length; i++) {
            if (start[i] < end[endpos]) {
                total++;
            } else {
                endpos++;
            }
        }
        return total;
    }
}
