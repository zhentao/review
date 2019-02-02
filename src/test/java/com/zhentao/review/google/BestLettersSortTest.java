package com.zhentao.review.google;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class BestLettersSortTest {
    @Test
    public void test() {
        final BestLettersSort best = new BestLettersSort();
        final char[] order = { 'b', 'a', 'd' };
        final String[] input = { "apple", "banana", "dog", "abandon", "app" };
        best.sort(order, input);
        assertThat(input, is(new String[] { "banana", "abandon", "app", "apple", "dog" }));
    }
}
