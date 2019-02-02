package com.zhentao.review.leetcode;

import java.util.HashMap;

/**
 * <b>205. Isomorphic Strings</b>
 * 
 * <pre>
 * Given two strings s and t, determine if they are isomorphic.

Two strings are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.

Example 1:

Input: s = "egg", t = "add"
Output: true
Example 2:

Input: s = "foo", t = "bar"
Output: false
Example 3:

Input: s = "paper", t = "title"
Output: true
Note:
You may assume both s and t have the same length.
 * </pre>
 * 
 * @author zhentao
 *
 */
public class IsomorphicStrings {
    public boolean isIsomorphic(final String s, final String t) {
        if (s == null) {
            return true;
        }
        final int length = s.length();
        if (length == 0) {
            return true;
        }
        final HashMap<Character, Character> sToT = new HashMap<>();
        final HashMap<Character, Character> tToS = new HashMap<>();
        for (int i = 0; i < length; i++) {
            final char sCh = s.charAt(i);
            final char tCh = t.charAt(i);
            if (sToT.containsKey(sCh) && sToT.get(sCh) != tCh) {
                return false;
            } else {
                sToT.put(sCh, tCh);
            }
            
            if (tToS.containsKey(tCh) && tToS.get(tCh) != sCh) {
                return false;
            } else {
                tToS.put(tCh, sCh);
            }
        }
        return true;
    }
}
