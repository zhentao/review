package com.zhentao.review.google;

/**
 * <b>162. Find Peak Element</b>
 * 
 * <pre>
 * A peak element is an element that is greater than its neighbors.

Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that nums[-1] = nums[n] = -∞.

Example 1:

Input: nums = [1,2,3,1]
Output: 2
Explanation: 3 is a peak element and your function should return the index number 2.
Example 2:

Input: nums = [1,2,1,3,5,6,4]
Output: 1 or 5 
Explanation: Your function can return either index number 1 where the peak element is 2, 
             or index number 5 where the peak element is 6.
Note:

Your solution should be in logarithmic complexity.
 * </pre>
 * 
 * @author zhentao
 *
 */
public class PeakElement {
    public int find(int[] nums) {
        int length = nums.length - 1;
        if (length == 0) {
            return 0;
        }
        return find(nums, 0, length, length);
    }
    /**
     * from leetcode solution
     * @param nums
     * @param l
     * @param r
     * @return
     */
//    private int search(int[] nums, int l, int r) {
//        if (l == r)
//            return l;
//        int mid = l + (r-l)/2;
//        if (nums[mid] > nums[mid + 1])
//            return search(nums, l, mid);
//        return search(nums, mid + 1, r);
//    } 
    
    private int find(int[] input, int start, int end, int length) {
        int mid = start + (end - start) / 2;
        if (mid == 0) {
            if (input[0] > input[1]) {
                return 0;
            } else {
                return 1;
            }
        }
        if (mid == length) {
            return mid;
        }
        if (input[mid] > input[mid - 1] && input[mid] > input[mid + 1]) {
            return mid;
        } else if (input[mid] > input[mid - 1]) {
            return find(input, mid + 1, end, length);
        } else {
            return find(input, start, mid - 1, length);
        }
    }
}
