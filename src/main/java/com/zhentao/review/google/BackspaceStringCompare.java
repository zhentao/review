package com.zhentao.review.google;

/**
 * <b>844. Backspace String Compare</b>
 * 
 * <pre>
 * Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.

Example 1:

Input: S = "ab#c", T = "ad#c"
Output: true
Explanation: Both S and T become "ac".
Example 2:

Input: S = "ab##", T = "c#d#"
Output: true
Explanation: Both S and T become "".
Example 3:

Input: S = "a##c", T = "#a#c"
Output: true
Explanation: Both S and T become "c".
Example 4:

Input: S = "a#c", T = "b"
Output: false
Explanation: S becomes "c" while T becomes "b".
Note:

1 <= S.length <= 200
1 <= T.length <= 200
S and T only contain lowercase letters and '#' characters.
Follow up:

Can you solve it in O(N) time and O(1) space?
 * </pre>
 * 
 * @author zhentao
 *
 */
public class BackspaceStringCompare {
    public boolean compare(String s, String t) {
        return build(s).equals(build(t));
    }

    private String build(String s) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);
            if (ch != '#') {
                builder.append(ch);
            } else {
                int length = builder.length();
                if (length > 0) {
                    builder.deleteCharAt(length - 1);
                }
            }
        }
        return builder.toString();
    }

    /**
     * use O(1) space
     * 
     * @param s
     * @param t
     * @return
     */
    public boolean compare2(String s, String t) {
        int sEnd = s.length() - 1;
        int tEnd = t.length() - 1;
        int sCount = 0;
        int tCount = 0;
        while (true) {
            char sCh = (sEnd == -1 ? '0' : s.charAt(sEnd));
            char tCh = (tEnd == -1 ? '0' : t.charAt(tEnd));
            if (sCh != tCh && sCh != '#' && tCh != '#') {
                return false;
            } else if (sCh == tCh && sCh != '#') {
                sEnd--;
                tEnd--;
            } else {
                if (sCh == '#') {
                    while (sEnd >= 0 && s.charAt(sEnd) == '#') {
                        sCount++;
                        sEnd--;
                    }
                    while (sCount > 0 && sEnd >= 0) {
                        if (s.charAt(sEnd) != '#') {
                            sCount--;
                        } else {
                            sCount++;
                        }
                        sEnd--;
                    }
                }
                if (tCh == '#') {
                    while (tEnd >= 0 && t.charAt(tEnd) == '#') {
                        tCount++;
                        tEnd--;
                    }
                    while (tCount > 0 && tEnd >= 0) {
                        if (t.charAt(tEnd) != '#') {
                            tCount--;
                        } else {
                            tCount++;
                        }
                        tEnd--;
                    }
                }
            }
            if (sEnd == -1 && tEnd == -1) {
                return true;
            }
        }
    }
}
