package com.zhentao.review.leetcode;

/**
 * <b>29. Divide Two Integers</b>
 * 
 * <pre>
 * Given two integers dividend and divisor, divide two integers without using multiplication, 
 * division and mod operator.

Return the quotient after dividing dividend by divisor.

The integer division should truncate toward zero.

Example 1:

Input: dividend = 10, divisor = 3
Output: 3
Example 2:

Input: dividend = 7, divisor = -3
Output: -2
Note:

Both dividend and divisor will be 32-bit signed integers.
The divisor will never be 0.
Assume we are dealing with an environment which could only store integers within the 32-bit 
signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your 
function returns 231 − 1 when the division result overflows.
 * </pre>
 * 
 * @author zhentao
 *
 */
public class DivideTwoIntegers {
    public int divide( int dividend,  int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == Integer.MIN_VALUE) {
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
        
        int sign = 1;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
            sign = -1;
        }
        
        if (divisor > 0) {
            divisor = -divisor;
        }
        if (dividend > 0) {
            dividend = -dividend;
        }
        int result = 0;
        while((dividend = dividend - divisor)  <= 0) {
            result++;
        }
        
        return sign == -1 ? -result : result;
    }
}
