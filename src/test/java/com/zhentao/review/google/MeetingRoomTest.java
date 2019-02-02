package com.zhentao.review.google;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class MeetingRoomTest {
    @Test
    public void test() {
        final MeetingRoom meeting = new MeetingRoom();
        int[][] intervals = { { 15, 30 }, { 5, 10 }, { 15, 20 } };
        assertThat(meeting.canAttendMeetings(intervals), is(false));

        intervals = new int[][] { { 25, 30 }, { 5, 10 }, { 15, 20 } };
        assertThat(meeting.canAttendMeetings(intervals), is(true));
    }
}
