package com.zhentao.review;

import java.util.HashMap;
import java.util.HashSet;

/**
 * <b>211. Add and Search Word - Data structure design</b>
 * <pre>
 * Design a data structure that supports the following two operations:

void addWord(word)
bool search(word)
search(word) can search a literal word or a regular expression string containing only letters a-z or .. A
. means it can represent any one letter.

Example:

addWord("bad")
addWord("dad")
addWord("mad")
search("pad") -> false
search("bad") -> true
search(".ad") -> true
search("b..") -> true
Note:
You may assume that all words are consist of lowercase letters a-z
 * </pre>
 * @author zhentao
 *
 */
public class WordDictionary {
    //Key: word length, value a set of word with the same length
    private HashMap<Integer, HashSet<String>> dictionary;

    public WordDictionary() {
        dictionary = new HashMap<>();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        int length = word.length();
        if (!dictionary.containsKey(length)) {
            HashSet<String> set = new HashSet<>();
            set.add(word);
            dictionary.put(length, set);
        } else {
            dictionary.get(length).add(word);
        }
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        int length = word.length();
        if (!dictionary.containsKey(length)) {
            return false;
        }
        HashSet<String> set = dictionary.get(length);
        if (set.contains(word)) {
            return true;
        }

        for (String dict : set) {
            boolean found = true;
            for (int i = 0; i < length; i++) {
                if (word.charAt(i) != '.' && word.charAt(i) != dict.charAt(i)) {
                    found = false;
                    break;
                }
            }
            if (found) {
                return true;
            }
        }
        return false;
    }
}
