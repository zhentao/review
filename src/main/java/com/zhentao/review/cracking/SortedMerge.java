package com.zhentao.review.cracking;

import java.util.Arrays;
import java.util.BitSet;

/**
 * <b>10.1 Sorted Merge</b>
 * 
 * <pre>
 * You are given two sorted arrays, A and B, where A has a large enough buffer at the
end to hold B. Write a method to merge B into A in sorted order.
 * </pre>
 * 
 * @author zhentao
 *
 */
public class SortedMerge {

    public static void main(String[] args) {
        BitSet bs = new BitSet(30);
        byte[] bitfield = new byte[100];
       
        for (int i = 0; i < 9; i++) {
            bitfield[i / 8] |= 1 << (i % 8);
        }
        System.out.println(Arrays.toString(bitfield));

        int[] a = { 3, 5, 8, 13, 0, 0, 0, 0, 0, 0, 0 };
        int[] b = { 5, 15 };
        sort(a, 4, b);
        System.out.println(Arrays.toString(a));

        int[] x = { 3, 5, 8, 13 };
        int[] y = { 5, 15, 0, 0, 0, 0, 0, 0, 0 };
        sort(y, 2, x);
        System.out.println(Arrays.toString(y));
    }

    public static void sort(int[] a, int lengthA, int[] b) {
        int lengthB = b.length;
        int m = lengthA - 1;// last index for a
        int n = lengthB - 1;
        while (m >= 0 && n >= 0) {
            if (b[n] > a[m]) {
                a[m + n + 1] = b[n];
                n--;
            } else {
                a[m + n + 1] = a[m];
                m--;
            }
        }
        // copy remainders of b. If a has remainders, they are already in the right
        // place
        for (int i = 0; i <= n; i++) {
            a[i] = b[i];
        }
    }

}
