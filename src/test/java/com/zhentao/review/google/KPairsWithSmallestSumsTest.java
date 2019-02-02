package com.zhentao.review.google;

import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class KPairsWithSmallestSumsTest {
    @Test
    public void test() {
        final KPairsWithSmallestSums sums = new KPairsWithSmallestSums();
        int[] nums1 = { 1, 7, 11 };
        int[] nums2 = { 2, 4, 6 };
        int k = 3;
        // IsIterableContainingInOrder
        assertThat(sums.kSmallestPairs(nums1, nums2, k),
                contains(new int[] { 1, 2 }, new int[] { 1, 4 }, new int[] { 1, 6 }));

        nums1 = new int[] { 1, Integer.MAX_VALUE };
        nums2 = new int[] { 2, Integer.MAX_VALUE };
        k = 3;
        System.out.println(1+Integer.MAX_VALUE);
        System.out.println(2+Integer.MAX_VALUE);
        
        System.out.println(2+Integer.MAX_VALUE > 1+Integer.MAX_VALUE);
        
        assertThat(sums.kSmallestPairs(nums1, nums2, k),
                contains(new int[] { 1, 2 }, new int[] { 1, Integer.MAX_VALUE }, new int[] { Integer.MAX_VALUE, 2 }));
    }
}
