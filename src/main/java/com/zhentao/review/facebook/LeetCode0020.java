package com.zhentao.review.facebook;

import java.util.Stack;

/**
 * <b>20. Valid Parentheses</b>
 * Given a string s containing just the characters
 * '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * <pre>
An input string is valid if:

    Open brackets must be closed by the same type of brackets.
    Open brackets must be closed in the correct order.

Example 1:

Input: s = "()"
Output: true

Example 2:

Input: s = "()[]{}"
Output: true

Example 3:

Input: s = "(]"
Output: false

Example 4:

Input: s = "([)]"
Output: false

Example 5:

Input: s = "{[]}"
Output: true

Constraints:

    1 <= s.length <= 10^4
    s consists of parentheses only '()[]{}'.
 * </pre>
 *
 * @author zhentao.li
 *
 */
public class LeetCode0020 {
    public static void main(String[] args) {
        LeetCode0020 lc = new LeetCode0020();
        System.out.println(lc.isValid("()[]{}"));
    }
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '[' || ch == '(' || ch == '{') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                if (ch == ']') {
                    if (stack.pop() != '[') {
                        return false;
                    }
                } else if (ch == ')') {
                    if (stack.pop() != '(') {
                        return false;
                    }
                } else {
                    if (stack.pop() != '{') {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }
}
