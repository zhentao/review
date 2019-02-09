package com.zhentao.review.google;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
public class KthLargestInArrayTest {
    @Test
    public void test() {
        final KthLargestInArray kth = new KthLargestInArray();
        int[] nums = {3,2,1,5,6,4};
        assertThat(kth.findKthLargest(nums, 2), is(5));
        nums = new int[] {3,2,3,1,2,4,5,5,6};
        assertThat(kth.findKthLargest(nums, 4), is(4));
    }
}   
