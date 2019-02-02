package com.zhentao.review.google.high;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
/**
 * 
 * <pre>
 * {{'O','P','O','B','O','O','P'},
 *  {'O','O','O','O','O','O','O'},
 *  {'O','O','O','O','O','O','O'},
 *  {'O','O','O','O','O','O','O'},
 *  {'B','O','O','B','O','O','B'}}
 * </pre>
 */


public class BicylesForPeopleTest {

    @Test
    public void test() {
        final char[][] input = { { 'O', 'P', 'O', 'B', 'O', 'O', 'P' }, { 'O', 'O', 'O', 'O', 'O', 'O', 'O' },
                { 'O', 'O', 'O', 'O', 'O', 'O', 'O' }, { 'O', 'O', 'O', 'O', 'O', 'O', 'O' },
                { 'B', 'O', 'O', 'B', 'O', 'O', 'B' } };
        final BicylesForPeople bp = new BicylesForPeople();
        final List<Pair> list = bp.find(input);
        assertThat(list.size(), is(2));
        assertThat(list, is(
                Arrays.asList(new Pair(new Point(0, 1), new Point(0, 3)), new Pair(new Point(0, 6), new Point(4, 6)))));
    }
}
