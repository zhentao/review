package com.zhentao.review.google;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * <b>This is not from leetcode</b> Given a word, and a dictionary, ask if a
 * word is smashable? That is, you can smash one letter each time, and the rest
 * of the letters can form a single word (the new word is still in the map)
 * until it is completely hit. For example: dictionary: {"sprint", "print",
 * "pint", "pin", "in", "i"} sprint -> print -> pint -> pin -> in -> i -> ""
 * 
 * @author zhentao
 *
 */
public class SmashableWords {
    public boolean isSmashable(final String input, final Set<String> dictionary) {
        final HashSet<String> visited = new HashSet<>();
        return isSmashable(input, dictionary, visited);
    }

    private boolean isSmashable(final String input, final Set<String> dictionary, final Set<String> visited) {
        final int length = input.length();
        if (length == 0) {
            return true;
        }
        if (dictionary.contains(input)) {
            if (!visited.contains(input)) {
                for (int i = 0; i < length; i++) {
                    final String word = input.substring(0, i) + input.substring(i + 1, length);
                    final boolean result = isSmashable(word, dictionary, visited);
                    if (result) {
                        return true;
                    }
                    visited.add(word);
                }
            } else {
                return false;
            }
        }
        return false;
    }

    /**
     * 给定一个collection of string， 用里面的string寻找一条满足如下条件最长的路径 例:
     * s->sg>sig>stig>sting>string (从length 1 开始 且 下一个string添加一个字符 位置不限) 先按长度排序
     * 然后一层一层搜索即可。
     */
    public String findLongestPath(final Set<String> dictionary) {
        final String[] array = dictionary.toArray(String[]::new);
        Arrays.sort(array, (a, b) -> b.length() - a.length());
        for (final String word : array) {
            if (dfs(word, dictionary)) {
                return word;
            }
        }
        return null;
    }

    private boolean dfs(final String word, final Set<String> dictionary) {
        final int length = word.length();
        if (length == 0) {
            return true;
        }
        if (dictionary.contains(word)) {
            for (int i = 0; i < length; i++) {
                if (dfs(word.substring(0, i) + word.substring(i + 1, length), dictionary)) {
                    return true;
                }
            }
        }
        return false;
    }

}
