package com.zhentao.review.google.high;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class BusRoutesTest {
    @Test
    public void test() {
        int[][] routes = { { 1, 2, 7 }, { 3, 6, 7 } };
        final BusRoutes bus = new BusRoutes();
        assertThat(bus.numBusesToDestination(routes, 1, 6), is(2));

        routes = new int[][] { { 25, 33 }, { 3, 5, 13, 22, 23, 29, 37, 45, 49 }, { 15, 16, 41, 47 },
                { 5, 11, 17, 23, 33 }, { 10, 11, 12, 29, 30, 39, 45 }, { 2, 5, 23, 24, 33 },
                { 1, 2, 9, 19, 20, 21, 23, 32, 34, 44 }, { 7, 18, 23, 24 }, { 1, 2, 7, 27, 36, 44 }, { 7, 14, 33 } };

        assertThat(bus.numBusesToDestination(routes, 7, 47), is(-1));
    }
}
