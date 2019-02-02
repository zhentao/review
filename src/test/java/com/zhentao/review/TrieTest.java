package com.zhentao.review;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;

import org.junit.Test;

public class TrieTest {
    @Test
    public void test() {
        final Trie trie = new Trie();
        trie.insert("apple");
        trie.insert("add");
        trie.insert("bee");
        assertThat(trie.search("apple"), is(true));
        assertThat(trie.autoComplete("a"), is(Arrays.asList("apple", "add")));
    }
}
