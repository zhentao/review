package com.zhentao.review.facebook;

import java.util.HashMap;
import java.util.Map;

/**
 * <b>953. Verifying an Alien Dictionary</b> In an alien language, surprisingly
 * they also use English lowercase letters, but possibly in a different order.
 * The order of the alphabet is some permutation of lowercase letters.
 *
 * Given a sequence of words written in the alien language, and the order of the
 * alphabet, return true if and only if the given words are sorted
 * lexicographicaly in this alien language.
 *
 * <pre>
Example 1:

Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
Output: true
Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.

Example 2:

Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
Output: false
Explanation: As 'd' comes after 'l' in this language, then words[0] > words[1], hence the
sequence is unsorted.

Example 3:

Input: words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
Output: false
Explanation: The first three characters "app" match, and the second string is shorter (in size.)
According to lexicographical rules "apple" > "app", because 'l' > '∅', where '∅' is defined as
the blank character which is less than any other character (More info).

Constraints:

    1 <= words.length <= 100
    1 <= words[i].length <= 20
    order.length == 26
    All characters in words[i] and order are English lowercase letters.
 *
 * </pre>
 *
 * @author zhentao.li
 *
 */
public class LeetCode0953 {
    public boolean isAlienSorted2(final String[] words, final String order) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i), i);
        }
        for (int i = 1; i < words.length; i++ ) {
            if (compare(words[i-1], words[i], map) > 0) {
                return false;
            }
        }
        return true;
    }

    private int compare(String word1, String word2, Map<Character, Integer> order) {
        int len1 = word1.length();
        int len2 = word2.length();

        int minLen = Math.min(len1, len2);
        for (int i = 0; i < minLen; i++) {
            char ch1 = word1.charAt(i);
            char ch2 = word2.charAt(i);
            if (ch1 != ch2) {
                return order.get(ch1)-order.get(ch2);
            }
        }
        return len1 - len2;
    }







    public boolean isAlienSorted(final String[] words, final String order) {
        final HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i), i);
        }

        for (int i = 0; i < words.length - 1; i++) {
            if (compareTo(words[i], words[i + 1], map) > 0) {
                return false;
            }
        }
        return true;
    }

    private int compareTo(String text, String other, Map<Character, Integer> orderMap) {
        int length1 = text.length();
        int length2 = other.length();
        int length = Math.min(length1, length2);
        for (int i = 0; i < length; i++) {
            char t = text.charAt(i);
            char o = text.charAt(i);
            if (t != o) {
                return orderMap.get(t) - orderMap.get(o);
            }
        }
        return length1 - length2;
    }
}
