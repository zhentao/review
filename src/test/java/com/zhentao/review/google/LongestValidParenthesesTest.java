package com.zhentao.review.google;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class LongestValidParenthesesTest {
    @Test
    public void test() {
        LongestValidParentheses longest = new LongestValidParentheses();
        
        String input = "))";
        assertThat(longest.longestValidParentheses(input), is(0));
        
        input = "()";
        assertThat(longest.longestValidParentheses(input), is(2));
        
        input = "((";
        assertThat(longest.longestValidParentheses(input), is(0));
        
        input = "(()";
        assertThat(longest.longestValidParentheses(input), is(2));
        
        input = ")()())";
        assertThat(longest.longestValidParentheses(input), is(4));
        
        input = ")()())()(())";
        assertThat(longest.longestValidParentheses(input), is(6));
        
        input = "()(()";
        assertThat(longest.longestValidParentheses(input), is(2));
        
        input = "(())(()";
        assertThat(longest.longestValidParentheses(input), is(4));
    }
}
