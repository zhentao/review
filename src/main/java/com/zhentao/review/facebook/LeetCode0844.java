package com.zhentao.review.facebook;

/**
 * 844. Backspace String Compare
Easy

Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.

Note that after backspacing an empty text, the text will continue empty.

Example 1:

Input: S = "ab#c", T = "ad#c"
Output: true
Explanation: Both S and T become "ac".

 * @author zhentao.li
 *
 */
public class LeetCode0844 {
    public boolean backspaceCompare(String S, String T) {
        int sEnd = S.length() - 1;
        int tEnd = T.length() - 1;
        int sSkip = 0;
        int tSkip = 0;
        while(sEnd >= 0 || tEnd >=0) {
            while (sEnd >= 0) {
                if (S.charAt(sEnd) == '#') {
                    sSkip++;
                } else if (sSkip > 0) {
                    sSkip--;
                    sEnd--;
                } else {
                    break;
                }
            }

            while (tEnd >= 0) {
                if (T.charAt(tEnd) == '#') {
                    tSkip++;
                } else if (tSkip > 0) {
                    tSkip--;
                    tEnd--;
                } else {
                    break;
                }
            }

            if (sEnd >=0 && tEnd >= 0 && S.charAt(sEnd) != T.charAt(tEnd)) {
                return false;
            }
            if ((sEnd >= 0) != (tEnd >= 0)) {
                return false;
            }

            sEnd--;
            tEnd--;
        }
        return true;
    }
}
