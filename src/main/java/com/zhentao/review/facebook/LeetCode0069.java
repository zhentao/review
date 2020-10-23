package com.zhentao.review.facebook;

/**
 * <b>69. Sqrt(x)</b> Implement int sqrt(int x).
 *
 * Compute and return the square root of x, where x is guaranteed to be a
 * non-negative integer.
 *
 * Since the return type is an integer, the decimal digits are truncated and
 * only the integer part of the result is returned.
 *
 * <pre>
Example 1:

Input: 4
Output: 2

Example 2:

Input: 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since
             the decimal part is truncated, 2 is returned.
 *
 * </pre>
 *
 * @author zhentao.li
 *
 */
public class LeetCode0069 {
    public static void main(String[] args) {
        LeetCode0069 lc = new LeetCode0069();
        System.out.println(lc.mySqrt(2147395599));
    }
    public int mySqrt(int x) {
        int left = 1;
        int right = x;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            //note mid * mid causes overflow.
            if (mid == x / mid) {
                return mid;
            } else if (mid < x / mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }
}
