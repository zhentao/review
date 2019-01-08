package com.zhentao.review;

import java.util.HashMap;

public class WordDictionaryTrie {
    private TrieNode root;

    public WordDictionaryTrie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void addWord(String word) {
        root.insert(word);
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        return root.search(word);
    }

    private static class TrieNode {
        HashMap<Character, TrieNode> children = new HashMap<>();
        boolean isWord;

        void insert(String word) {
            TrieNode node = this;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                // int index = c - 'a';
                if (!node.children.containsKey(c)) {
                    node.children.put(c, new TrieNode());
                }
                node = node.children.get(c);
            }
            node.isWord = true;
        }

        boolean search(String word) {
            TrieNode node = findNode(word, 0, this);
            return node != null && node.isWord;
        }

        private TrieNode findNode(String word, int k, TrieNode node) {
            if (k == word.length()) {
                if (node.isWord) {
                    return node;
                } else {
                    return null;
                }
            }
            char c = word.charAt(k);
            // int index = c - 'a';
            if (c != '.') {
                if (!node.children.containsKey(c)) {
                    return null;
                } else {
                    return findNode(word, k + 1, node.children.get(c));
                }
            } else {
                for (TrieNode node2 : node.children.values()) {
                    TrieNode result = findNode(word, k + 1, node2);
                    if (result != null && result.isWord) {
                        return result;
                    }
                }
            }

            return null;
        }
    }
}
