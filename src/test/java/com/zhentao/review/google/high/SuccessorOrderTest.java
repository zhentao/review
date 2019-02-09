package com.zhentao.review.google.high;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;

import org.junit.Test;

public class SuccessorOrderTest {
    @Test
    public void test() {
        final SuccessorOrder successor = new SuccessorOrder();
        successor.birth("king", "son1");
        assertThat(successor.getOrder(), is(Arrays.asList("king", "son1")));
        
        successor.birth("king", "son2");
        assertThat(successor.getOrder(), is(Arrays.asList("king", "son1", "son2")));
        
        successor.birth("son1", "grand11");
        assertThat(successor.getOrder(), is(Arrays.asList("king", "son1", "grand11","son2")));
        
        successor.death("son1");
        assertThat(successor.getOrder(), is(Arrays.asList("king", "grand11","son2")));
    }
}
