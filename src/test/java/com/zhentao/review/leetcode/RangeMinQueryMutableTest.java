package com.zhentao.review.leetcode;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class RangeMinQueryMutableTest {
    @Test
    public void test() {
        final int[] nums = {3,5,1,11,4, 7,9, 10};
        final RangeMinQueryMutable minQuery = new RangeMinQueryMutable(nums);
        assertThat(minQuery.findMin(0, 3), is(1));
        assertThat(minQuery.findMin(3, 6), is(4));
        minQuery.update(3, 2);
        assertThat(minQuery.findMin(3, 6), is(2));
    }
}
