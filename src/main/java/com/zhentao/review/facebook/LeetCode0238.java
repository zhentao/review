package com.zhentao.review.facebook;

import java.util.Arrays;

/**
 * 238. Product of Array Except Self Medium
 *
 * Given an array nums of n integers where n > 1, return an array output such
 * that output[i] is equal to the product of all the elements of nums except
 * nums[i].
 *
 * Example:
 *
 * Input: [1,2,3,4] Output: [24,12,8,6]
 *
 * Constraint: It's guaranteed that the product of the elements of any prefix or
 * suffix of the array (including the whole array) fits in a 32 bit integer.
 *
 * Note: Please solve it without division and in O(n).
 *
 * Follow up: Could you solve it with constant space complexity? (The output
 * array does not count as extra space for the purpose of space complexity
 * analysis.)
 *
 * @author zhentao.li
 *
 */
public class LeetCode0238 {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5 };
        LeetCode0238 lc = new LeetCode0238();
        System.out.println(Arrays.toString(lc.productExceptSelf(nums)));
    }

    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] left = new int[length];
        int[] right = new int[length];

        left[0] = 1;
        for (int i = 1; i < length; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }

        right[length - 1] = 1;
        for (int i = length - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }

        int[] answer = new int[length];

        for (int i = 0; i < length; i++) {
            answer[i] = left[i] * right[i];
        }

        return answer;
    }
}
