package com.zhentao.review.google;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class MissingNumberTest {

    @Test
    public void test() {
//        assertThat(MissingNumber.find("11122333"), is("2"));
//        assertThat(MissingNumber.find("11122233344455666"), is("5"));
//        assertThat(MissingNumber.find("22333"), is("2"));
//        assertThat(MissingNumber.find("22333444"), is("2"));
//        assertThat(MissingNumber.find("11222333444555"), is("1"));
        MissingNumber missing = new MissingNumber();
        assertThat(missing.find("11122"), is("2"));
        assertThat(missing.find("22333"), is("2"));
        assertThat(missing.find("22333444"), is("2"));
        assertThat(missing.find("11122333"), is("2"));
    }
}
