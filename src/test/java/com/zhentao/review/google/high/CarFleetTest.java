package com.zhentao.review.google.high;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class CarFleetTest {
    @Test
    public void test() {
        final CarFleet fleet = new CarFleet();
         int[] position = {10,8,0,5,3};
         int[] speed = {2,4,1,1,3};
        assertThat(fleet.carFleet(12, position, speed), is(3));
        
        position = new int[] {0,4,2};
        speed = new int[] {2,1,3};
        assertThat(fleet.carFleet(10, position, speed), is(1));
    }
}
