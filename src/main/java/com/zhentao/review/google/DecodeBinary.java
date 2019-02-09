package com.zhentao.review.google;

import java.util.Map;

/**
 * 给定一系列字符到二进制字符串的唯一mapping: {'a' : '00', 'b': '0101', 'c': '0111', 'd': '0100',
 * 'e': '01'}, 再给定一个encode好的二进制字符串例如"01010111010001", 求其decode的字符串， 此例为'bcde'.
 * 给出任意一种decode即可。 楼主选择先根据所有二进制字符串构建Trie, 然后用DFS找出可行解。
 * 
 * @author zhentao
 *
 */
public class DecodeBinary {
    public String decode(final String binary, final Map<String, Character> map) {
        final StringBuilder builder = new StringBuilder();
        final boolean result = dfs(binary, map, 0, binary.length(), builder);
        if (result)
            return builder.toString();
        else
            return "";

    }

    boolean dfs(final String binary, final Map<String, Character> map, final int start, final int length,
            final StringBuilder builder) {
        if (start >= length) {
            return true;
        }

        boolean valid = false;

        if (start + 2 <= length) {
            final String s2 = binary.substring(start, start + 2);

            if (map.containsKey(s2)) {
                valid = true;
                builder.append(map.get(s2));
                if (dfs(binary, map, start + 2, length, builder)) {
                    return true;
                }
            }
        }
        if (start + 4 <= length) {
            final String s4 = binary.substring(start, start + 4);
            if (map.containsKey(s4)) {
                valid = true;
                builder.append(map.get(s4));
                if (dfs(binary, map, start + 4, length, builder)) {
                    return true;
                }
            }
        }

        if (!valid) {
            builder.delete(builder.length() - 1, builder.length());
        }
        return false;
    }
}
