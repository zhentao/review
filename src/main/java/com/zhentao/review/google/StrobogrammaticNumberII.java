package com.zhentao.review.google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * <b> 247. Strobogrammatic Number II</b>
 * 
 * <pre>
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

Find all strobogrammatic numbers that are of length = n.

For example,
Given n = 2, return ["11","69","88","96"].
 * </pre>
 * 
 * @author zhentao
 *
 */
public class StrobogrammaticNumberII {
    public static void main(final String[] args) {
        System.out.println(findStrobogrammatic(1));
        System.out.println(findStrobogrammatic(2));
        System.out.println(findStrobogrammatic(3));
        System.out.println(findStrobogrammatic(15).size());
        System.out.println(findStrobogrammatic2(15).size());
    }

    public static List<String> findStrobogrammatic(final int n) {
        if (n == 0) {
            return Collections.emptyList();
        }
        final HashMap<Character, Character> map = new HashMap<Character, Character>() {
            private static final long serialVersionUID = 1L;
            {
                put('0', '0');
                put('1', '1');
                put('8', '8');
                put('6', '9');
                put('9', '6');
            }
        };

        final HashSet<Character> set = new HashSet<>() {
            private static final long serialVersionUID = 1L;

            {
                add('0');
                add('1');
                add('8');
            }
        };
        final char[] num = new char[n];
        final int right = n - 1;
        final int left = 0;
        final ArrayList<String> list = new ArrayList<>();
        find(num, left, right, list, map, set);
        return list;
    }

    private static void find(final char[] num, final int left, final int right, final List<String> list,
            final Map<Character, Character> map, final Set<Character> set) {
        if (num[0] != '0') {
            if (left > right) {
                list.add(new String(num));
                return;
            }
            if (left == right) {
                for (final char ch : set) {
                    num[left] = ch;
                    list.add(new String(num));
                }
                return;
            }
            for (final char ch : map.keySet()) {
                num[left] = ch;
                num[right] = map.get(ch);
                find(num, left + 1, right - 1, list, map, set);
            }
        }
    }
    
    static List<String> findStrobogrammatic2(final int n) {
        return find(n, n);
    }

    private static List<String> find(final int m, final int n) {
        if (m == 0) {
            return Arrays.asList("");
        }
        if (m == 1) {
            return Arrays.asList("0", "1", "8");
        }
        
        final List<String> list = find(m-2, n);
        final List<String> result = new ArrayList<>();
        for (final String a : list) {
            if (m != n) {
                result.add("0" + a + "0");
            }
            result.add("1" + a + "1");
            result.add("6" + a + "9");
            result.add("8" + a + "8");
            result.add("9" + a + "6");
        }
        
        return result;
    }
    
    
}
