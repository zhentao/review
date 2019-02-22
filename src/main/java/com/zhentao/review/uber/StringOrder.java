package com.zhentao.review.uber;

import java.util.Arrays;

/**
 * 给一组string, 形式都是string+int, 比如aaa130. 输出排好序的string. 排序规则是先排string再排int.
 * 比如说aaa2比aaa100要小, 因为aaa一样大但是2比100小.
 *
 * @author zhentao
 *
 */
public class StringOrder {
    public void sort(final String[] array) {
        Arrays.sort(array, (s1, s2) -> compareTo(s1.toCharArray(), s2.toCharArray()));
    }

    private static int compareTo(final char[] value, final char[] other) {
        final int len1 = value.length;
        final int len2 = other.length;
        final int minLen = Math.min(len1, len2);
        int digit = -1;
        for (int k = 0; k < minLen; k++) {
            if (Character.isDigit(value[k]) && Character.isDigit(other[k])) {
                digit = k;
                break;
            } else if (value[k] != other[k]) {
                return value[k] - other[k];
            }
        }
        if (digit != -1) {
            final int s1 = Integer.valueOf(new StringBuilder().append(value, digit, value.length - digit).toString());
            final int s2 = Integer.valueOf(new StringBuilder().append(other, digit, other.length - digit).toString());
            return s1 - s2;
        } else {
            return len1 - len2;
        }
    }
}
