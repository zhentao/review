package com.zhentao.review.google;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class DecodeWaysTest {
    @Test
    public void test() {
        final DecodeWays decode = new DecodeWays();
        
        assertThat(decode.numDecodings("12"), is(2));
        assertThat(decode.numDecodings("226"), is(3));
        assertThat(decode.numDecodings("262"), is(2));
        assertThat(decode.numDecodings("10"), is(1));
        assertThat(decode.numDecodings("210"), is(1));
        assertThat(decode.numDecodings("270"), is(0));
        assertThat(decode.numDecodings("2101"), is(1));
        assertThat(decode.numDecodings("21011"), is(2));
        assertThat(decode.numDecodings("101"), is(1));
        assertThat(decode.numDecodings("100"), is(0));
    }
}
