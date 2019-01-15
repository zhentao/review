package com.zhentao.review.leetcode;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
public class RedundantConnectionTest {
    RedundantConnection redundant;
    
    @Before
    public void setup() {
        this.redundant = new RedundantConnection();
    }
    @Test
    public void test() {
        int[][] input = {{1,2}, {1,3}, {2,3}};
        int[] output = {2,3};
        assertThat(redundant.findRedundantConnection(input), is(output));
    }
}
