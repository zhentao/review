package com.zhentao.review.google;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class BackspaceStringCompareTest {
    
    private BackspaceStringCompare backspace;
    @Before
    public void setup() {
        backspace = new BackspaceStringCompare();
    }
    
    @Test
    public void tes() {
        
        String s = "ab#c";
        String t = "ad#c";
        assertThat(backspace.compare2(s, t), is(true));
        
        s = "ab##";
        t = "c#d#";
        assertThat(backspace.compare2(s, t), is(true));
        
        s = "a##c";
        t = "#a#c";
        assertThat(backspace.compare2(s, t), is(true));
        
        s = "a#c";
        t = "b";
        assertThat(backspace.compare2(s, t), is(false));
        
        s = "ab###";
        t = "c#d#";
        assertThat(backspace.compare2(s, t), is(true));
        
        s = "abcde###f";
        t = "abf";
        assertThat(backspace.compare2(s, t), is(true));
        
    }
}
