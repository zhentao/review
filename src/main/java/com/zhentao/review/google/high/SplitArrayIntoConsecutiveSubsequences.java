package com.zhentao.review.google.high;

import java.util.HashMap;

/**
 * <b>659. Split Array into Consecutive Subsequences</b>
 * 
 * <pre>
 * You are given an integer array sorted in ascending order (may contain duplicates), 
 * you need to split them into several subsequences, where each subsequences consist 
 * of at least 3 consecutive integers. Return whether you can make such a split.

Example 1:
Input: [1,2,3,3,4,5]
Output: True
Explanation:
You can split them into two consecutive subsequences : 
1, 2, 3
3, 4, 5
Example 2:
Input: [1,2,3,3,4,4,5,5]
Output: True
Explanation:
You can split them into two consecutive subsequences : 
1, 2, 3, 4, 5
3, 4, 5
Example 3:
Input: [1,2,3,4,4,5]
Output: False
Note:
The length of the input is in range of [1, 10000]
 * </pre>
 * 
 * @author zhentao
 *
 */
public class SplitArrayIntoConsecutiveSubsequences {
    public boolean isPossible(final int[] nums) {
        final HashMap<Integer, Integer> frequency = new HashMap<>();
        final HashMap<Integer, Integer> tail = new HashMap<>();
        for (final int i : nums) {
            frequency.put(i, frequency.getOrDefault(i, 0) + 1);
        }

        for (final int i : nums) {
            if (frequency.get(i) == 0) {
                continue;
            } else if (tail.getOrDefault(i, 0) > 0) {
                // can concatenate with other sequence, so decrement the frequency by 1
                tail.put(i, tail.get(i) - 1);
                // then the next number is the candidate to be concatenated.
                tail.put(i + 1, tail.getOrDefault(i + 1, 0) + 1);
            } else if (frequency.getOrDefault(i + 1, 0) > 0 && frequency.getOrDefault(i + 2, 0) > 0) {
                //i is the start of a new sequence
                // and include the next 2 numbers
                frequency.put(i + 1, frequency.get(i + 1) - 1);
                frequency.put(i + 2, frequency.get(i + 2) - 1);
                //the 3rd number is the candidate to this sequence
                //This number may or may not exist though.
                tail.put(i + 3, tail.getOrDefault(i + 3, 0) + 1);
            } else {
                return false;
            }
            frequency.put(i, frequency.get(i) - 1);
        }
        return true;
    }
}
