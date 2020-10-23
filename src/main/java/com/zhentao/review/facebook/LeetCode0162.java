package com.zhentao.review.facebook;

/**
 * <b>162. Find Peak Element</b>
 *
 * A peak element is an element that is greater than its neighbors.
 *
 * Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and
 * return its index.
 *
 * The array may contain multiple peaks, in that case return the index to any
 * one of the peaks is fine.
 *
 * You may imagine that nums[-1] = nums[n] = -∞.
 *
 * <pre>
Example 1:

Input: nums = [1,2,3,1]
Output: 2
Explanation: 3 is a peak element and your function should return the index number 2.

Example 2:

Input: nums = [1,2,1,3,5,6,4]
Output: 1 or 5
Explanation: Your function can return either index number 1 where the peak element is 2,
             or index number 5 where the peak element is 6.
 * </pre>
 *
 * Follow up: Your solution should be in logarithmic complexity.
 *
 * @author zhentao.li
 *
 */
public class LeetCode0162 {
    public static void main(String[] args) {
        int[] nums = {1,2,1,3,5,6,4};
        LeetCode0162 lc = new LeetCode0162();
        System.out.println(lc.findPeakElement(nums));
        System.out.println(lc.findValleyElement(nums));
    }
    public int findPeakElement(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (mid == nums.length - 1 || nums[mid] > nums[mid + 1])
                r = mid-1;
            else
                l = mid + 1;
        }
        return l;
    }

    public int findValleyElement(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        while (left <= right) {
            int mid = left + (right-left)/2;
            if (mid == nums.length || nums[mid] < nums[mid+1]) {
                right = mid-1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
