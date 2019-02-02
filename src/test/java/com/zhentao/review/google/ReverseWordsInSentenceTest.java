package com.zhentao.review.google;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
public class ReverseWordsInSentenceTest {
    @Test
    public void test() {
        final ReverseWordsInSentence reverse = new ReverseWordsInSentence();
        assertThat(reverse.reverseWords("sky is   blue "), is("blue is sky"));
        assertThat(reverse.reverseWords(" 1"), is("1"));
    }
}
