package com.zhentao.review.google;

/**
 * <b>287. Find the Duplicate Number</b>
 * 
 * <pre>
 * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), 
 * prove that at least one duplicate number must exist. Assume that there is only one duplicate 
 * number, find the duplicate one.

Example 1:

Input: [1,3,4,2,2]
Output: 2
Example 2:

Input: [3,1,3,4,2]
Output: 3
Note:

You must not modify the array (assume the array is read only).
You must use only constant, O(1) extra space.
Your runtime complexity should be less than O(n2).
There is only one duplicate number in the array, but it could be repeated more than once.
 * </pre>
 * 
 * @author zhentao
 *
 */
public class FindDuplicateNumber {
    public static void main(final String[] args) {
        final int[] nums = {1, 2, 4,3,2};
        System.out.println(findDuplicate(nums));
    }
    public static int findDuplicate(final int[] nums) {
        int start = 0;
        int end = nums.length;
        while(start <= end-1) {
            final int n = start + (end - start)/2;
            int count = 0;
            for (final int i : nums) {
                if (i <= n) {
                    count++;
                }
            }
            if (count > n) {
                end = n;
            } else {
                start = n+1;
            }
        }
        return end;
    }
}
