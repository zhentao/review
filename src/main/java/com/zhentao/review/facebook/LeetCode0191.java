package com.zhentao.review.facebook;

/**
 * <b>191. Number of 1 Bits</b> Write a function that takes an unsigned integer
 * and return the number of '1' bits it has (also known as the Hamming weight).
 *
 * @author zhentao.li
 *
 */
public class LeetCode0191 {
    public int hammingWeight(int n) {
        return Integer.bitCount(n);
    }

    public int hammingWeight2(int n) {
        int count = 0;
        while (n != 0) {
            count += n & 1;
            //shift a zero into the leftmost position
            n = (n >>> 1);
        }
        return count;
    }
}
