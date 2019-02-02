package com.zhentao.review;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

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

    private final TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(final String word) {
        root.insert(word);
    }

    public void insert(final String word, final int count) {
        root.insert(word, count);
    }

    /** Returns if the word is in the trie. */
    public boolean search(final String word) {
        return root.search(word);
    }

    public TrieNode find(final String prefix, TrieNode startNode) {
        if (startNode == null) {
            startNode = root;
        }
        return startNode.findNode(prefix);
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(final String prefix) {
        return root.startsWith(prefix);
    }

    public List<String> autoComplete(final String prefix) {
        return root.autoComplete(prefix);
    }

//    public List<String> autoComplete(String prefix, int k) {
//        return root
//    }
    static class TrieNode {
        HashMap<Character, TrieNode> children = new HashMap<>();
        boolean isWord;
        String leafWord;
        int count;

        @Override
        public String toString() {
            return "count=" + count + " word=" + leafWord;
        }

        void insert(final String word) {
            insert(word, 1);
        }

        void insert(final String word, final int count) {
            TrieNode node = this;
            for (int i = 0; i < word.length(); i++) {
                final char c = word.charAt(i);
                // int index = c - 'a';
                if (!node.children.containsKey(c)) {
                    node.children.put(c, new TrieNode());
                }
                node = node.children.get(c);
            }
            node.isWord = true;
            node.leafWord = word;
            node.count = count;
        }

        boolean search(final String word) {
            final TrieNode node = findNode(word);
            return node != null && node.isWord;
        }

        TrieNode findNode(final String word) {
            TrieNode node = this;
            for (int i = 0; i < word.length(); i++) {
                final char c = word.charAt(i);
                // int index = c - 'a';
                if (!node.children.containsKey(c)) {
                    return null;
                }
                node = node.children.get(c);
            }
            return node;
        }

        boolean startsWith(final String prefix) {
            final TrieNode node = findNode(prefix);
            return node != null;
        }

        ArrayList<String> autoComplete(final String prefix) {
            final ArrayList<String> list = new ArrayList<>();
            final TrieNode node = findNode(prefix);
            if (node != null) {
                node.autoComplete(list);
            }
            return list;
        }

        void autoComplete(final List<String> list) {
            if (isWord) {
                list.add(this.leafWord);
            }
            for (final TrieNode child : children.values()) {
                child.autoComplete(list);
            }
        }

        List<String> autoCompleteWithTopK(final int k) {
            final PriorityQueue<TrieNode> queue = new PriorityQueue<>((a, b) -> {
                if (a.count != b.count) {
                    return a.count - b.count;
                } else {
                    return b.leafWord.compareTo(a.leafWord);
                }
            });
            this.autoCompleteWithTopK(queue, k);
            final LinkedList<String> list = new LinkedList<>();
            while (!queue.isEmpty()) {
                list.addFirst(queue.poll().leafWord);
            }
            return list;
        }

        /**
         * return top k
         * 
         * @param list
         * @param topK
         */
        private void autoCompleteWithTopK(final PriorityQueue<TrieNode> queue, final int k) {
            if (isWord) {
                queue.add(this);
                if (queue.size() > k) {
                    queue.poll();
                }
            }
            for (final TrieNode child : children.values()) {
                child.autoCompleteWithTopK(queue, k);
            }
        }
    }
}
