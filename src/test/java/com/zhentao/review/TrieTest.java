package com.zhentao.review;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class TrieTest {
    @Test
    public void test() {
        Trie trie = new Trie();
        trie.insert("apple");
        assertThat(trie.search("apple"), is(true));
    }
}
