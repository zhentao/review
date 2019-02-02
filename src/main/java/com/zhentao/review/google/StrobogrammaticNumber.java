package com.zhentao.review.google;

import java.util.HashMap;
import java.util.Set;

/**
 * <b>246. Strobogrammatic Number</b>
 * see MagicNumber.
 * <pre>
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

Write a function to determine if a number is strobogrammatic. The number is represented as a string.

Example 1:

Input:  "69"
Output: true
Example 2:

Input:  "88"
Output: true
Example 3:

Input:  "962"
Output: false
 * </pre>
 * 
 * @author zhentao
 *
 */
public class StrobogrammaticNumber {
    public boolean isStrobogrammatic(final String num) {
        if (num == null || num.length() == 0) {
            return false;
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

        final Set<Character> keySet = map.keySet();
        final char[] array = num.toCharArray();
        int start = 0;
        int end = array.length - 1;

        while (start <= end) {
            final char m = array[start];
            final char n = array[end];
            if (!keySet.contains(m) || !keySet.contains(n)) {
                return false;
            }
            if (map.get(m) != n) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
