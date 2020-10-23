package com.zhentao.review.facebook;

import java.util.Arrays;

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
 *<pre>
 *给了三个data, employee id, clock in time, clock out time, 找出最多有多少员工上班
 *emid in-time out-time
1 2 8
2 8 10
3 14 15
time are integer (not 24 hour)
 *</pre>
 * @author zhentao
 * @see google/MeetingRoomII.java
 */

public class LeetCode0253 {
    public static void main(String[] args) {
        int[][] intervals = { { 15, 30 }, { 5, 10 }, { 18, 20 } };
        System.out.println(new LeetCode0253().maxEmployees(intervals));
    }
    public int maxEmployees(final int[][] intervals) {
        Clock[] points = new Clock[intervals.length*2];
        int i = 0;
        for (int[] interval : intervals) {
            Clock clockIn = new ClockIn(interval[0]);
            Clock clockOut = new ClockOut(interval[1]);
            points[i++] = clockIn;
            points[i++] = clockOut;
        }

        Arrays.sort(points);
        int maxEmployees = 0;
        int employees = 0;
        for (Clock p : points) {
            employees += p.inOrOut;
            maxEmployees = Math.max(maxEmployees, employees);
        }
        return maxEmployees;
    }

    private static class Clock implements Comparable<Clock> {
        int time;
        int inOrOut;

        Clock(int time, int inOrOut) {
            this.time = time;
            this.inOrOut = inOrOut;
        }

        @Override
        public int compareTo(Clock o) {
            //let clock out before clock in if they have same time.
            return time != o.time? Integer.compare(time, o.time) : Integer.compare(inOrOut, o.inOrOut);
        }
    }

    private static class ClockIn extends Clock {
        ClockIn(int time) {
            super(time, 1);
        }
    }

    private static class ClockOut extends Clock {
        ClockOut(int time) {
            super(time, -1);
        }
    }
}
