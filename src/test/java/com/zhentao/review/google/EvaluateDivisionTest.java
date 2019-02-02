package com.zhentao.review.google;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class EvaluateDivisionTest {
    @Test
    public void test() {
        assertThat(true, is(true));
        
        String[][] equations = { { "a", "b" }, { "b", "c" } };
        double[] values = { 2.0, 3.0 };
        String[][] queries = { { "a", "c" }, { "b", "a" }, { "a", "e" }, { "a", "a" }, { "x", "x" } };
        double[] results = new EvaluateDivision().calcEquation(equations, values, queries);
        assertThat(results, is(new double[]{6.0, 0.5, -1.0, 1.0, -1.0}));
    }
}
