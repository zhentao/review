package com.zhentao.review.dp;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class CutRodTest {
    @Test
    public void test1() {
        final CutRod cutRod = new CutRod();
        final int length = 10;

        final int numberOfCuts = 1;
        final int[] places = { 2 };
        assertThat(cutRod.cutBruteForce(length, numberOfCuts, places), is(10));
        assertThat(cutRod.memo(length, numberOfCuts, places), is(10));
    }

    @Test
    public void test2() {
        final CutRod cutRod = new CutRod();
        final int length = 10;

        final int numberOfCuts = 2;
        final int[] places = { 2, 5 };
        assertThat(cutRod.cutBruteForce(length, numberOfCuts, places), is(15));
        assertThat(cutRod.memo(length, numberOfCuts, places), is(15));
    }

    @Test
    public void test3() {
        final CutRod cutRod = new CutRod();
        int length = 10;

        int numberOfCuts = 3;
        int[] places = { 2, 4, 7 };
        assertThat(cutRod.cutBruteForce(length, numberOfCuts, places), is(20));
        assertThat(cutRod.memo(length, numberOfCuts, places), is(20));

        length = 100;
        numberOfCuts = 3;
        places = new int[] { 25, 50, 75 };
        assertThat(cutRod.cutBruteForce(length, numberOfCuts, places), is(200));
        assertThat(cutRod.memo(length, numberOfCuts, places), is(200));

        length = 10;
        numberOfCuts = 4;
        places = new int[] { 4, 5, 7, 8 };
        assertThat(cutRod.cutBruteForce(length, numberOfCuts, places), is(22));
        assertThat(cutRod.memo(length, numberOfCuts, places), is(22));
    }

}
