package com.zhentao.review.google;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class BullsAndCowsTest {

    @Test
    public void test() {
        System.out.println(1<<2+1);
        final BullsAndCows bulls = new BullsAndCows();
        assertThat(bulls.getHint("8226526357", "7965193296"), is("0A6B"));

        assertThat(bulls.getHint("2962", "7236"), is("0A2B"));
        assertThat(bulls.getHint("1123", "0111"), is("1A1B"));
        
        assertThat(bulls.getHint("1807", "7810"), is("1A3B"));
    }
}
