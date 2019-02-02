package com.zhentao.review.google;

import static org.hamcrest.Matchers.closeTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class MinimizeMaxDistanceToGasStationTest {
    @Test
    public void test() {
        final int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        
        final MinimizeMaxDistanceToGasStation station = new MinimizeMaxDistanceToGasStation();
        assertThat(station.minMaxGasDist(array, 9), closeTo(0.5, 1e-6));
    }
}
