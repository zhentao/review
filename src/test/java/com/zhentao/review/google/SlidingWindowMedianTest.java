package com.zhentao.review.google;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class SlidingWindowMedianTest {

    @Test
    public void test() {
        int[] input = { 1, 3, -1, -3, 5, 3, 6, 7 };
        double[] output = { 1, -1, -1, 3, 5, 6 };
        final SlidingWindowMedian sliding = new SlidingWindowMedian();
        assertThat(sliding.medianSlidingWindow(input, 3), is(output));

        input = new int[] { 2147483647, 2147483647 };
        output = new double[] { 2147483647 };
        assertThat(sliding.medianSlidingWindow(input, 2), is(output));

        input = new int[] { 7, 0, 3, 9, 9, 9, 1, 7, 2, 3 };
        output = new double[] { 8.0, 6.0, 8.0, 8.0, 5.0 };
        assertThat(sliding.medianSlidingWindow(input, 6), is(output));

        input = new int[] { -2147483648, -2147483648, 2147483647, -2147483648, -2147483648, -2147483648, 2147483647,
                2147483647, 2147483647, 2147483647, -2147483648, 2147483647, -2147483648 };
        output = new double[] { -2147483648.0, -2147483648.0, -2147483648.0, -2147483648.0, -2147483648.0, 2147483647.0,
                2147483647.0, 2147483647.0, 2147483647.0, 2147483647.0, -2147483648.0 };
        assertThat(sliding.medianSlidingWindow(input, 3), is(output));
    }
}
