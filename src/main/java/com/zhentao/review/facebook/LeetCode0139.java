package com.zhentao.review.facebook;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <b>139. Word Break</b> Medium
 *
 * Given a non-empty string s and a dictionary wordDict containing a list of
 * non-empty words, determine if s can be segmented into a space-separated
 * sequence of one or more dictionary words.
 *
 * <pre>
Note:

    The same word in the dictionary may be reused multiple times in the segmentation.
    You may assume the dictionary does not contain duplicate words.

Example 1:

Input: s = "leetcode", wordDict = ["leet", "code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".

Example 2:

Input: s = "applepenapple", wordDict = ["apple", "pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
             Note that you are allowed to reuse a dictionary word.

Example 3:

Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
Output: false
 * </pre>
 *
 * @author zhentao.li
 *
 */
public class LeetCode0139 {
    public static void main(String[] args) {
        LeetCode0139 lc = new LeetCode0139();

        List<String> wordDict = Arrays.asList("cats", "dog", "sand", "and", "cat");
        String s = "catsandog";
        System.out.println(lc.wordBreak(s, wordDict));

        wordDict = Arrays.asList("apple", "pen");
        s = "applepenapple";
        System.out.println(lc.wordBreak(s, wordDict));
    }

    public boolean wordBreak1(String s, List<String> wordDict) {
        Map<String, Boolean> map = new HashMap<>();

        return wordBreak1(s, wordDict, map);
    }

    private boolean wordBreak1(String s, List<String> wordDict, Map<String, Boolean> map) {

        if (map.containsKey(s)) {
            return map.get(s);
        }

        for (String word : wordDict) {
            if (s.startsWith(word)) {
                if (s.equals(word)) {
                    map.put(s, true);
                    return true;
                }
                boolean result = wordBreak1(s.substring(word.length()), wordDict, map);
                if (result) {
                    map.put(s, true);
                    return true;
                }
            }
        }
        map.put(s, false);
        return false;
    }
















    public boolean wordBreak(String s, List<String> wordDict) {
        Map<String, Boolean> memo = new HashMap<>();

        return wordBreak(s, wordDict, memo);
    }

    private boolean wordBreak(String s, List<String> dict, Map<String, Boolean> memo) {
        if (memo.containsKey(s)) {
            return memo.get(s);
        }
        for (String word : dict) {
            if (s.startsWith(word)) {
                if (s.length() == word.length()) {
                    return true;
                }
                boolean result = wordBreak(s.substring(word.length()), dict, memo);
                memo.put(s, result);
                if (result) {
                    return true;
                }
            }
        }
        return false;
    }
}
