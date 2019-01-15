package com.zhentao.review.google;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class MostStonesRemovedTest {
    private MostStonesRemoved mostStones;
    
    @Before
    public void setup() {
        mostStones = new MostStonesRemoved();
    }
    @Test
    public void test() {
        int[][] array = {{0,0},{0,1},{1,0},{1,2},{2,1},{2,2}};
        assertThat(mostStones.removeStones4(array), is(5));
        
        array = new int[][]{ { 4, 5 }, { 0, 4 }, { 0, 5 }, { 4, 3 }, { 2, 2 }, { 5, 1 }, { 0, 3 }, { 2, 4 }, { 4, 0 } };
        assertThat(mostStones.removeStones4(array), is(7));
        assertThat(mostStones.removeStones(array), is(7));

        array = new int[][] { { 2, 1 }, { 0, 1 }, { 0, 0 }, { 2, 2 }, { 1, 0 }, { 1, 2 } };
        assertThat(mostStones.removeStones4(array), is(5));

        array = new int[][] { { 0, 0 }, { 0, 2 }, { 1, 1 }, { 2, 0 }, { 2, 2 } };
        assertThat(mostStones.removeStones4(array), is(3));

        array = new int[][] { { 0, 0 } };
        assertThat(mostStones.removeStones4(array), is(0));

        array = new int[][] { { 0, 1 }, { 1, 0 }, { 1, 1 } };
        assertThat(mostStones.removeStones4(array), is(2));
    }
}
