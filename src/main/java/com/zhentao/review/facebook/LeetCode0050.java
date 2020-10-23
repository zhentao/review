package com.zhentao.review.facebook;

/**
 * <b>50. Pow(x, n)</b> Implement pow(x, n), which calculates x raised to the
 * power n (i.e. xn).
 *
 * <pre>
Example 1:

Input: x = 2.00000, n = 10
Output: 1024.00000

Example 2:

Input: x = 2.10000, n = 3
Output: 9.26100

Example 3:

Input: x = 2.00000, n = -2
Output: 0.25000
Explanation: 2-2 = 1/22 = 1/4 = 0.25



Constraints:

    -100.0 < x < 100.0
    -2^31 <= n <= 2^31 - 1
    -10^4 <= x^n <= 10^4
 * </pre>
 *
 * @author zhentao.li
 *
 */
public class LeetCode0050 {
    public static void main(String[] args) {
        LeetCode0050 lc = new LeetCode0050();
        System.out.println(lc.myPow(1.00000, -2147483648));
        System.out.println(lc.myPow(2, -3));
    }
    public double myPow(double x, int n) {
        return myPow1(x, n);
    }
    public double myPow1(double x, long n) {
        if (n == 0) {
            return 1;
        }

        if (n < 0) {
            return 1.0 / myPow1(x, -n);
        }
        if (n % 2 == 0) {
            return myPow1(x*x, n/2);
        } else {
            return x * myPow1(x * x, n/2);
        }
    }
}
