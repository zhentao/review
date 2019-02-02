package com.zhentao.review.leetcode;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
public class RangeSumQueryMutableTest {
    @Test
    public void test() {
        final int[] nums = {1,3,5,7,9,11};
        final RangeSumQueryMutable rangeSum = new RangeSumQueryMutable(nums);
        assertThat(rangeSum.sumRange(1, 2), is(8));
        rangeSum.update(1, 2);
        assertThat(rangeSum.sumRange(1, 2), is(7));
        
    }
}
