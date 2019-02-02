package com.zhentao.review.dp;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.zhentao.review.google.high.UniquePathsII;

public class UniquePathsIITest {
    @Test
    public void test() {
        assertThat(1, is(1));
        final UniquePathsII uniuqe = new UniquePathsII();
        int[][] obstacleGrid = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };
        assertThat(uniuqe.uniquePathsWithObstacles(obstacleGrid), is(2));

        obstacleGrid = new int[][] { { 0, 0 }, { 1, 1 }, { 0, 0 } };
        assertThat(uniuqe.uniquePathsWithObstacles(obstacleGrid), is(0));
    }
}
