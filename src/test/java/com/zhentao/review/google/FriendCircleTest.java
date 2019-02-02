package com.zhentao.review.google;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class FriendCircleTest {
    @Test
    public void test() {
        final FriendCircle friend = new FriendCircle();
        int[][] array = { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } };
        assertThat(friend.findCircleNum(array), is(2));

        array = new int[][] { { 1, 1, 0 }, { 1, 1, 1 }, { 0, 1, 1 } };
        assertThat(friend.findCircleNum(array), is(1));
    }
}
