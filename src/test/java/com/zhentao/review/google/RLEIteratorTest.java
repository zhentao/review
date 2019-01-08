package com.zhentao.review.google;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class RLEIteratorTest {
    
    private RLEIterator iterator;
    
    @Before
    public void setup() {
        
    }
    
    @Test
    public void test() {
        int[] array = {3,8,0,9,2,5};
        iterator = new RLEIterator(array);
        assertThat(iterator.next(2), is(8));
        assertThat(iterator.next(1), is(8));
        assertThat(iterator.next(1), is(5));
        assertThat(iterator.next(2), is(-1));
    }
    
    @Test
    public void test2() {
        int[] array = {3,8,0,9,2,5};
        iterator = new RLEIterator(array);
        assertThat(iterator.next(2), is(8));
        assertThat(iterator.next(1), is(8));
        assertThat(iterator.next(1), is(5));
        assertThat(iterator.next(1), is(5));
        assertThat(iterator.next(1), is(-1));
    }
    
    @Test
    public void test3() {
        int[] array = {3,8,0,9,2,5, 4, 6};
        iterator = new RLEIterator(array);
        assertThat(iterator.next(4), is(5));
        assertThat(iterator.next(8), is(-1));
    }
    
    @Test
    public void test4() {
        int[] array = {3,8,0,9,2,5, 4, 6};
        iterator = new RLEIterator(array);
        assertThat(iterator.next(9), is(6));
        assertThat(iterator.next(8), is(-1));
    }
}
