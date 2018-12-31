package com.zhentao.review.cracking;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * <b>17.17 Multi Search</b>
 * 
 * <pre>
 * Given a string b and an array of smaller strings T, design a method to search b for
each small string in T.
 * </pre>
 * 
 * @author zhentao
 *
 */
public class MultiSearch {
    public static void main(String[] args) {
        String str = "bibs";
        Trie trie = new Trie(str);
        // String[] smalls = {"bi", "ibs", "bb"};
        ArrayList<Integer> search = new ArrayList<>(trie.search("b"));
        adjustLocations(search, 1);
        System.out.println(search);
        System.out.println(trie.search("b"));
    }

    public static void adjustLocations(ArrayList<Integer> locations, int strLength) {
        if (locations != null) {
            for (int i = 0; i < locations.size(); i++) {
                locations.set(i, locations.get(i) - strLength);
            }
        }
    }
}

class TrieNode {
    private HashMap<Character, TrieNode> children;
    private ArrayList<Integer> indexes;

    public TrieNode() {
        children = new HashMap<>();
        indexes = new ArrayList<>();
    }

    public void insertString(String s, int index) {
        indexes.add(index);
        if (s != null && s.length() > 0) {
            char value = s.charAt(0);

            TrieNode child = null;
            if (children.containsKey(value)) {
                child = children.get(value);
            } else {
                child = new TrieNode();
                children.put(value, child);
            }
            String reminder = s.substring(1);
            child.insertString(reminder, index + 1);
        } else {
            children.put('\0', null);// terminate character
        }
    }

    public ArrayList<Integer> search(String s) {
        if (s == null || s.length() == 0) {
            return indexes;
        } else {
            char first = s.charAt(0);
            if (children.containsKey(first)) {
                String remainder = s.substring(1);
                return children.get(first).search(remainder);
            } else {
                return null;
            }
        }
    }

    public boolean terminates() {
        return children.containsKey('\0');
    }

    public TrieNode getChild(char c) {
        return children.get(c);
    }
}

class Trie {
    private TrieNode root;

    public Trie(String s) {
        this();
        build(s);
    }

    public Trie() {
        root = new TrieNode();
    }

    public ArrayList<Integer> search(String s) {
        return root.search(s);
    }

    public void build(String s) {
        for (int i = 0; i < s.length(); i++) {
            String suffix = s.substring(i);
            root.insertString(suffix, i);
        }
    }

    public TrieNode getRoot() {
        return root;
    }
}
