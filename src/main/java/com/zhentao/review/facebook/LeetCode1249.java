package com.zhentao.review.facebook;

import java.util.Stack;

/**
 * <b>1249. Minimum Remove to Make Valid Parentheses</b> Given a string s of '('
 * , ')' and lowercase English characters.
 *
 * Your task is to remove the minimum number of parentheses ( '(' or ')', in any
 * positions ) so that the resulting parentheses string is valid and return any
 * valid string.
 *
 * <pre>
Formally, a parentheses string is valid if and only if:

    It is the empty string, contains only lowercase characters, or
    It can be written as AB (A concatenated with B), where A and B are valid strings, or
    It can be written as (A), where A is a valid string.

Example 1:

Input: s = "lee(t(c)o)de)"
Output: "lee(t(c)o)de"
Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.

Example 2:

Input: s = "a)b(c)d"
Output: "ab(c)d"

Example 3:

Input: s = "))(("
Output: ""
Explanation: An empty string is also valid.

Example 4:

Input: s = "(a(b(c)d)"
Output: "a(b(c)d)"

Constraints:

    1 <= s.length <= 10^5
    s[i] is one of  '(' , ')' and lowercase English letters.
 * </pre>
 *
 * @author zhentao.li
 *
 */
public class LeetCode1249 {
    public static void main(String[] args) {
        String s = "a)b(c)d";
        System.out.println(new LeetCode1249().minRemoveToMakeValid(s));
    }

    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if ('(' == arr[i]) {
                stack.push(i);
            } else if (')' == arr[i]) {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    arr[i] = '0';
                }
            }
        }
        while (!stack.isEmpty()) {
            arr[stack.pop()] = '0';
        }

        StringBuilder builder = new StringBuilder();
        for (char c : arr) {
            if (c != '0') {
                builder.append(c);
            }
        }
        return builder.toString();
    }
}
