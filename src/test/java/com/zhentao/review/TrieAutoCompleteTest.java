package com.zhentao.review;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class TrieAutoCompleteTest {
    @Test
    public void test() {
        final String[] sentences = { "i love you", "island", "ironman", "i love leetcode" };
        final int[] times = { 5, 3, 2, 2 };
        final TrieAutoComplete auto = new TrieAutoComplete(sentences, times);

        assertThat(auto.input('i'), is(List.of("i love you", "island", "i love leetcode")));
        assertThat(auto.input(' '), is(List.of("i love you", "i love leetcode")));
        assertThat(auto.input('a'), is(Collections.emptyList()));
        assertThat(auto.input('#'), is(Collections.emptyList()));

        assertThat(auto.input('i'), is(List.of("i love you", "island", "i love leetcode")));
        assertThat(auto.input(' '), is(List.of("i love you", "i love leetcode", "i a")));
        assertThat(auto.input('a'), is(List.of("i a")));
        assertThat(auto.input('#'), is(Collections.emptyList()));

        assertThat(auto.input('i'), is(List.of("i love you", "island", "i a")));

    }
}
