package com.zhentao.review.amazon;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
public class MostCommonWordTest {
    @Test
    public void test() {
        final MostCommonWord mostCommon = new MostCommonWord();
        assertThat("a, b,' c".split("\\W+"), is(new String[] {"a", "b", "c"}));
        assertThat(mostCommon.mostCommonWord("Bob", new String[] {}), is("bob"));
    }
}
