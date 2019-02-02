package com.zhentao.review.google;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class PositionOfLarggeGroupTest {
    @Test
    public void test() {
        final PositionOfLarggeGroup large = new PositionOfLarggeGroup();
        assertThat(large.largeGroupPositions("abbxxxxzzy").toString(), is("[[3, 6]]"));
        
        assertThat(large.largeGroupPositions("abc").toString(), is("[]"));
        
        assertThat(large.largeGroupPositions("abcdddeeeeaabbbcd").toString(), is("[[3, 5], [6, 9], [12, 14]]"));
    }
}
