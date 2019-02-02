package com.zhentao.review.google.high;

import static org.hamcrest.Matchers.closeTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class MinimumCostToHireKWorkersTest {
    @Test
    public void test() {
        final MinimumCostToHireKWorkers minimum = new MinimumCostToHireKWorkers();
          int[] quality = {10,20,5};
          int[] wage = {70,50,30};
        assertThat(minimum.mincostToHireWorkers2(quality, wage, 2), closeTo(105.0, 10e-5));
        
        quality = new int[]{3,1,10,10,1};
        wage = new int[]{4,8,2,2,7};
        assertThat(minimum.mincostToHireWorkers2(quality, wage, 3), closeTo(30.66667, 10e-5));
    }
}
