package com.zhentao.review.google;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class KnightProbabilityInChessboardTest {
    @Test
    public void test() {
        final KnightProbabilityInChessboard knight = new KnightProbabilityInChessboard();
        assertThat(knight.knightProbability(3, 2, 0, 0), is(0.0625));
        assertThat(knight.knightProbability(3, 3, 0, 0), is(0.015625));
        assertThat(knight.knightProbability(3, 4, 0, 0), is(0.00390625));
        //assertThat(knight.knightProbability(8, 30, 6, 4), is(0.00019));
    }
}
