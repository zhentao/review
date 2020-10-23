package com.zhentao.review.facebook;

/**
 * <b>67. Add Binary</b> Given two binary strings, return their sum (also a
 * binary string).
 *
 * The input strings are both non-empty and contains only characters 1 or 0.
 *
 * <pre>
Example 1:

Input: a = "11", b = "1"
Output: "100"

Example 2:

Input: a = "1010", b = "1011"
Output: "10101"



Constraints:

    Each string consists only of '0' or '1' characters.
    1 <= a.length, b.length <= 10^4
    Each string is either "0" or doesn't contain any leading zero.
 * </pre>
 *
 * @author zhentao.li
 *
 */
public class LeetCode0067 {
    public static void main(String[] args) {
        LeetCode0067 lc = new LeetCode0067();
        System.out.println(lc.addBinary("1", "111"));
    }
    public String addBinary(String a, String b) {

        int lengthA = a.length();
        int lengthB = b.length();

        StringBuilder builder = new StringBuilder(Math.max(lengthA, lengthB)+1);

        int i = lengthA - 1;
        int j = lengthB - 1;
        int carry = 0;
        while (i >= 0 && j>= 0) {
            int total = (a.charAt(i) - '0') + (b.charAt(j) - '0') + carry;
            carry = total / 2;
            builder.append(total % 2);
            i--;
            j--;
        }
        while (i >= 0) {
            int total = a.charAt(i) - '0' + carry;
            builder.append(total % 2);
            carry = total / 2;
            i--;
        }

        while (j >= 0) {
            int total = b.charAt(j) - '0' + carry;
            builder.append(total % 2);
            carry = total / 2;
            j--;
        }

        if (carry != 0) {
            builder.append(carry);
        }

        return builder.reverse().toString();
    }
}
