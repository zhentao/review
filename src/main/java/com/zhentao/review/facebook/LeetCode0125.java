package com.zhentao.review.facebook;

/**
 * <b>125. Valid Palindrome</b> Given a string, determine if it is a palindrome,
 * considering only alphanumeric characters and ignoring cases.
 *
 * Note: For the purpose of this problem, we define empty string as valid
 * palindrome.
 *
 * <pre>
Example 1:

Input: "A man, a plan, a canal: Panama"
Output: true

Example 2:

Input: "race a car"
Output: false


Constraints:

    s consists only of printable ASCII characters.
 * </pre>
 *
 * @author zhentao.li
 *
 */
public class LeetCode0125 {
    public static void main(String[] args) {
        String s = "Marge, let's \"[went].\" I await {news} telegram.";
        System.out.println(new LeetCode0125().isPalindrome(s));
        System.out.println(new LeetCode0125().isPalindrome2(s));
        System.out.println(new LeetCode0125().isPalindrome2("test"));
    }
    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length()-1;
        while(i < j) {
            char left = Character.toLowerCase(s.charAt(i));
            //could use Character.isLetterOrDigit(ch)
            while (!Character.isLetter(left) && !Character.isDigit(left)) {
                i++;
                if (i == j) {
                    return true;
                }
                left = Character.toLowerCase(s.charAt(i));
            }
            char right = Character.toLowerCase(s.charAt(j));
            while(!Character.isAlphabetic(right) && !Character.isDigit(right)) {
                j--;
                if (j == i) {
                    return true;
                }
                right = Character.toLowerCase(s.charAt(j));
            }

            if (left != right) {
                return false;
            }
            i++;
            j--;

        }
        return true;
    }

    public boolean isPalindrome2(String s) {
        int i = 0;
        int j = s.length()-1;

        while (i < j) {
            while(i < j && !Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            }
            while(j > i && !Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            }
            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                return false;
            }
            i++;
            j--;
        }
        return true;

    }
}
