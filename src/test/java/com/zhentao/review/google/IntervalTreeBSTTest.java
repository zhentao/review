package com.zhentao.review.google;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Collections;
import java.util.List;

import org.junit.Test;

import com.zhentao.review.google.IntervalTreeBST.Interval;

public class IntervalTreeBSTTest {
    @Test
    public void test() {
        final IntervalTreeBST intervalTree = new IntervalTreeBST();
        final int[][] intervals = { { 15, 20 }, { 10, 30 }, { 17, 19 }, { 5, 20 }, { 12, 15 }, { 30, 40 }, { 15, 22 } };
        for (final int[] interval : intervals) {
            intervalTree.insert(new Interval(interval[0], interval[1]));
        }
        assertThat(intervalTree.overlapSearch(new Interval(18, 20)), is(new Interval(15, 20)));

        assertThat(intervalTree.overlapSearchAll(new Interval(18, 20)), is(List.of(new Interval(5, 20),
                new Interval(10, 30), new Interval(15, 20), new Interval(15, 22), new Interval(17, 19))));

        assertThat(intervalTree.overlapSearchAll(new Interval(2, 4)), is(Collections.emptyList()));

        assertThat(intervalTree.search(18), is(List.of(new Interval(5, 20), new Interval(10, 30),
                new Interval(15, 20), new Interval(15, 22), new Interval(17, 19))));

        assertThat(intervalTree.search(35), is(List.of(new Interval(30, 40))));

        assertThat(intervalTree.search(42), is(Collections.emptyList()));

        assertThat(intervalTree.search(20), is(List.of(new Interval(5,20), new Interval(10,30), new Interval(15,20), new Interval(15,22))));
    }
}
