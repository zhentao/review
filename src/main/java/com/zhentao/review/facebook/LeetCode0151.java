package com.zhentao.review.facebook;

import java.util.Arrays;

/**
 * <b>151. Reverse Words in a String</b> Medium
 *
 * Given an input string, reverse the string word by word.
 *
 *
 * <pre>
Example 1:

Input: "the sky is blue"
Output: "blue is sky the"

Example 2:

Input: "  hello world!  "
Output: "world! hello"
Explanation: Your reversed string should not contain leading or trailing spaces.

Example 3:

Input: "a good   example"
Output: "example good a"
Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.

Note:

    A word is defined as a sequence of non-space characters.
    Input string may contain leading or trailing spaces. However, your reversed string should not contain leading or trailing spaces.
    You need to reduce multiple spaces between two words to a single space in the reversed string.
 * </pre>
 *
 * @author zhentao.li
 *
 */
public class LeetCode0151 {
    public static void main(String[] args) {
        String test = " abc    def";
        System.out.println(Arrays.toString(test.split("( )+")));
        System.out.println(Arrays.toString(test.split(" ")));



        String s = "  hello world!  ";

        System.out.println(new LeetCode0151().reverseWords(s));
    }

    public String reverseWords2(String s) {
        String[] array = s.split("( )+");
        StringBuilder builder = new StringBuilder();
        for (int i = array.length - 1; i >=0; i++) {
            builder.append(array[i]).append(" ");
        }
        return builder.toString().trim();
    }
    public String reverseWords(String s) {
        char[] array = s.toCharArray();
        reverseSentence(array);

        return reverseWords(array);
    }

    /**
     * reverse the entire string
     * @param charArray
     */
    private void reverseSentence(char[] charArray) {
        int i = 0;
        int j = charArray.length - 1;
        while (i < j) {
            char temp = charArray[i];
            charArray[i] = charArray[j];
            charArray[j] = temp;
            i++;
            j--;
        }
    }

    /**
     * reverse each word in place
     * @param array
     * @return
     */
    private String reverseWords(char[] array) {
        char previous = ' ';
        int wordStart = 0;
        int wordEnd = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == ' ') {
                if (previous != ' ') {
                    reverse(array, wordStart, wordEnd);
                    previous = ' ';
                } else {
                    array[i] = '0';
                }
            } else {
                if (previous == ' ') {
                    wordStart = i;
                    wordEnd = i;
                } else {
                    wordEnd++;
                }
                previous = array[i];

                if (i == array.length - 1) {
                    reverse(array, wordStart, array.length-1);
                }
            }
        }
        StringBuilder builder = new StringBuilder();
        for (char ch : array) {
            if (ch != '0') {
                builder.append(ch);
            }
        }
        return builder.toString().trim();
    }

    private void reverse(char[] array, int start, int end) {
        while(start < end) {
            char temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }

}
