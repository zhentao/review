package com.zhentao.review;

import java.util.HashMap;

/**
 * <b>208. Implement Trie (Prefix Tree)</b>
 * 
 * <pre>
 * Implement a trie with insert, search, and startsWith methods.

Example:

Trie trie = new Trie();

trie.insert("apple");
trie.search("apple");   // returns true
trie.search("app");     // returns false
trie.startsWith("app"); // returns true
trie.insert("app");   
trie.search("app");     // returns true
Note:

You may assume that all inputs are consist of lowercase letters a-z.
All inputs are guaranteed to be non-empty strings.
 * </pre>
 * 
 * @author zhentao
 *
 */
public class Trie {
    
    private TrieNode root;
    
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        root.insert(word);
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        return root.search(word);
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        return root.startsWith(prefix);
    }

    private static class TrieNode {
        HashMap<Character, TrieNode> children = new HashMap<>();
        boolean isWord;
        
        void insert(String word) {
            TrieNode node = this;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                //int index = c - 'a';
                if (!node.children.containsKey(c)) {
                    node.children.put(c, new TrieNode());
                }
                node = node.children.get(c);
            }
            node.isWord = true;
        }
        
        boolean search(String word) {
            TrieNode node = findNode(word);
            return node != null && node.isWord;
        }

        private TrieNode findNode(String word) {
            TrieNode node = this;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                //int index = c - 'a';
                if (!node.children.containsKey(c)) {
                    return null;
                }
                node = node.children.get(c);
            }
            return node;
        }
        
        boolean startsWith(String prefix) {
            TrieNode node = findNode(prefix);
            return node != null;
        }
    }
}
