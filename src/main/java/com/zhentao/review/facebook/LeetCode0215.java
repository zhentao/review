package com.zhentao.review.facebook;

import java.util.concurrent.ThreadLocalRandom;

/**
 * <b>215. Kth Largest Element in an Array</b>
 *
 * <pre>
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order,
 * not the kth distinct element.

Example 1:
Input: [3,2,1,5,6,4] and k = 2
Output: 5

Example 2:
Input: [3,2,3,1,2,4,5,5,6] and k = 4
Output: 4
Note:
You may assume k is always valid, 1 ≤ k ≤ array's length.
 * </pre>
 */
public class LeetCode0215 {
    public static void main(String[] args) {
        int[] nums = { 3, 2, 1, 5, 6, 4 };
        LeetCode0215 lc = new LeetCode0215();
        System.out.println(lc.findKthLargest(nums, 2));
    }

    public int findKthLargest2(final int[] nums, final int k) {
        int left = 0;
        int right = nums.length-1;
        while(true) {
            int pivot = partition2(nums, left, right);
            if (pivot > k-1) {
                right = k - 1;
            } else if (pivot < k-1){
                left = k + 1;
            } else {
                return nums[pivot];
            }
        }
    }

    private int partition2(int[] nums, int left, int right) {
        int pivot = nums[left];
        int l = left + 1;
        while (l <= right) {
            if (nums[l] < pivot && nums[right] > pivot) {
                swap(nums, l, right);
                l++;
                right--;
            }
            if (nums[l] >= pivot) {
                l++;
            }
            if (nums[right] <= pivot) {
                right--;
            }
        }
        swap(nums, left, right);
        return right;
    }

    private void shuffle1(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int rand = ThreadLocalRandom.current().nextInt(i+1);
            swap(array, rand, i);
        }
    }



    /**
     * 核心思想是每次都要先找一个中枢点 Pivot，然后遍历其他所有的数字，像这道题从大往小排的话，
     * 就把大于中枢点的数字放到左半边，把小于中枢点的放在右半边，这样中枢点是整个数组中第几大的数字就确定了，
     * 虽然左右两部分各自不一定是完全有序的，但是并不影响本题要求的结果，因为左半部分的所有值都大于右半部分的任意值， 所以我们求出中枢点的位置，如果正好是
     * k-1，那么直接返回该位置上的数字；如果大于 k-1，说明要求的数字在左半部分， 更新右边界，再求新的中枢点位置；反之则更新右半部分，求中枢点的位置
     *
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(final int[] nums, final int k) {
        int left = 0;
        int right = nums.length - 1;
        while (true) {
            int pivotIndex = partition(nums, left, right);
            if (pivotIndex == k - 1) {
                return nums[pivotIndex];
            } else if (pivotIndex > k - 1) {
                right = pivotIndex - 1;
            } else {
                left = pivotIndex + 1;
            }
        }
    }

    /**
     * partition the array so that the left is greater than the pivot and right is
     * less than it
     *
     * @param nums
     * @param left
     * @param right
     * @return
     */
    private int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        int l = left + 1;
        while (l <= right) {
            // swap
            if (nums[l] < pivot && nums[right] > pivot) {
                swap(nums, l, right);
                l++;
                right--;
            }
            // if nums[l] is greater than or equal to pivot, leave it as is by incrementing
            // l
            if (nums[l] >= pivot) {
                l++;
            }
            // if nums[right] is less than or equal to pivot, leave it as is by incrementing
            // right.
            if (nums[right] <= pivot) {
                right--;
            }
        }
        // right is the element great than or equal to pivot, swap it with pivot.
        swap(nums, left, right);
        return right;
    }

    private void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }
}
