package com.zhentao.review.google;

/**
 * <b>686. Repeated String Match</b>
 * 
 * <pre>
 * Given two strings A and B, find the minimum number of times A has to be repeated such that B is a substring of it. If no such solution, return -1.

For example, with A = "abcd" and B = "cdabcdab".

Return 3, because by repeating A three times (“abcdabcdabcd”), B is a substring of it; and B is not a substring of A repeated two times ("abcdabcd").

Note:
The length of A and B will be between 1 and 10000.
 * </pre>
 * 
 * @author zhentao
 *
 */
public class RepeatedStringMatch {
    public static void main(final String[] args) {
        new RepeatedStringMatch().repeatedStringMatch("abc", "12345");
        new RepeatedStringMatch().repeatedStringMatch("abc", "123");
        new RepeatedStringMatch().repeatedStringMatch("abc", "1");
    }
    public int repeatedStringMatch(final String A, final String B) {
        final int lengthA = A.length();
        final int lengthB = B.length();
        final int q = (int)Math.ceil(lengthB*1.0/lengthA);
        final StringBuilder builder = new StringBuilder();
        for (int i = 0; i < q; i++) {
            builder.append(A);
        }
        if (builder.indexOf(B) > -1) {
            return q;
        }
        if (builder.append(A).indexOf(B) > -1) {
            return q+1;
        }
        return -1;
    }
}
