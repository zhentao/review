package com.zhentao.review.google;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class MagicNumberTest {
    @Test
    public void test() {
        final MagicNumber magic = new MagicNumber();

        assertThat(magic.check(123), is(false));
        assertThat(magic.check(609), is(false));
        assertThat(magic.check(86), is(true));
        assertThat(magic.check(6), is(true));
        assertThat(magic.check(99), is(true));
        assertThat(magic.check(88), is(false));
        assertThat(magic.check(8), is(false));
        assertThat(magic.check(80), is(true));
    }
}
