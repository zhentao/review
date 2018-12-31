package com.zhentao.review;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class LongestIncreasingSubsequenceTest {

    @Test
    public void test() {
        int[] array = {10,9,2,5,3,7,101,18};
        assertThat(LongestIncreasingSubsequence.find(array), is(4));
        assertThat(LongestIncreasingSubsequence.memo(array), is(4));
        array = new int[] {13, 14, 10, 11, 12};
        assertThat(LongestIncreasingSubsequence.find(array), is(3));
        assertThat(LongestIncreasingSubsequence.memo(array), is(3));
    }
}
