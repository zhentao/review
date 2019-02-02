package com.zhentao.review.google;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.zhentao.review.google.high.NumberOfCornerRectangle;

public class NumberOfCornerRectangleTest {
    @Test
    public void test() {
        int[][] grid = { { 1, 0, 0, 1, 0 }, { 0, 0, 1, 0, 1 }, { 0, 0, 0, 1, 0 }, { 1, 0, 1, 0, 1 } };
        assertThat(NumberOfCornerRectangle.bruteForce(grid), is(1));
        assertThat(NumberOfCornerRectangle.countCornerRectangles(grid), is(1));

        grid = new int[][] { { 1, 1, 1 }, { 1, 1, 1 }, { 1, 1, 1 } };
        assertThat(NumberOfCornerRectangle.bruteForce(grid), is(9));
        assertThat(NumberOfCornerRectangle.countCornerRectangles(grid), is(9));
        
        
        
        
    }
}
