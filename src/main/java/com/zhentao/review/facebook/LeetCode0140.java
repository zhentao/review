package com.zhentao.review.facebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 140. Word break II
 * <pre>
Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences.

Note:

    The same word in the dictionary may be reused multiple times in the segmentation.
    You may assume the dictionary does not contain duplicate words.

Example 1:

Input:
s = "catsanddog"
wordDict = ["cat", "cats", "and", "sand", "dog"]
Output:
[
  "cats and dog",
  "cat sand dog"
]

Example 2:

Input:
s = "pineapplepenapple"
wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
Output:
[
  "pine apple pen apple",
  "pineapple pen apple",
  "pine applepen apple"
]
Explanation: Note that you are allowed to reuse a dictionary word.

Example 3:

Input:
s = "catsandog"
wordDict = ["cats", "dog", "sand", "and", "cat"]
Output:
[]

</pre>
 * @author zhentao.li
 *
 */
public class LeetCode0140 {
    public static void main(String[] args) {
        LeetCode0140 wb = new LeetCode0140();
        List<String> wordDict = Arrays.asList("cat", "cats", "and", "sand", "dog");
        System.out.println(wb.wordBreak("catsanddog", wordDict));
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        Map<String, List<String>> memo = new HashMap<>();
        return wordBreak(s, wordDict, memo);
    }

    private List<String> wordBreak(String s, List<String> wordDict, Map<String, List<String>> memo) {
        if (memo.containsKey(s))
            return memo.get(s);

        List<String> res = new ArrayList<>();

        for (String word : wordDict) {
            if (s.startsWith(word)) {
                if (s.length() == word.length())
                    res.add(word);
                else {
                    List<String> sub = wordBreak(s.substring(word.length()), wordDict, memo);
                    for (String w : sub)
                        res.add(word + " " + w);
                }
            }
        }

        memo.put(s, res);
        return memo.get(s);
    }

    private List<String> myBreak(String s, List<String> dict, Map<String, List<String>> memo) {
        if (memo.containsKey(s) ) {
            return memo.get(s);
        }

        List<String> result = new ArrayList<>();

        for (String word : dict) {
            if (s.startsWith(word)) {
                if (s.length() == word.length()) {
                    result.add(word);
                } else {
                    List<String> subs = myBreak(s.substring(word.length()), dict, memo);
                    for (String sub : subs) {
                        result.add(word + " " + sub);
                    }
                }
            }
        }
        memo.put(s, result);
        return result;
    }
}
