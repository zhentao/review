package com.zhentao.review.google.high;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * <b>890. Find and Replace Pattern</b>
 * 
 * <pre>
 * You have a list of words and a pattern, and you want to know which words in words matches the pattern.

A word matches the pattern if there exists a permutation of letters p so that after replacing every letter x in the pattern with p(x), we get the desired word.

(Recall that a permutation of letters is a bijection from letters to letters: every letter maps to another letter, and no two letters map to the same letter.)

Return a list of the words in words that match the given pattern. 

You may return the answer in any order.

 

Example 1:

Input: words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb"
Output: ["mee","aqq"]
Explanation: "mee" matches the pattern because there is a permutation {a -> m, b -> e, ...}. 
"ccc" does not match the pattern because {a -> c, b -> c, ...} is not a permutation,
since a and b map to the same letter.
 

Note:

1 <= words.length <= 50
1 <= pattern.length = words[i].length <= 20
 * </pre>
 * 
 * @author zhentao
 *
 */
public class FindAndReplacePattern {
    public List<String> findAndReplacePattern(final String[] words, final String pattern) {
        final List<String> list = new ArrayList<>();
        for (final String word : words) {
            if (match(word, pattern)) {
                list.add(word);
            }
        }
        return list;
    }
    private boolean match(final String word, final String pattern) {
        final int wordLength = word.length();
        if (wordLength != pattern.length()) {
            return false;
        }
        final HashMap<Character, Character> wordToPattern = new HashMap<>();
        final HashMap<Character, Character> patternToWord = new HashMap<>();
        
        
        for (int i = 0; i < wordLength; i++) {
            
            final char w = word.charAt(i);
            final char p = pattern.charAt(i);
            if (wordToPattern.containsKey(w)) {
                if (wordToPattern.get(w) != p) {
                    return false;
                }
            } else {
                wordToPattern.put(w, p);
            }
            
            if (patternToWord.containsKey(p)) {
                if (patternToWord.get(p) != w) {
                    return false;
                }
            } else {
                patternToWord.put(p, w);
            }
        }
        return true;
    }
}
