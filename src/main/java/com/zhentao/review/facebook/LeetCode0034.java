package com.zhentao.review.facebook;

import java.util.Arrays;

/**
 * <b>34. Find First and Last Position of Element in Sorted Array</b> Given an
 * array of integers nums sorted in ascending order, find the starting and
 * ending position of a given target value.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * If the target is not found in the array, return [-1, -1].
 *
 * <pre>
Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]

Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]

Constraints:

    0 <= nums.length <= 10^5
    -10^9 <= nums[i] <= 10^9
    nums is a non decreasing array.
    -10^9 <= target <= 10^9
 * </pre>
 *
 * @author zhentao.li
 *
 */
public class LeetCode0034 {
    public static void main(String[] args) {
        LeetCode0034 lc = new LeetCode0034();
        int[] nums = {5,7,7,7,8,8,10};

        System.out.println(Arrays.toString(lc.searchRange(nums, 8)));
    }
    public int[] searchRange(int[] nums, int target) {
        int[] results = {-1, -1};

        binarySearch(nums, target, results, 0);
        //early return
        if (results[0] == -1) {
            return results;
        }

        binarySearch(nums, target, results, 1);
        return results;
    }
    private void binarySearch(int[] nums, int target, int[] results, int index) {
        int left = 0;
        int right = nums.length-1;
        while(left <= right) {
            int mid = left + (right -left) / 2;
            if (nums[mid] > target) {
                right = mid-1;
            } else if (nums[mid] < target) {
                left = mid+1;
            } else {
                results[index] = mid;
//                if (left == right) {
//                    break;
//                }
                if (index == 1) {
                    left = mid+1;
                } else {
                    right = mid-1;
                }
            }
        }
    }
}
