package com.zhentao.review.leetcode;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class SpiralMatrixIIITest {
    @Test
    public void test() {
        final SpiralMatrixIII spiral = new SpiralMatrixIII();

        assertThat(spiral.spiralMatrixIII(1, 4, 0, 0), is(new int[][] { { 0, 0 }, { 0, 1 }, { 0, 2 }, { 0, 3 } }));

        assertThat(spiral.spiralMatrixIII(5, 6, 1, 4),
                is(new int[][] { { 1, 4 }, { 1, 5 }, { 2, 5 }, { 2, 4 }, { 2, 3 }, { 1, 3 }, { 0, 3 }, { 0, 4 },
                        { 0, 5 }, { 3, 5 }, { 3, 4 }, { 3, 3 }, { 3, 2 }, { 2, 2 }, { 1, 2 }, { 0, 2 }, { 4, 5 },
                        { 4, 4 }, { 4, 3 }, { 4, 2 }, { 4, 1 }, { 3, 1 }, { 2, 1 }, { 1, 1 }, { 0, 1 }, { 4, 0 },
                        { 3, 0 }, { 2, 0 }, { 1, 0 }, { 0, 0 } }));
    }
}
