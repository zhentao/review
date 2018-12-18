package com.zhentao.review;

import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 * Length of the longest substring without repeating characters
 * </pre>
 *
 * Given a string, find the length of the longest substring without repeating characters. For
 * example, the longest substrings without repeating characters for “ABDEFGABEF” are “BDEFGA” and
 * “DEFGAB”, with length 6. For “BBBB” the longest substring is “B”, with length 1. For
 * “GEEKSFORGEEKS”, there are two longest substrings shown in the below diagrams, with length 7.
 *
 * @author zhentao.li
 *
 */
public class LongestSubstringWithoutRepeating {
    public static void main(String[] args) {
        String input = "abcabcbb";
        System.out.println(length(input));

        input = "aab";
        System.out.println(length(input));
    }

    public static int length(String input) {
        Map<Character, Integer> chars = new HashMap<>();
        int size = input.length();
        int start = 0;
        int max = 0;
        int maxLocal = 0;
        for (int i = 0; i < size; i++) {
            Character c = input.charAt(i);
            if (chars.containsKey(c)) {
                int newStart = chars.get(c) + 1;
                //this for loop can be removed.
                //However, it is easy to understand
                for (int j = start; j < newStart; j++) {
                    chars.remove(input.charAt(j));
                }
                start = newStart;
                maxLocal = i - newStart + 1;
            } else {
                maxLocal++;
            }
            chars.put(c, i);
            max = Math.max(maxLocal, max);
        }
        return max;
    }


}
