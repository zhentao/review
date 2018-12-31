package com.zhentao.review;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.zhentao.review.cracking.WordDistance;

public class WordDistanceTest {

    @Test
    public void test() {
        String[] input = {"a", "ab", "a", "b", "c"};
        assertThat(WordDistance.minDistance(input, "a", "c"), is(2));
        input = new String[]{"x","a","a", "ab", "b", "b", "c", "a", "b", "c"};
        assertThat(WordDistance.minDistance(input, "a", "c"), is(1));
    }
}
