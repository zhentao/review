package com.zhentao.review.google;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class MinimumInRotatedSortedArrayTest {
    
    @Test
    public void test() {
        MinimumInRotatedSortedArray minimum = new MinimumInRotatedSortedArray();
        
        int[] array = {3,4,5,1,2};
        assertThat(minimum.findMin(array), is(1));
        
        array = new int[] {7,8,0,1,2,3, 4,5,6};
        assertThat(minimum.findMin(array), is(0));
        
        //This is not a valid test case, but the program works.
        array = new int[] {5,4, 3,2,1};
        assertThat(minimum.findMin(array), is(1));
        
        array = new int[] {1,2,3,4,5};
        assertThat(minimum.findMin(array), is(1));
    }
}
