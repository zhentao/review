package com.zhentao.review.google;

/**
 * <b>153. Find Minimum in Rotated Sorted </b>
 * 
 * <pre>
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

Find the minimum element.

You may assume no duplicate exists in the array.

Example 1:

Input: [3,4,5,1,2] 
Output: 1

Example 2:

Input: [4,5,6,7,0,1,2]
Output: 0
 * </pre>
 * 
 * @author zhentao
 *
 */
public class MinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        return findMin(nums, 0, nums.length - 1);
    }

    private int findMin(int[] nums, int start, int end) {
        if (start == end) {
            return nums[start];
        }
        int mid = start + (end - start) / 2;
        if (nums[mid] > nums[end]) {
            return findMin(nums, mid + 1, end);
        } else {
            return findMin(nums, start, mid);
        }
    }
}
