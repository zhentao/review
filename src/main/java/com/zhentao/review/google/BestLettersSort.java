package com.zhentao.review.google;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 * input: ['b', 'a', 'd'], ["apple, banana, dog, abandon] 
 * output: ['banana','abandon', 'apple', 'dog']
 * </pre>
 * 
 * @author zhentao
 *
 */
public class BestLettersSort {
    public void sort(final char[] order, final String[] input) {
        final HashMap<Character, Integer> charOrder = new HashMap<>();

        final int length = order.length;
        for (int i = 0; i < length; i++) {
            charOrder.put(order[i], -(length - i));
        }
        Arrays.sort(input, (o1, o2) -> compareTo(o1.toCharArray(), o2.toCharArray(), charOrder));
    }

    /**
     * Based on JDK source code
     * 
     * @param value
     * @param other
     * @param order
     * @return
     */
    private static int compareTo(final char[] value, final char[] other, final Map<Character, Integer> order) {
        final int len1 = value.length;
        final int len2 = other.length;
        final int lim = Math.min(len1, len2);
        for (int k = 0; k < lim; k++) {
            if (value[k] != other[k]) {
                return order.getOrDefault(value[k], (int) value[k]) - order.getOrDefault(other[k], (int) other[k]);
            }
        }
        return len1 - len2;
    }
}
