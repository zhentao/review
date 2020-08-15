package com.zhentao.review.facebook;

/**
 * 29. Divide Two Integers
Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.

Return the quotient after dividing dividend by divisor.

The integer division should truncate toward zero, which means losing its fractional part. For example, truncate(8.345) = 8 and truncate(-2.7335) = -2.

Example 1:

Input: dividend = 10, divisor = 3
Output: 3
Explanation: 10/3 = truncate(3.33333..) = 3.

Example 2:

Input: dividend = 7, divisor = -3
Output: -2
Explanation: 7/-3 = truncate(-2.33333..) = -2.

Note:

    Both dividend and divisor will be 32-bit signed integers.
    The divisor will never be 0.
    Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 231 − 1 when the division result overflows.


 * @author zhentao.li
 *
 */
public class LeetCode0029 {
    public static void main(String[] args) {
        System.out.println(new LeetCode0029().divide(-2147483648, 2));
    }
    public int divide(int dividend, int divisor) {
        if (dividend == divisor) {
            return 1;
        }
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        if (dividend == Integer.MIN_VALUE && divisor == 1) {
            return Integer.MIN_VALUE;
        }
        if (divisor == Integer.MIN_VALUE) {
            return 0;
        }
        if (dividend ==Integer.MIN_VALUE && divisor == Integer.MAX_VALUE) {
            return -1;
        }

        int sign = (dividend < 0) != (divisor < 0) ? -1 : 1;


        int result = 0;
        long newDividend = Math.abs((long)dividend);
        long newDivisor = Math.abs((long)divisor);
        while(newDividend >= newDivisor) {
            long d = newDivisor;
            long p = 1;
            while (newDividend >= (d + d)) {
                d += d;
                p += p;
            }

            result += p;
            newDividend -= d;
        }

        return sign == -1 ? -result : result;
    }
}
