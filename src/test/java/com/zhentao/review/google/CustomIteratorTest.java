package com.zhentao.review.google;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;

import org.junit.Test;

public class CustomIteratorTest {
    @Test
    public void test() {
        final CustomIterator<Integer> iter = new CustomIterator<>(Arrays.asList(1, 2, 1, 3, 1, 4).iterator());
        iter.skip(1);
        iter.skip(1);
        assertThat(iter.next(), is(2));
        assertThat(iter.next(), is(3));
        assertThat(iter.next(), is(1));
    }
    
    @Test
    public void test2() {
        final CustomIterator<Integer> iter = new CustomIterator<>(Arrays.asList(1, 2, 1, 3, 1, 4).iterator());
        assertThat(iter.hasNext(), is(true));
        assertThat(iter.next(), is(1));
        iter.skip(1);
        iter.skip(1);
        iter.skip(2);
        //assertThat(iter.next(), is(2));
        assertThat(iter.next(), is(3));
        assertThat(iter.next(), is(4));
        assertThat(iter.hasNext(), is(false));
    }
}
