package com.zhentao.review;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.Collections;

import org.junit.Test;

public class TrieAutoCompleteTest {
    @Test
    public void test() {
        final String[] sentences = { "i love you", "island", "ironman", "i love leetcode" };
        final int[] times = { 5, 3, 2, 2 };
        final TrieAutoComplete auto = new TrieAutoComplete(sentences, times);
        
        assertThat(auto.input('i'), is(Arrays.asList("i love you", "island", "i love leetcode")));
        assertThat(auto.input(' '), is(Arrays.asList("i love you", "i love leetcode")));
        assertThat(auto.input('a'), is(Collections.emptyList()));
        assertThat(auto.input('#'), is(Collections.emptyList()));

        assertThat(auto.input('i'), is(Arrays.asList("i love you", "island", "i love leetcode")));
        assertThat(auto.input(' '), is(Arrays.asList("i love you", "i love leetcode", "i a")));
        assertThat(auto.input('a'), is(Arrays.asList("i a")));
        assertThat(auto.input('#'), is(Collections.emptyList()));
        
        assertThat(auto.input('i'), is(Arrays.asList("i love you", "island", "i a")));

    }
}
