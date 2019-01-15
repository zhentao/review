package com.zhentao.review.google;

import java.util.HashMap;
import java.util.Set;

/**
 * <b>This is not from leetcode</b>
 * Given a word, and a dictionary, ask if a word is smash able? That is, you can
 * smash one letter each time, and the rest of the letters can form a single
 * word (the new word is still in the map) until it is completely hit. For
 * example: sprint -> print -> pint -> pit -> it -> i -> ""
 * 
 * @author zhentao
 *
 */
public class SmashableWords {
    public static boolean isSmashable(String input, Set<String> dictionary) {
        HashMap<String, Boolean> visited = new HashMap<>();
        return isSmashable(input, dictionary, visited);
    }

    private static boolean isSmashable(String input, Set<String> dictionary, HashMap<String, Boolean> visited) {
        int length = input.length();
        if (length == 0) {
            return true;
        }
        if (dictionary.contains(input)) {
            if (!visited.containsKey(input)) {

                for (int i = 0; i < length; i++) {
                    String word = input.substring(0, i) + input.substring(i + 1, length);
                    boolean result = isSmashable(word, dictionary, visited);
                    visited.put(word, result);
                    if (result) {
                        return true;
                    }
                }
            } else {
                return visited.get(input);
            }
        }
        return false;
    }
}
