package com.zhentao.review.google;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class MazeTest {
    @Test
    public void test() {
        final int[][] maze = { { 0, 0, 1, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 1, 0 }, { 1, 1, 0, 1, 1 },
                { 0, 0, 0, 0, 0 } };

        final int[] start = { 0, 4 };
        int[] dest = { 4, 4 };

        final Maze mazeFinder = new Maze();
        assertThat(mazeFinder.hasPath(maze, start, dest), is(true));

        dest = new int[] { 3, 2 };
        assertThat(mazeFinder.hasPath(maze, start, dest), is(false));
    }

}
