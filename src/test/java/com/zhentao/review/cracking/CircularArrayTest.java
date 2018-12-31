package com.zhentao.review.cracking;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

public class CircularArrayTest {
    @Test
    public void printTest() {
        CircularArray<Integer> array = new CircularArray<>(5);
        for (int i = 0; i < 5; i++) {
            array.add(i);
        }
        System.out.println(array);
        for (Integer i : array) {
            System.out.println(i);
        }
    }

    @Test
    public void test() {
        int[] array = { 2, -8, 3, -2, 4, -10 };
        assertThat(CircularArray.max(array), is(5));
    }
}
