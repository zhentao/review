package com.zhentao.review.google;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class SmashableWordsTest {
    private SmashableWords smashable;
    @Before
    public void setup() {
        smashable = new SmashableWords();
    }
    @Test
    public void testTrue() {
        final Set<String> dictionary = Set.of(new String[] { "sprint", "print", "pint", "pin", "in", "i" });
        
        assertThat(smashable.isSmashable("sprint", dictionary), is(true));
    }
    
    @Test
    public void testFalse() {
        final Set<String> dictionary = Set.of(new String[] { "sprint", "print", "pint", "pin", "in" });

        assertThat(smashable.isSmashable("sprint", dictionary), is(false));
    }
    
    @Test
    public void testLongestPath() {
        final Set<String> dictionary = Set.of(new String[] { "sprint", "print", "pint", "pin", "in", "i" });

        assertThat(smashable.findLongestPath(dictionary), is("sprint"));
    }
}
