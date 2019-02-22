package com.zhentao.review.uber;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class StringOrderTest {
    @Test
    public void test() {
        final StringOrder order = new StringOrder();

        final String[] array = { "aaa100", "aaa8", "aaa2", "aaa11", "aaa12", "aaaa0", "aaaa1" };
        order.sort(array);
        assertThat(array, is(new String[] { "aaa2", "aaa8", "aaa11", "aaa12", "aaa100", "aaaa0", "aaaa1" }));
    }
}
