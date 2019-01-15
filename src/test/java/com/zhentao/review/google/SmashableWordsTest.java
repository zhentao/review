package com.zhentao.review.google;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Set;

import org.junit.Test;

public class SmashableWordsTest {
    @Test
    public void testTrue() {
        Set<String> dictionary = Set.of(new String[] { "sprint", "print", "pint", "pin", "in", "i" });

        assertThat(SmashableWords.isSmashable("sprint", dictionary), is(true));
    }
    
    @Test
    public void testFalse() {
        Set<String> dictionary = Set.of(new String[] { "sprint", "print", "pint", "pin", "in" });

        assertThat(SmashableWords.isSmashable("sprint", dictionary), is(false));
    }
}
