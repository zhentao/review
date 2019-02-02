package com.zhentao.review.google;

/**
 * <b>91. Decode Ways</b>
 * 
 * <pre>
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given a non-empty string containing only digits, determine the total number of ways to decode it.

Example 1:

Input: "12"
Output: 2
Explanation: It could be decoded as "AB" (1 2) or "L" (12).
Example 2:

Input: "226"
Output: 3
Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
 * </pre>
 * 
 * @author zhentao
 *
 */
public class DecodeWays {
    public int numDecodings(final String s) {
        if (s.startsWith("0")) {
            return 0;
        }
        final int length = s.length();
        
        int f0 = 1;
        int f1 = 1;
        for (int i = 2; i <= length; i++) {
            int f;
            final int both = Integer.parseInt(s.substring(i-2, i));
            final char val1 = s.charAt(i-1);
            //final char val0 = s.charAt(i-2);
            if ((both > 26 && val1 == '0') || both == 0 ) {
                return 0;
            }
            if (both <= 26 && both >= 11 && val1 != '0') {
                f = f0+f1;
            } else if (val1 != '0'){
                f = f1;
            } else {
                f = f0;
            }
            f0 = f1;
            f1 = f;
        }
        return f1;
    }
}
