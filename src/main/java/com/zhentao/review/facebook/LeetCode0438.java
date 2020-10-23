package com.zhentao.review.facebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 438. Find All Anagrams in a String Medium
 *
 * Given a string s and a non-empty string p, find all the start indices of p's
 * anagrams in s.
 *
 * Strings consists of lowercase English letters only and the length of both
 * strings s and p will not be larger than 20,100.
 *
 * The order of output does not matter.
 *
 * Example 1:
 *
 * Input: s: "cbaebabacd" p: "abc"
 *
 * Output: [0, 6]
 *
 * Explanation: The substring with start index = 0 is "cba", which is an anagram
 * of "abc". The substring with start index = 6 is "bac", which is an anagram of
 * "abc".
 *
 * Example 2:
 *
 * Input: s: "abab" p: "ab"
 *
 * Output: [0, 1, 2]
 *
 * Explanation: The substring with start index = 0 is "ab", which is an anagram
 * of "ab". The substring with start index = 1 is "ba", which is an anagram of
 * "ab". The substring with start index = 2 is "ab", which is an anagram of
 * "ab".
 *
 * @author zhentao.li
 *
 */
public class LeetCode0438 {
    public static void main(String[] args) {
        //System.out.println(new LeetCode0438().find("cbaebabacd", "abc"));
        System.out.println(new LeetCode0438().find("abab", "ab"));
    }

    public List<Integer> find(String s, String p) {
        if (p.length() > s.length()) {
            return Collections.emptyList();
        }
        List<Integer> res = new ArrayList<>();
        char[] pArray = p.toCharArray();
        Arrays.sort(pArray);
        for (int i = 0; i < s.length()-p.length()+1; i++) {
            char[] array = s.substring(i, i+p.length()).toCharArray();
            Arrays.sort(array);
            if (equals(pArray, array)) {
                res.add(i);
            }
        }
        return res;

    }

    boolean equals(char[] a, char[] b) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }

    public List<Integer> findAnagrams(String s, String p) {
        if (p.length() > s.length()) {
            return Collections.emptyList();
        }
        Map<Character, Integer> pMap = new HashMap<>();
        Map<Character, Integer> sMap = new HashMap<>();

        for (int i = 0; i < p.length(); i++) {
            Character ch = p.charAt(i);
            pMap.put(ch, pMap.getOrDefault(ch, 0) + 1);
            ch = s.charAt(i);
            sMap.put(ch, sMap.getOrDefault(ch, 0)+1);
        }
        List<Integer> result = new ArrayList<>();
        if (check(pMap, sMap)) {
            result.add(0);
        }
        for (int i = p.length(); i < s.length(); i++) {
            Character removed = s.charAt(i-p.length());
            sMap.put(removed, sMap.get(removed)-1);
            if (sMap.get(removed) == 0) {
                sMap.remove(removed);
            }
            Character newCh = s.charAt(i);
            sMap.put(newCh, sMap.getOrDefault(newCh, 0)+1);
            if (check(pMap, sMap)) {
                result.add(i-p.length()+1);
            }

        }
        return result;
    }

    boolean check(Map<Character, Integer> m1, Map<Character, Integer> m2) {
        if (m1.keySet().size() != m2.keySet().size()) {
            return false;
        }
        for (Map.Entry<Character, Integer> entry : m1.entrySet()) {
            //intValue is required for very large integer because JVM creates new copies of the same integer.
            if (m2.getOrDefault(entry.getKey(), -1).intValue() != entry.getValue().intValue()) {
                return false;
            }
        }
        return true;
    }
}
