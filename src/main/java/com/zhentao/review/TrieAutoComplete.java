package com.zhentao.review;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * <b>642. Design Search Autocomplete System</b>
 * 
 * <pre>
 * Design a search autocomplete system for a search engine. Users may input a sentence 
 * (at least one word and end with a special character '#'). For each character they type 
 * except '#', you need to return the top 3 historical hot sentences that have prefix the 
 * same as the part of sentence already typed. Here are the specific rules:

The hot degree for a sentence is defined as the number of times a user typed the exactly 
same sentence before.

The returned top 3 hot sentences should be sorted by hot degree (The first is the hottest one). 
If several sentences have the same degree of hot, you need to use ASCII-code order (smaller one 
appears first).

If less than 3 hot sentences exist, then just return as many as you can.

When the input is a special character, it means the sentence ends, and in this case, you need to 
return an empty list.

Your job is to implement the following functions:

The constructor function:

AutocompleteSystem(String[] sentences, int[] times): This is the constructor. The input is historical 
data. Sentences is a string array consists of previously typed sentences. Times is the corresponding 
times a sentence has been typed. Your system should record these historical data.

Now, the user wants to input a new sentence. The following function will provide the next character 
the user types:

List<String> input(char c): The input c is the next character typed by the user. The character will 
only be lower-case letters ('a' to 'z'), blank space (' ') or a special character ('#'). Also, the 
previously typed sentence should be recorded in your system. The output will be the top 3 historical 
hot sentences that have prefix the same as the part of sentence already typed.

 

Example:
Operation: AutocompleteSystem(["i love you", "island","ironman", "i love leetcode"], [5,3,2,2]) 
The system have already tracked down the following sentences and their corresponding times: 
"i love you" : 5 times 
"island" : 3 times 
"ironman" : 2 times 
"i love leetcode" : 2 times 
Now, the user begins another search: 

Operation: input('i') 
Output: ["i love you", "island","i love leetcode"] 
Explanation: 
There are four sentences that have prefix "i". Among them, "ironman" and "i love leetcode" have same hot degree. Since ' ' has ASCII code 32 and 'r' has ASCII code 114, "i love leetcode" should be in front of "ironman". Also we only need to output top 3 hot sentences, so "ironman" will be ignored. 

Operation: input(' ') 
Output: ["i love you","i love leetcode"] 
Explanation: 
There are only two sentences that have prefix "i ". 

Operation: input('a') 
Output: [] 
Explanation: 
There are no sentences that have prefix "i a". 

Operation: input('#') 
Output: [] 
Explanation: 
The user finished the input, the sentence "i a" should be saved as a historical sentence in system. 
And the following input will be counted as a new search. 

 

Note:

The input sentence will always start with a letter and end with '#', and only one blank space will exist 
between two words.
The number of complete sentences that to be searched won't exceed 100. The length of each sentence including 
those in the historical data won't exceed 100.
Please use double-quote instead of single-quote when you write test cases even for a character input.
Please remember to RESET your class variables declared in class AutocompleteSystem, as static/class variables 
are persisted across multiple test cases. Please see here for more details.
 * </pre>
 * 
 * @author zhentao
 *
 */
public class TrieAutoComplete {
    public static final int TOP_K = 3;
    private final TrieNode root;

    private StringBuilder builder = new StringBuilder();
    private TrieNode cursorNode = null;

    public TrieAutoComplete(final String[] sentences, final int[] times) {
        root = new TrieNode();
        for (int i = 0; i < sentences.length; i++) {
            root.insert(sentences[i], times[i]);
        }
    }

    public List<String> input(final char c) {
        if (c == '#') {
            root.insert(builder.toString());
            cursorNode = null;
            builder = new StringBuilder();
            return Collections.emptyList();
        }

        builder.append(c);
        if (cursorNode == null) {
            cursorNode = root;
        }
        //move the cursor to next node for input c
        cursorNode = cursorNode.findNode(String.valueOf(c));
        if (cursorNode == null) {
            return Collections.emptyList();
        }
        return cursorNode.autoComplete(TOP_K);
    }

    static class TrieNode {
        HashMap<Character, TrieNode> children;
        String leafWord;
        int count;

        TrieNode() {
            children = new HashMap<>();
            count = 0;
        }

        boolean isWord() {
            return leafWord != null;
        }
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
                if (!node.children.containsKey(c)) {
                    node.children.put(c, new TrieNode());
                }
                node = node.children.get(c);
            }
            node.leafWord = word;
            node.count += count;
        }

        TrieNode findNode(final String word) {
            TrieNode node = this;
            for (int i = 0; i < word.length(); i++) {
                final char c = word.charAt(i);
                if (!node.children.containsKey(c)) {
                    return null;
                }
                node = node.children.get(c);
            }
            return node;
        }

        /**
         * return top K results
         * 
         * @param k
         * @return a list with k words
         */
        List<String> autoComplete(final int k) {
            final PriorityQueue<TrieNode> queue = new PriorityQueue<>((a, b) -> {
                if (a.count != b.count) {
                    return a.count - b.count;
                } else {
                    return b.leafWord.compareTo(a.leafWord);
                }
            });
            this.autoComplete(queue, k);
            final LinkedList<String> list = new LinkedList<>();
            while (!queue.isEmpty()) {
                list.addFirst(queue.poll().leafWord);
            }
            return list;
        }

        /**
         * 
         * @param queue
         * @param k
         */
        private void autoComplete(final PriorityQueue<TrieNode> queue, final int k) {
            if (isWord()) {
                queue.add(this);
                if (queue.size() > k) {
                    queue.poll();
                }
            }
            for (final TrieNode child : children.values()) {
                child.autoComplete(queue, k);
            }
        }
    }
}
