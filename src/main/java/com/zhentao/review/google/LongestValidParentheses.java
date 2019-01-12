package com.zhentao.review.google;

import java.util.Stack;

/**
 * <b>32. Longest Valid Parentheses</b>
 * 
 * <pre>
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

Example 1:

Input: "(()"
Output: 2
Explanation: The longest valid parentheses substring is "()"
Example 2:

Input: ")()())"
Output: 4
Explanation: The longest valid parentheses substring is "()()"
 * </pre>
 * 
 * @author zhentao
 *
 */
public class LongestValidParentheses {

    public int longestValidParentheses(String s) {
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    //The index of last ) which has no match (
                    //or in another word, the last seen extra )'s index
                    stack.push(i);
                } else {
                    max = Math.max(max, i - stack.peek());
                }
            }
        }
        return max;
    }

    
}
