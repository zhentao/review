package com.zhentao.review.google;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
public class MeetingRoomIITest {
    @Test
    public void test() {
        final MeetingRoomII meeting = new MeetingRoomII();
        int[][] intervals = { { 15, 30 }, { 5, 10 }, { 18, 20 } };
        assertThat(meeting.minMeetingRoomsWithmap(intervals), is(2));
        assertThat(meeting.minMeetingRooms(intervals), is(2));

        intervals = new int[][] { { 25, 30 }, { 5, 10 }, { 15, 20 } };
        assertThat(meeting.minMeetingRoomsWithmap(intervals), is(1));
        assertThat(meeting.minMeetingRooms(intervals), is(1));
    }
}
