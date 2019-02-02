package com.zhentao.review.google;

import java.util.ArrayList;
import java.util.List;

/**
 * <b>830. Positions of Large Groups</b>
 * 
 * <pre>
 * In a string S of lowercase letters, these letters form consecutive groups of the same character.

For example, a string like S = "abbxxxxzyy" has the groups "a", "bb", "xxxx", "z" and "yy".

Call a group large if it has 3 or more characters.  We would like the starting and ending positions of every large group.

The final answer should be in lexicographic order.

 

Example 1:

Input: "abbxxxxzzy"
Output: [[3,6]]
Explanation: "xxxx" is the single large group with starting  3 and ending positions 6.
Example 2:

Input: "abc"
Output: []
Explanation: We have "a","b" and "c" but no large group.
Example 3:

Input: "abcdddeeeeaabbbcd"
Output: [[3,5],[6,9],[12,14]]
 

Note:  1 <= S.length <= 1000
 * </pre>
 * 
 * @author zhentao
 *
 */
public class PositionOfLarggeGroup {
    public List<List<Integer>> largeGroupPositions(final String s) {
        int start = 0;
        int end = 0;
        
        final int length = s.length();
        final List<List<Integer>> lists = new ArrayList<>(); 
        while (start < length - 2 && end < length) {
            if (s.charAt(start) == s.charAt(start + 1) && s.charAt(start) == s.charAt(start + 2)) {
                end = start + 3;
                while(end < length && s.charAt(start) == s.charAt(end)) {
                    end++;
                }
                final ArrayList<Integer> list = new ArrayList<>();
                list.add(start);
                list.add(end-1);
                lists.add(list);
                start = end;
            } else {
                start++;
            }
        }
        return lists;
    }
}
