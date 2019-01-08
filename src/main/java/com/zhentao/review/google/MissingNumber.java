package com.zhentao.review.google;

/**
 * <pre>
 * Given a contiguous sequence of numbers in which each number repeats thrice,
 * there is exactly one missing number. Find the missing number. 
 * eg: 11122333 : Missing number 2 
 * 11122233344455666 Missing number 5
 * </pre>
 * 
 * @author zhentao
 *
 */
public class MissingNumber {
    public String find(String input) {
        return find(input, 0, input.length() - 1);
    }

    private String find(String input, int start, int end) {
        if (end - start <= 1) {
            return String.valueOf(input.charAt(start));
        }
        int mid = start + (end - start) / 2;
        char ch = input.charAt(mid);
        // middle is the 3rd char
        if (ch == input.charAt(mid - 1) && ch == input.charAt(mid - 2)) {
            return find(input, mid + 1, end);
        } else if (ch == input.charAt(mid - 1) && ch == input.charAt(mid + 1)) {
            return find(input, start, mid - 2);

        } else if (ch == input.charAt(mid + 1) && ch == input.charAt(mid + 2)) {
            return find(input, start, mid - 1);

        } else {// the mid is the missing one
            return String.valueOf(input.charAt(mid));
        }
    }
}
