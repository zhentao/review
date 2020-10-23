package com.zhentao.review.facebook;

/**
 * <b>273. Integer to English Words</b> Convert a non-negative integer to its
 * English words representation. Given input is guaranteed to be less than 2^31
 * - 1.
 *
 * <pre>
Example 1:

Input: 123
Output: "One Hundred Twenty Three"

Example 2:

Input: 12345
Output: "Twelve Thousand Three Hundred Forty Five"

Example 3:

Input: 1234567
Output: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"

Example 4:

Input: 1234567891
Output: "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One"
 * </pre>
 *
 * @author zhentao.li
 *
 */
public class LeetCode0273 {
    private static final String[] LESS_THAN_20 = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
            "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen",
            "Nineteen" };
    private static final String[] TENS = { "", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty",
            "Ninety" };

    private String[] lessThan1000 = generate();


    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        StringBuilder builder = new StringBuilder();
        int billions = num / 1000_000_000;
        if (billions > 0) {
            builder.append(lessThan1000[billions]).append(" Billion ");
        }
        int millions = (num - billions * 1000_000_000) / 1000_000;
        if (millions > 0) {
            builder.append(lessThan1000[millions]).append(" Million ");
        }
        int thousands = (num - billions * 1000_000_000 - millions * 1000_000) / 1000;
        if (thousands > 0) {
            builder.append(lessThan1000[thousands]).append(" Thousand ");
        }

        int leftOver = num - billions * 1000_000_000 - millions * 1000_000 - thousands * 1000;
        if (leftOver > 0) {
            builder.append(lessThan1000[leftOver]);
        }
        return builder.toString().trim();
    }

    private static String[] generate() {
        String[] l = new String[1000];

        for (int i = 0; i < 20; i++) {
            l[i] = LESS_THAN_20[i];
        }
        for (int i = 20; i < 100; i++) {
            l[i] = (TENS[i / 10] + " " + LESS_THAN_20[i % 10]).trim();
        }

        for (int i = 100; i < 1000; i++) {
            l[i] = (LESS_THAN_20[i / 100] + " Hundred " + l[i % 100]).trim();
        }
        return l;
    }
}
