package com.zhentao.review.google;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <b>248. Strobogrammatic Number III</b>
 * 
 * <pre>
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

Write a function to count the total strobogrammatic numbers that exist in the range of low <= num <= high.

Example:

Input: low = "50", high = "100"
Output: 3 
Explanation: 69, 88, and 96 are three strobogrammatic numbers.
Note:
Because the range might be a large number, the low and high numbers are represented as string.
 * </pre>
 * 
 * @author zhentao
 *
 */
public class StrobogrammaticNumberIII {
    public static void main(final String[] args) {
        System.out.println(findStrobogrammatic(1));
        System.out.println(findStrobogrammatic(2));

        System.out.println(findStrobogrammatic2("0", "99"));
    }

    public int strobogrammaticInRange(final String low, final String high) {

        return 0;
    }

    public static int findStrobogrammatic(final int n) {
        if (n == 0) {
            return 0;
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
        final AtomicInteger accumulator = new AtomicInteger();
        find(num, left, right, accumulator, map, set);
        return accumulator.intValue();
    }

    private static void find(final char[] num, final int left, final int right, final AtomicInteger accumulator,
            final Map<Character, Character> map, final Set<Character> set) {
        if (num[0] != '0') {
            if (left > right) {
                accumulator.incrementAndGet();
                return;
            }
            if (left == right) {
                for (final char ch : set) {
                    num[left] = ch;
                    accumulator.incrementAndGet();
                }

                return;
            }
            for (final char ch : map.keySet()) {
                num[left] = ch;
                num[right] = map.get(ch);
                find(num, left + 1, right - 1, accumulator, map, set);
            }
        }
    }

    static int findStrobogrammatic2(final String low, final String high) {
        final AtomicInteger accumulator = new AtomicInteger();
        for (int i = low.length(); i <= high.length(); i++) {
            if (i % 2 == 0) {
                find(i, "", accumulator, low, high);
            } else {
                find(i, "0", accumulator, low, high);
                find(i, "1", accumulator, low, high);
                find(i, "8", accumulator, low, high);
            }
        }
        return accumulator.intValue();
    }

    private static void find(final int n, final String path, final AtomicInteger accumulator, final String low,
            final String high) {
        if (path.length() == n) {
            if ((n != low.length() || path.compareTo(low) >= 0) && (n != high.length() || path.compareTo(high) <= 0)) {
                accumulator.incrementAndGet();
            }
            return;
        }
        if (path.length() > n) {
            return;
        }
        if (path.length() != n - 2) {
            find(n, "0" + path + "0", accumulator, low, high);
        }
        find(n, "1" + path + "1", accumulator, low, high);
        find(n, "6" + path + "9", accumulator, low, high);
        find(n, "8" + path + "8", accumulator, low, high);
        find(n, "9" + path + "6", accumulator, low, high);

    }
}
