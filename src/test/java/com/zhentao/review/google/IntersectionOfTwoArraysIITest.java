package com.zhentao.review.google;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class IntersectionOfTwoArraysIITest {
    @Test
    public void test() {
        final IntersectionOfTwoArraysII intersection = new IntersectionOfTwoArraysII();
        int[] nums1 = { 1, 2, 2, 1 }, nums2 = { 2, 2 };
        assertThat(intersection.intersect(nums1, nums2), is(new int[] { 2, 2 }));

        nums1 = new int[] { 4, 9, 5 };
        nums2 = new int[] { 9, 4, 9, 8, 4 };
        assertThat(intersection.intersect(nums1, nums2), is(new int[] { 9, 4 }));
    }
}
