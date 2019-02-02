package com.zhentao.review.google;

import java.util.Arrays;
import java.util.HashSet;

/**
 * <b>128. Longest Consecutive Sequence</b>
 * 
 * <pre>
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

Your algorithm should run in O(n) complexity.

Example:

Input: [100, 4, 200, 1, 3, 2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 * </pre>
 * 
 * @author zhentao
 *
 */
public class LongestConsectiveSequence {
    public int longestConsecutiveBySort(final int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int longest = 1;
        int current = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i-1]) {//in case array has dups
                if (nums[i] == nums[i-1] + 1) {
                    current++;
                } else {
                    longest = Math.max(longest, current);
                    current = 1;
                }
            }
        }
        return Math.max(longest, current); // for array with 2 elements;
    }
    
    public int longestConsecutive(final int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        final HashSet<Integer> set = new HashSet<>();
        for (final int a : nums) {
            set.add(a); // This also removes dups
        }
        
        int longest = 1;
        int current = 1;
        for (int a : set) {
            if (!set.contains(a-1)) {//make sure a is the smallest in the consecutive sequence
                while(set.contains(a+1)) {
                    current++;
                    a++;
                }
                longest = Math.max(current, longest);
                current = 1;
            }
        }
        return longest;
    }
}
