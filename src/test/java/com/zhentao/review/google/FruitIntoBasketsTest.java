package com.zhentao.review.google;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class FruitIntoBasketsTest {

    private FruitIntoBaskets baskets;

    @Before
    public void setup() {
        baskets = new FruitIntoBaskets();
    }
    
    @Test
    public void test() {
        assertThat(baskets.totalFruit(new int[] {1,2,1}), is(3));
        assertThat(baskets.totalFruit(new int[] {0,1,2,2}), is(3));
        assertThat(baskets.totalFruit(new int[] {1,2,3,2,2}), is(4));
        assertThat(baskets.totalFruit(new int[] {3,3,3,1,2,1,1,2,3,3,4}), is(5));
        //assertThat(baskets.totalFruit(new int[] {0,1,2,2}), is(3));
        //assertThat(baskets.totalFruit(new int[] {0,1,2,2}), is(3));
    }
}
