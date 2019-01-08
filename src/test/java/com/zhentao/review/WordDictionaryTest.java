package com.zhentao.review;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class WordDictionaryTest {
    private WordDictionaryTrie dictionary;
    @Before
    public void setup() {
        dictionary = new WordDictionaryTrie();
        dictionary.addWord("bad");
        dictionary.addWord("dad");
        dictionary.addWord("mad");
    }
    
    @Test
    public void testFindNotFound() {
        assertThat(dictionary.search("pad"), is(false));
    }
    
    @Test
    public void testFindFound() {
        assertThat(dictionary.search("bad"), is(true));
    }
    
    @Test
    public void testFindFoundWithDotPrefix() {
        assertThat(dictionary.search(".ad"), is(true));
    }
    
    @Test
    public void testFindFoundWithDotSuffix() {
        assertThat(dictionary.search("b.."), is(true));
    }
    
    @Test
    public void testFindNotFoundWithDot() {
        assertThat(dictionary.search("p.d"), is(false));
    }
    
    @Test
    public void testFindFoundWithDotMiddle() {
        assertThat(dictionary.search("b.d"), is(true));
    }
}
