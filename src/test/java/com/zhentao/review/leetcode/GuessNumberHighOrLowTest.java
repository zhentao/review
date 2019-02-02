package com.zhentao.review.leetcode;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
public class GuessNumberHighOrLowTest {
    @Test
    public void test() {
        final GuessNumberHighOrLow guess = new GuessNumberHighOrLow();
        guess.setPick(6);
        assertThat(guess.guessNumber(10), is(6));
        
        guess.setPick(3);
        assertThat(guess.guessNumber(9), is(3));
    }
}
