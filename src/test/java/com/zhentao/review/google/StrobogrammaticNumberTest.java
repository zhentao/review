package com.zhentao.review.google;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class StrobogrammaticNumberTest {
    @Test
    public void test() {
        final StrobogrammaticNumber magic = new StrobogrammaticNumber();

        assertThat(magic.isStrobogrammatic("123"), is(false));
        assertThat(magic.isStrobogrammatic("609"), is(true));
        assertThat(magic.isStrobogrammatic("86"), is(false));
        assertThat(magic.isStrobogrammatic("6"), is(false));
        assertThat(magic.isStrobogrammatic("99"), is(false));
        assertThat(magic.isStrobogrammatic("88"), is(true));
        assertThat(magic.isStrobogrammatic("8"), is(true));
        assertThat(magic.isStrobogrammatic("80"), is(false));
    }
}
