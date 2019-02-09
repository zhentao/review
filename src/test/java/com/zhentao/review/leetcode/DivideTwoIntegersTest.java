package com.zhentao.review.leetcode;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
public class DivideTwoIntegersTest {
    @Test
    public void test() {
        final DivideTwoIntegers divide = new DivideTwoIntegers();
        assertThat(divide.divide(Integer.MIN_VALUE, Integer.MAX_VALUE), is(-1));
        
        assertThat(divide.divide(Integer.MIN_VALUE, Integer.MAX_VALUE/2), is(-2));
        assertThat(divide.divide(Integer.MIN_VALUE, 1), is(Integer.MIN_VALUE));
        assertThat(divide.divide(Integer.MIN_VALUE, 2), is(Integer.MIN_VALUE/2));
    }
}
