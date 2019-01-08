package com.zhentao.review.cracking;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class ContinuousMedianTest {
    private ContinuousMedian cont;

    @Before
    public void setup() {
        cont = new ContinuousMedian();
    }

    @Test
    public void testOneElement() {
        cont.addNum(1);
        assertThat(cont.getMedian(), is(1.0));
    }
    
    @Test
    public void testThreeElements() {
        cont.addNum(1);
        cont.addNum(2);
        cont.addNum(3);
        assertThat(cont.getMedian(), is(2.0));
    }
    
    @Test
    public void testWithEvenElements() {
        
        cont.addNum(3);
        cont.addNum(4);
        cont.addNum(1);
        cont.addNum(2);
        assertThat(cont.getMedian(), is(2.5));
    }
    @Test(expected = RuntimeException.class)
    public void testWithZeroElements() {
        cont.getMedian();
    }
}
