package com.zhentao.review.facebook;

import java.util.Stack;

/**
 * <b>1047. Remove All Adjacent Duplicates In String</b>
 *
 * Given a string S of lowercase letters, a duplicate removal consists of
 * choosing two adjacent and equal letters, and removing them.
 *
 * We repeatedly make duplicate removals on S until we no longer can.
 *
 * Return the final string after all such duplicate removals have been made. It
 * is guaranteed the answer is unique.
 *
 *
 * <pre>
Example 1:

Input: "abbaca"
Output: "ca"
Explanation:
For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal,
and this is the only possible move.  The result of this move is that the string is "aaca",
of which only "aa" is possible, so the final string is "ca".

Note:

    1 <= S.length <= 20000
    S consists only of English lowercase letters.
 *
 * </pre>
 *
 * @author zhentao.li
 *
 */
public class LeetCode1047 {
    public static void main(String[] args) {
        LeetCode1047 lc = new LeetCode1047();
        System.out.println(lc.removeDuplicates("abbaca"));
    }

    public String removeDuplicates2(String S) {
        Stack<Character> stack = new Stack<>();
        for (char ch : S.toCharArray()) {
            if (stack.isEmpty() || stack.peek() != ch) {
                stack.push(ch);
            } else {
                stack.pop();
            }
        }
        StringBuilder builder = new StringBuilder();
        for (char ch : stack) {
            builder.append(ch);
        }
        return builder.toString();
    }


    public String removeDuplicates(String S) {
        Stack<Character> stack = new Stack<>();
        for (char ch : S.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == ch) {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        StringBuilder builder = new StringBuilder();
        for (char ch : stack) {
            builder.append(ch);
        }

        return builder.toString();
    }

    public String removeDuplicatesNoStack(String S) {
        StringBuilder builder = new StringBuilder();
        for (char ch : S.toCharArray()) {
            if (builder.length() > 0 && builder.charAt(builder.length()-1) == ch) {
                builder.deleteCharAt(builder.length()-1);
            } else {
                builder.append(ch);
            }
        }

        return builder.toString();
    }
}
