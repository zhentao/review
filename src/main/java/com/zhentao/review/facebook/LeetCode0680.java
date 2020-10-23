package com.zhentao.review.facebook;

/**
 * <b>680. Valid Palindrome II</b>
 *
 * Given a non-empty string s, you may delete at most one character. Judge
 * whether you can make it a palindrome.
 *
 * <pre>
Example 1:

Input: "aba"
Output: True

Example 2:

Input: "abca"
Output: True
Explanation: You could delete the character 'c'.

Note:

    The string will only contain lowercase characters a-z. The maximum length of the string is 50000.
 * </pre>
 *
 * @author zhentao.li
 *
 */
public class LeetCode0680 {
    public boolean validPalindrome2(String s) {
        int i = 0;
        int j = s.length()-1;

        while(i > j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                return isPalindrome(s, i+1, j) || isPalindrome(s, i, j-1);
            }
        }
        return true;
    }


    public boolean validPalindrome(String s) {
        int start = 0;
        int end = s.length()-1;
        while(start < end) {
            if (s.charAt(start) == s.charAt(end)) {
                start++;
                end--;
            } else {
                return isPalindrome(s, start+1, end) || isPalindrome(s, start, end-1);
            }
        }
        return true;
    }

    private boolean isPalindrome(String s, int start, int end) {
        while(start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            } else {
                start++;
                end--;
            }
        }
        return true;
    }
}
