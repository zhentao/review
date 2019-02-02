package com.zhentao.review.google;

import java.util.HashMap;
import java.util.Map;

/**
 * 给一个string，相邻两个字母如果分别是同个字母的大小写，就删掉这个pair。example： aBbA 返回aA. 然后follow
 * up是可以递归消除 aBbA 返回“”.
 * 
 * @author zhentao
 *
 */
public class DeletePair {
    public static void main(final String[] args) {
        String input = "AabBbcAaA";
        System.out.println(new DeletePair().delete(input));
        
        input = "AbBabcAaA";
        System.out.println(recursiveDelete(input));
    }

    static final Map<Character, Character> map = new HashMap<>() {
        private static final long serialVersionUID = 1L;
        {
            put('a', 'A');
            put('b', 'B');
            put('A', 'a');
            put('B', 'b');
        }
    };

    public String delete(final String input) {
        final StringBuilder builder = new StringBuilder();
        builder.append(input.charAt(0));
        boolean deleted = false;
        for (int i = 1; i < input.length(); i++) {
            final Character ch = input.charAt(i);
            if (!deleted && (ch.equals(map.get(input.charAt(i - 1)))
                    || map.getOrDefault(input.charAt(i - 1), '0').equals(ch))) {
                builder.deleteCharAt(builder.length() - 1);
                deleted = true;
            } else {
                builder.append(ch);
                deleted = false;
            }
        }
        return builder.toString();
    }

    /**
     * 然后follow up是可以递归消除 aBbA 返回“”.
     * 
     * @return
     */
    public static String recursiveDelete(final String input) {
        final StringBuilder builder = new StringBuilder();
        builder.append(input.charAt(0));

        for (int i = 1; i < input.length(); i++) {
            final Character ch = input.charAt(i);
            final int length = builder.length();
            if (length > 0 && (ch.equals(map.get(builder.charAt(length - 1)))
                    || map.getOrDefault(builder.charAt(length - 1), '0').equals(ch))) {
                builder.deleteCharAt(length - 1);
            } else {
                builder.append(ch);
            }
        }
        return builder.toString();
    }
}
