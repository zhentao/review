package com.zhentao.review.google;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * <b>17. Letter Combinations of a Phone Number</b>
 * 
 * <pre>
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that 
 * the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does 
not map to any letters.

2 -> a,b,c
3 -> d,e,f
4 -> g,h,i
5 -> j,k,l
6 -> m,n,o
7 -> p,q,r,s
8 -> t,u,v
9 -> w,x,y,z


Example:

Input: "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Note:

Although the above answer is in lexicographical order, your answer could be in any order you want.
 * </pre>
 * 
 * @author zhentao
 *
 */
public class LetterCombinationOfAPhoneNumber {
    public List<String> letterCombinations(final String digits) {
        if (digits == null || digits.length() == 0) {
            return Collections.emptyList();
        }
        final LinkedList<String> queue = new LinkedList<>();
        final HashMap<Character, List<String>> map = new HashMap<>();
        map.put('2', Arrays.asList("a", "b", "c"));
        map.put('3', Arrays.asList("d", "e", "f"));
        map.put('4', Arrays.asList("g", "h", "i"));
        map.put('5', Arrays.asList("j", "k", "l"));
        map.put('6', Arrays.asList("m", "n", "o"));
        map.put('7', Arrays.asList("p", "q", "r", "s"));
        map.put('8', Arrays.asList("t", "u", "v"));
        map.put('9', Arrays.asList("w", "x", "y", "z"));
        queue.add("");
        String node = "";
        int size = 0;
        for (int i = 0; i < digits.length(); i++) {
            final char digit = digits.charAt(i);
            while (!queue.isEmpty()) {
                node = queue.peek();
                if (node.length() > size) {
                    size = node.length();
                    break;
                } else {
                    node = queue.pop();
                    for (final String ch : map.get(digit)) {
                        queue.add(node + ch);
                    }
                }
            }
        }
        return queue;
    }

    /**
     * example: test{1,2,3} -> test1, test2, test3 test{1,2,3}{4,5,6} -> test14
     * test15 test16 test24 test25 test26 test34 test35 test36 test(1,{2,3}} ->
     * test12, test13
     * 
     * @param input
     * @return
     */
    public List<String> letterCombinations2(final String input) {
        final LinkedList<String> queue = new LinkedList<>();
        final LinkedList<String> wildCardQueue = new LinkedList<>();
        queue.add("");
        int size = 0;
        for (int i = 0; i < input.length(); i++) {

            while (!queue.isEmpty()) {
                final int length = queue.peek().length();
                if (length > size) {
                    size = length;
                    wildCardQueue.clear();
                    break;
                } else {
                    String node = queue.pop();
                    if (!wildCardQueue.isEmpty()) {
                        for (final String s : wildCardQueue) {
                            queue.add(node + s);
                        }
                    } else {
                        char ch;
                        while (i < input.length() && (ch = input.charAt(i)) != '{') {
                            node += ch;
                            i++;
                        }
                        if (i < input.length() && input.charAt(i) == '{') {
                            i++;
                            final int start = i;
                            while ((ch = input.charAt(i)) != '}') {
                                i++;
                            }
                            for (final String s : input.substring(start, i).split(",")) {
                                wildCardQueue.add(s);
                                queue.add(node + s);
                            }

                        } else {
                            queue.add(node);
                        }
                    }
                }
            }
        }
        return queue;
    }
}
