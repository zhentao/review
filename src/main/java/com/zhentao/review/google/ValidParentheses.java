package com.zhentao.review.google;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * <b>20. Valid Parentheses</b>
 * 
 * <pre>
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Note that an empty string is also considered valid.

Example 1:

Input: "()"
Output: true
Example 2:

Input: "()[]{}"
Output: true
Example 3:

Input: "(]"
Output: false
Example 4:

Input: "([)]"
Output: false
Example 5:

Input: "{[]}"
Output: true
 * </pre>
 * 
 * @author zhentao
 *
 */
public class ValidParentheses {
    public static void main(final String[] args) {
        System.out.println(new ValidParentheses().isValid("()"));
    }
    public boolean isValid(final String s) {
        final Map<Character, Character> map = new HashMap<>();
        map.put('{', '}');
        map.put('(', ')');
        map.put('[', ']');
        final Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            final char ch = s.charAt(i);
            if (ch == '[' || ch == '{' || ch == '(') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                final char top = stack.pop();
                if (ch != map.get(top)) {
                    return false;
                }
            }
        }
         return stack.isEmpty();
    }
}
