package com.zhentao.review.google;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class KClosedElementTest {
    KClosedElement kClosed;

    @Before
    public void setup() {
        kClosed = new KClosedElement();
    }

    @Test
    public void test() {
        int[] array = { 1, 2, 3, 4, 5, 7};
        int k = 4;
        int x = 3;
        ArrayList<Integer> list = new ArrayList<>() {
            private static final long serialVersionUID = 1L;

            {
                add(1);
                add(2);
                add(3);
                add(4);
            }
        };

        assertThat(kClosed.findClosestElements(array, k, x), is(list));
        
        k = 4;
        x = -1;
        assertThat(kClosed.findClosestElements(array, k, x), is(list));
        
        list = new ArrayList<>() {
            private static final long serialVersionUID = 1L;

            {
                add(3);
                add(4);
                add(5);
                add(7);
            }
        };
        k = 4;
        x = 6;
        assertThat(kClosed.findClosestElements(array, k, x), is(list)); 
        
        array = new int[] {0,0,1,2,3,3,4,7,7,8};
        list = new ArrayList<>() {
            private static final long serialVersionUID = 1L;

            {
                add(3);
                add(3);
                add(4);
            }
        };
        k = 3;
        x = 5;
        assertThat(kClosed.findClosestElements(array, k, x), is(list));
        
        array = new int[] {0,0,1,1,1,1,1,1,7,8};
        list = new ArrayList<>() {
            private static final long serialVersionUID = 1L;

            {
                add(1);
                add(1);
                add(1);
            }
        };
        k = 3;
        x = 1;
        assertThat(kClosed.findClosestElements(array, k, x), is(list));
    }
}
