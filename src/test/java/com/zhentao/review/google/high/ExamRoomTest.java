package com.zhentao.review.google.high;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class ExamRoomTest {
    @Test
    public void test() {
        final ExamRoom2 room = new ExamRoom2(10);
        assertThat(room.seat(), is(0));
        assertThat(room.seat(), is(9));
        assertThat(room.seat(), is(4));
        room.leave(9);
        assertThat(room.seat(), is(9));
    }
}
