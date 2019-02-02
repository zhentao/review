package com.zhentao.review.leetcode;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class SpiralMatrixIITest {
    @Test
    public void test() throws InterruptedException {
        int[][] input = { { 1, 2, 3 }, { 8, 9, 4 }, { 7, 6, 5 } };
        final SpiralMatrixII spiral = new SpiralMatrixII();
        assertThat(spiral.generateMatrix(3), is(input));
        input = new int[][] { { 1, 2, 3, 4 }, { 12, 13, 14, 5 }, { 11, 16, 15, 6 }, {10,9,8,7 }};
        assertThat(spiral.generateMatrix(4), is(input));
        
        input = new int[][] { { 1 }};
        assertThat(spiral.generateMatrix(1), is(input));
    }
}