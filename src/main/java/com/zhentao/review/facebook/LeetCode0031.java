package com.zhentao.review.facebook;

import java.util.Arrays;

/**
 * 31. Implement next permutation, which rearranges numbers into the
 * lexicographically next greater permutation of numbers.
 *
 * If such arrangement is not possible, it must rearrange it as the lowest
 * possible order (ie, sorted in ascending order).
 *
 * The replacement must be in-place and use only constant extra memory.
 *
 * Here are some examples. Inputs are in the left-hand column and its
 * corresponding outputs are in the right-hand column.
 *
 * 1,2,3 → 1,3,2 3,2,1 → 1,2,3 1,1,5 → 1,5,1
 *
 * @author zhentao.li
 *
 */
public class LeetCode0031 {
    public static void main(String[] args) {
        int[] nums = {1,3,2};
        new LeetCode0031().nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0) {
            if (nums[i+1] <= nums[i]) {
                i--;
            } else {
                break;
            }
        }

        if (i >=0) {
            int j = nums.length-1;
            while(j > 0) {
                if (nums[i] < nums[j]) {
                    swap(nums, i, j);
                    break;
                } else {
                    j--;
                }
            }
        }
        reverse(nums, i+1, nums.length-1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int start, int end) {
        while(start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
}
