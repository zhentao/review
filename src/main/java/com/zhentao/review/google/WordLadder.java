package com.zhentao.review.google;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <b>127. Word Ladder</b>
 * 
 * <pre>
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time.
Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
Note:

Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.
Example 1:

Input:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

Output: 5

Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
                                               "hit" -> "hot" -> "dot" -> "lot" -> "log" -> "cog"
return its length 5.
Example 2:

Input:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

Output: 0

Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 * </pre>
 * 
 * @author zhentao
 *
 */
public class WordLadder {
    public static void main(String[] args) {
        int temp = 1;
        System.out.println(temp-- >=1);
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");

        int count = new WordLadder().ladderLength(beginWord, endWord, wordList);
        System.out.println(count);
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> dictionary = new HashSet<>(wordList);
        if (!dictionary.contains(endWord)) {
            return 0;
        }
        HashSet<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        visited.add(beginWord);
        int level = 1;

        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            while (queueSize-- > 0) {
                String str = queue.poll();
                int length = str.length();
                for (int i = 0; i < length; i++) {
                    char[] array = str.toCharArray();
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        array[i] = ch;
                        String word = new String(array);
                        if (word.equals(endWord)) {
                            return ++level;
                        }
                        if (dictionary.contains(word) && !visited.contains(word)) {
                            queue.add(word);
                            visited.add(word);
                        }
                    }
                }
            }
            level++;
        }
        return 0;
    }

}
