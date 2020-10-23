package com.zhentao.review.facebook;

import java.util.ArrayList;
import java.util.List;

/**
 * <b>22. Generate Parentheses</b> Given n pairs of parentheses, write a
 * function to generate all combinations of well-formed parentheses.
 *
 * <pre>
For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
 * </pre>
 *
 * @author zhentao.li
 *
 */
public class LeetCode0022 {
    public static void main(String[] args) {
        LeetCode0022 lc = new LeetCode0022();
        System.out.println(lc.generateParenthesis(3));
    }
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        backtrack(list, "", 0, 0, n);
        return list;
    }

    private void backtrack(List<String> list, String current, int open, int close, int max) {
        if (current.length() == 2 * max) {
            list.add(current);
            return;
        }
        if (open < max) {
            backtrack(list, current + "(", open+1, close, max);
        }

        if (close < open) {
            backtrack(list, current + ")", open, close+1, max);
        }
    }
}
