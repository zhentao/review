package com.zhentao.review.dp;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class BestTimeToBuyAndSellStockIITest {
    private BestTimeToBuyAndSellStockII bestTime;
    
    @Before
    public void setup() {
        bestTime = new BestTimeToBuyAndSellStockII();
    }
    @Test
    public void test() {
        int[] input = {7,1,5,3,6,4};
        assertThat(bestTime.maxProfit(input), is(7));
        
        input = new int[] {1,2,3,4,5};
        assertThat(bestTime.maxProfit(input), is(4));
        
        input = new int[] {7,6,4,3,1};
        assertThat(bestTime.maxProfit(input), is(0));
        
        input = new int[] {6,1,2, 1,2,3,4,5};
        assertThat(bestTime.maxProfit(input), is(5));
        
    }
}
