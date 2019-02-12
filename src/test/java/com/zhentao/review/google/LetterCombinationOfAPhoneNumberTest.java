package com.zhentao.review.google;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;

public class LetterCombinationOfAPhoneNumberTest {
    @Test
    public void test() {
        final LetterCombinationOfAPhoneNumber comb = new LetterCombinationOfAPhoneNumber();
        assertThat(comb.letterCombinations("2"), is(List.of("a","b","c")));
        assertThat(comb.letterCombinations("23"), is(List.of("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf")));
    }

    @Test
    public void test2() {
        final LetterCombinationOfAPhoneNumber comb = new LetterCombinationOfAPhoneNumber();
        assertThat(comb.letterCombinations2("test"), is(List.of("test")));
        assertThat(comb.letterCombinations2("test{1,2,3}"), is(List.of("test1","test2","test3")));
        assertThat(comb.letterCombinations2("test{1,2,3}{4,5,6}"), is(List.of("test14","test15","test16","test24","test25","test26","test34","test35","test36")));
        //The implementation is not correct
        //assertThat(comb.letterCombinations2("test{1,{1,2},3}"), is(List.of("test113","test123")));

    }
}
