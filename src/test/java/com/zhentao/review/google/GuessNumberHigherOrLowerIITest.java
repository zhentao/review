package com.zhentao.review.google;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class GuessNumberHigherOrLowerIITest {

    @Test
    public void test() {
        final GuessNumberHigherOrLowerII guess = new GuessNumberHigherOrLowerII();

        assertThat(guess.getMoneyAmount(1), is(0));
        assertThat(guess.getMoneyAmount(2), is(1));
        assertThat(guess.getMoneyAmount(3), is(2));
        assertThat(guess.getMoneyAmount(4), is(4));
        assertThat(guess.getMoneyAmount(5), is(6));
        assertThat(guess.getMoneyAmount(6), is(8));
        assertThat(guess.getMoneyAmount(7), is(10));
        
    }
}
