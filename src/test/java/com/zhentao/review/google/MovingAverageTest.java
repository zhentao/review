package com.zhentao.review.google;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class MovingAverageTest {
    private MovingAverage average;
    @Before
    public void setup() {
        average = new MovingAverage(3);
    }
    
    @Test
    public void test() {
        assertThat(average.next(1), is(1.0));
        assertThat(average.next(10), is((1.0+10)/2));
        assertThat(average.next(3), is((1.0+10+3)/3));
        assertThat(average.next(5), is((10.0+3+5)/3));
    }
}
