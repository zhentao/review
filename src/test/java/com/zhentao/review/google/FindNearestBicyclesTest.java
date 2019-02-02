package com.zhentao.review.google;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class FindNearestBicyclesTest {
    @Test
    public void test() {
        final char[][] map = { { '.', '.', '.', '.', '.', '#' }, { '.', '.', 'E', '.', '.', '#' },
                { '#', '#', '#', '.', '#', '#' }, { '.', 'B', '.', '.', '.', '.' }, { '.', '.', '.', '.', '.', 'B' } };
        final FindNearestBicycles nearest = new FindNearestBicycles();
        
        assertThat(nearest.find(map, new int[] {1,2}), is(new int[] {3, 1}));
    }
}
