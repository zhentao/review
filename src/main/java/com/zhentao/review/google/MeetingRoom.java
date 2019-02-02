package com.zhentao.review.google;

import java.util.Arrays;

/**
 * <b>252. Meeting Rooms</b>
 * 
 * <pre>
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), 
 * determine if a person could attend all meetings.

For example,
Given [[0, 30],[5, 10],[15, 20]],
return false.
 * </pre>
 * 
 * @author zhentao
 *
 */
public class MeetingRoom {
    public boolean canAttendMeetings(final int[][] intervals) {

        Arrays.sort(intervals, (x, y) -> x[0] - y[0]);

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < intervals[i - 1][1]) {
                return false;
            }
        }
        return true;
    }
}
