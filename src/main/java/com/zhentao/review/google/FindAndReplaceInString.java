package com.zhentao.review.google;

import java.util.Arrays;
import java.util.HashMap;

/**
 * <b>833. Find And Replace in String</b>
 * 
 * <pre>
 * To some string S, we will perform some replacement operations that replace groups of letters with new ones (not necessarily the same size).

Each replacement operation has 3 parameters: a starting index i, a source word x and a target word y.  The rule is that if x starts at position i in the original string S, then we will replace that occurrence of x with y.  If not, we do nothing.

For example, if we have S = "abcd" and we have some replacement operation i = 2, x = "cd", y = "ffff", then because "cd" starts at position 2 in the original string S, we will replace it with "ffff".

Using another example on S = "abcd", if we have both the replacement operation i = 0, x = "ab", y = "eee", as well as another replacement operation i = 2, x = "ec", y = "ffff", this second operation does nothing because in the original string S[2] = 'c', which doesn't match x[0] = 'e'.

All these operations occur simultaneously.  It's guaranteed that there won't be any overlap in replacement: for example, S = "abc", indexes = [0, 1], sources = ["ab","bc"] is not a valid test case.

Example 1:

Input: S = "abcd", indexes = [0,2], sources = ["a","cd"], targets = ["eee","ffff"]
Output: "eeebffff"
Explanation: "a" starts at index 0 in S, so it's replaced by "eee".
"cd" starts at index 2 in S, so it's replaced by "ffff".
Example 2:

Input: S = "abcd", indexes = [0,2], sources = ["ab","ec"], targets = ["eee","ffff"]
Output: "eeecd"
Explanation: "ab" starts at index 0 in S, so it's replaced by "eee". 
"ec" doesn't starts at index 2 in the original S, so we do nothing.
Notes:

0 <= indexes.length = sources.length = targets.length <= 100
0 < indexes[i] < S.length <= 1000
All characters in given inputs are lowercase letters.
 * </pre>
 * 
 * @author zhentao
 *
 */
public class FindAndReplaceInString {
    public static void main(String[] args) {
        System.out.println(findReplaceString("abcd", new int[] { 2, 0 }, new String[] { "cd", "a" },
                new String[] { "ffff", "eee" }));

        System.out.println(findReplaceString("ukdaxmobyfnelsdeecwisaxwjjfrxwsyfibbvnenesupbifdza",
                new int[] { 22, 27, 0, 25, 6, 32, 30, 36, 44, 8, 46, 40, 38, 14, 17, 20 },
                new String[] { "xwj", "rxw", "uk", "jf", "ob", "fib", "sy", "vn", "bi", "yfnel", "fdza", "esu", "en",
                        "de", "cw", "sa" },
                new String[] { "pw", "lqpq", "vp", "w", "ey", "lavl", "o", "wvb", "kpj", "aosdke", "ybie", "kuh", "a",
                        "b", "j", "gz" }).equals("vpdaxmeyaosdkesbejigzpwwlqpqolavlbwvbakuhpkpjybie"));
        System.out.println(findReplaceString("abcd", new int[] { 0, 2 }, new String[] { "a", "cd" },
                new String[] { "eee", "ffff" }));
        System.out.println(findReplaceString("abcd", new int[] { 0, 2 }, new String[] { "ab", "ec" },
                new String[] { "eee", "ffff" }));

    }

    public static String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < indexes.length; i++) {
            map.put(indexes[i], i);
        }
        Arrays.sort(indexes);

        StringBuilder builder = new StringBuilder(S);
        for (int i = indexes.length - 1; i >= 0; i--) {// for (int i = S.length() - 1; i >= 0; i--) then check if
                                                       // map.contains(i), so no need to sort.
            int start = indexes[i];
            int originalIndex = map.get(start);
            int end = indexes[i] + sources[originalIndex].length();
            if (builder.substring(start, end).equals(sources[originalIndex])) {
                builder.replace(start, end, targets[originalIndex]);
            }
        }
        return builder.toString();
    }
}
