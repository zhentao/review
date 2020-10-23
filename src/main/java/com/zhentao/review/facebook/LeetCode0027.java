package com.zhentao.review.facebook;

import java.util.Arrays;

/**
 * <b>27. Remove Element</b><br/>
 * Given an array nums and a value val, remove all instances of that value
 * in-place and return the new length.
 *
 * Do not allocate extra space for another array, you must do this by modifying
 * the input array in-place with O(1) extra memory.
 *
 * The order of elements can be changed. It doesn't matter what you leave beyond
 * the new length.
 *
 * <pre>
Example 1:

Given nums = [3,2,2,3], val = 3,

Your function should return length = 2, with the first two elements of nums being 2.
 * </pre>
 *
 * It doesn't matter what you leave beyond the returned length.
 *
 * <pre>
Example 2:

Given nums = [0,1,2,2,3,0,4,2], val = 2,

Your function should return length = 5, with the first five elements of nums containing 0, 1, 3, 0, and 4.
 * </pre>
 *
 * Note that the order of those five elements can be arbitrary.
 *
 * It doesn't matter what values are set beyond the returned length.
 *
 * Clarification:
 *
 * Confused why the returned value is an integer but your answer is an array?
 *
 * Note that the input array is passed in by reference, which means modification
 * to the input array will be known to the caller as well.
 *
 * Internally you can think of this:
 *
 * <pre>
 * // nums is passed in by reference. (i.e., without making a copy)
 * int len = removeElement(nums, val);
 *
 * // any modification to nums in your function would be known by the caller.
 * // using the length returned by your function, it prints the first len elements.
 * for (int i = 0; i < len; i++) {
 *     print(nums[i]);
 * }
 * </pre>
 *
 * @author zhentao.li
 *
 */
public class LeetCode0027 {
    public static void main(String[] args) {
        int[] nums = {0,1,2,2,3,0,4,2};
        LeetCode0027 lc = new LeetCode0027();
        int count = lc.removeElement(nums, 2);
        System.out.println(count);
        System.out.println(Arrays.toString(nums));
    }
    public int removeElement(int[] nums, int val) {
        int count = nums.length;
        for (int i = 0; i < count; i++) {
            if (nums[i] == val) {
                nums[i] = nums[count-1];
                count--;
                i--;
            }
        }

        return count;
    }
}
