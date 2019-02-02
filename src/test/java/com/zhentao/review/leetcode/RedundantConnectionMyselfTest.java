package com.zhentao.review.leetcode;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.zhentao.review.google.high.RedundantConnectionMyself;
public class RedundantConnectionMyselfTest {
    @Test
    public void test() {
        final RedundantConnectionMyself myself = new RedundantConnectionMyself();
        final int[][] input = {{1,2}, {1,3}, {2,3}};
        final int[] output = {2,3};
        assertThat(myself.findRedundantConnection(input), is(output));
    }
}
