package com.zhentao.review.facebook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给一个包含字符串的数组，然后要求找到这个数组里面所有符合某个pattern的字符串， pattern是"A.B.C.",
 * 这里面每个“.”对应任意一个字符，字符串“ADBECF"符合，但是“ABECF”就不符合
 *
 * @author zhentao.li
 *
 */
public class PatternSearch {
    public static void main(String[] args) {
        int i = 0;
        while (i++ < 10) {
            if (i == 5) {
                continue;
            }
            System.out.println(i);

        }
        PatternSearch ps = new PatternSearch();
        System.out.println(ps.search(new String[] {"ADBECF", "ABECF"}, "A.B.C."));
    }
    public List<String> search(String[] words, String pattern) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.add(word);
        }

        return trie.search(pattern);
    }
    private static class TrieNode {
        boolean isWord;
        Map<Character, TrieNode> children;
        String word;

        TrieNode() {
            children = new HashMap<>();
        }
    }

    private static class Trie {
        TrieNode root;

        Trie() {
            root = new TrieNode();
        }

        void add(String word) {
            TrieNode node = root;
            for (char ch : word.toCharArray()) {
                if (!node.children.containsKey(ch)) {
                    node.children.put(ch, new TrieNode());
                }
                node = node.children.get(ch);
            }
            node.isWord = true;
            node.word = word;
        }

        List<String> search(String pattern) {

            List<String> result = new ArrayList<>();
            search(pattern, result, root);
            return result;
        }

        void search(String pattern, List<String> result, TrieNode node) {
            if (pattern.length() == 0) {
                if (node.isWord) {
                    result.add(node.word);
                }
                return;
            }
            char ch = pattern.charAt(0);
            if (ch == '.') {
                for (TrieNode child : node.children.values()) {
                    search(pattern.substring(1), result, child);
                }
            } else if (node.children.containsKey(ch)) {
                search(pattern.substring(1), result, node.children.get(ch));
            }
        }
    }
}
