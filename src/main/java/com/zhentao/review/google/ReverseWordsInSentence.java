package com.zhentao.review.google;

/**
 * <b>151. Reverse Words in a String</b>
 * 
 * <pre>
 * Given an input string, reverse the string word by word.

Example:  

Input: "the sky is blue",
Output: "blue is sky the".
Note:

A word is defined as a sequence of non-space characters.
Input string may contain leading or trailing spaces. However, your reversed string should not contain leading or trailing spaces.
You need to reduce multiple spaces between two words to a single space in the reversed string.
Follow up: For C programmers, try to solve it in-place in O(1) space.
 * </pre>
 * 
 * @author zhentao
 *
 */
public class ReverseWordsInSentence {
    public static void main(final String[] args) {
        final String input = "the sky is blue";
        System.out.println(new ReverseWordsInSentence().reverseWords(input));
    }

    public String reverseWords(final String s) {
        if (s == null) {
            return null;
        }
        final String[] array = s.split("( )+");
        final StringBuilder builder = new StringBuilder();
        for (int i = array.length - 1; i >= 0; i--) {
            builder.append(array[i]).append(" ");
        }
        
        return builder.toString().trim();
    }
}
