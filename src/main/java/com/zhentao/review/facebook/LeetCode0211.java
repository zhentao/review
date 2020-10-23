package com.zhentao.review.facebook;

import java.util.HashMap;
import java.util.Map;

/**
 * <b>211. Design Add and Search Words Data Structure</b> You should design a
 * data structure that supports adding new words and finding if a string matches
 * any previously added string.
 *
 * <pre>
Implement the WordDictionary class:

    WordDictionary() Initializes the object.
    void addWord(word) adds word to the data structure, it can be matched later.
    bool search(word) returns true if there is any string in the data structure that matches
    word or false otherwise. word may contain dots '.' where dots can be matched with any letter.
 * </pre>
 *
 *
 * Example:
 *
 * <pre>
Input
["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
Output
[null,null,null,null,false,true,true,true]

Explanation
WordDictionary wordDictionary = new WordDictionary();
wordDictionary.addWord("bad");
wordDictionary.addWord("dad");
wordDictionary.addWord("mad");
wordDictionary.search("pad"); // return False
wordDictionary.search("bad"); // return True
wordDictionary.search(".ad"); // return True
wordDictionary.search("b.."); // return True



Constraints:

    1 <= word.length <= 500
    word in addWord consists lower-case English letters.
    word in search consist of  '.' or lower-case English letters.
    At most 50000 calls will be made to addWord and search .
 *
 * </pre>
 *
 * @author zhentao.li
 *
 */
public class LeetCode0211 {

    public static void main(String[] args) {
        LeetCode0211 wordDictionary = new LeetCode0211();
        // ["search","search","search","search","search","search"]
        // [[".at"],["an."],["a.d."],["b."],["a.d"],["."]]
        wordDictionary.addWord("at");
        wordDictionary.addWord("and");
        wordDictionary.addWord("an");
        wordDictionary.addWord("add");
        boolean found = wordDictionary.search("a");
        System.out.println(found);
        found = wordDictionary.search(".at");
        System.out.println(found);
        wordDictionary.addWord("bat");
        found = wordDictionary.search(".at");
        System.out.println(found);
        found = wordDictionary.search("an.");
        System.out.println(found);
        found = wordDictionary.search("a.d.");
        System.out.println(found);
        found = wordDictionary.search("b.");
        System.out.println(found);
        found = wordDictionary.search("a.d");
        System.out.println(found);
        found = wordDictionary.search(".");
        System.out.println(found);
    }

    private TrieNode root;

    /** Initialize your data structure here. */
    public LeetCode0211() {
        this.root = new TrieNode();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        root.addWord(word);
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot
     * character '.' to represent any one letter.
     */
    public boolean search(String word) {
        return root.search(word, 0);
    }

    private static class TrieNode {
        Map<Character, TrieNode> children;
        boolean isWord;

        TrieNode() {
            children = new HashMap<>();
        }

        void addWord(String word) {
            TrieNode node = this;
            for (char ch : word.toCharArray()) {
                if (!node.children.containsKey(ch)) {
                    node.children.put(ch, new TrieNode());
                }
                node = node.children.get(ch);
            }
            node.isWord = true;
        }

        boolean search(String word, int start) {
            if (start == word.length()) {
                return isWord;
            }

            char ch = word.charAt(start);
            if (ch == '.') {
                for (TrieNode child : children.values()) {
                    if (child.search(word, start + 1)) {
                        return true;
                    }
                }
            } else if (children.containsKey(ch)) {
                return children.get(ch).search(word, start + 1);
            }
            return false;
        }
    }
}

/**
 * <pre>
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 * </pre>
 */
