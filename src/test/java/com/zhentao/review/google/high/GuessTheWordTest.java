package com.zhentao.review.google.high;

import org.junit.Test;

public class GuessTheWordTest {
    @Test
    public void test() {
        final String[] words = {"acckzz","ccbazz","eiowzz","abcczz"};
        final GuessTheWord guess = new GuessTheWord();
        guess.findSecretWord(words, new Master());
    }
}
