package com.zhentao.review.leetcode;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;

public class SpiralMatrixTest {
    @Test
    public void test() {
        int[][] input = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        final SpiralMatrix spiral = new SpiralMatrix();
        assertThat(spiral.spiralOrder(input), is(List.of(1, 2, 3, 6, 9, 8, 7, 4, 5)));
        input = new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
        assertThat(spiral.spiralOrder(input), is(List.of(1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7)));
    }
}
