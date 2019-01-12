package com.zhentao.review.google;

import java.util.Arrays;

/**
 * <b>324. Wiggle Sort II</b>
 * 
 * <pre>
 * Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....

Example 1:

Input: nums = [1, 5, 1, 1, 6, 4]
Output: One possible answer is [1, 4, 1, 5, 1, 6].
Example 2:

Input: nums = [1, 3, 2, 2, 3, 1]
Output: One possible answer is [2, 3, 1, 3, 1, 2].
Note:
You may assume all input has valid answer.

Follow Up:
Can you do it in O(n) time and/or in-place with O(1) extra space?
 * </pre>
 * 
 * @author zhentao
 *
 */
public class WiggleSortII {
    public static void main(String[] args) {
        
        System.out.println(3|1);
        WiggleSortII wiggle = new WiggleSortII();

        int[] nums = { 1, 1, 2, 2, 2, 2, 3, 3 };
        wiggle.wiggleSort(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int[] { 1, 5, 1, 1, 6, 4 };
        wiggle.wiggleSort(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int[] { 1, 3, 2, 2, 3, 1 };
        wiggle.wiggleSort(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int[] { 4, 6, 4, 4, 6, 6 };
        wiggle.wiggleSort(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int[] { 4, 5, 5, 6 };
        wiggle.wiggleSort(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int[] { 4, 5, 5, 5, 5, 6, 6, 6 };
        wiggle.wiggleSort(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int[] { 1, 2, 3, 4, 5 };
        wiggle.wiggleSort(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int[] { 1, 2, 3 };
        wiggle.wiggleSort(nums);
        System.out.println(Arrays.toString(nums));
        
        nums = new int[] { 1, 2, 2, 2, 3, 3 };
        wiggle.wiggleSort(nums);
        System.out.println(Arrays.toString(nums));

    }

    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        int mid = (length - 1) / 2;

        int[] temp = new int[length];

        for (int i = 0; i < length; i += 2) {
            temp[i] = nums[i / 2];
        }
        int shift = -1;
        for (int i = 1; i < length; i += 2) {
            temp[i] = nums[mid + 1 + i / 2];
            if (i != length-1 && temp[i + 1] == temp[i]) {
                shift = i;
            }
        }

        if (shift != -1) {
            for (int i = 0; i <= shift; i++) {
                nums[length-1 - shift + i] = temp[i];
            }
            for (int i = 0; i < length-1-shift; i++) {
                nums[i] = temp[shift+i+1];
            }
        } else {
            for (int i = 0; i < length; i++) {
                nums[i] = temp[i];
            }
        }
    }
}
