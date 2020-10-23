package com.zhentao.review.facebook;

/**
 * <b>88. Merge Sorted Array</b> Given two sorted integer arrays nums1 and
 * nums2, merge nums2 into nums1 as one sorted array.
 *
 * <pre>
Note:

    The number of elements initialized in nums1 and nums2 are m and n respectively.
    You may assume that nums1 has enough space (size that is equal to m + n) to hold additional elements from nums2.

Example:

Input:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

Output: [1,2,2,3,5,6]
 * </pre>
 *
 * @author zhentao.li
 *
 */
public class LeetCode0088 {
    public static void main(String[] args) {
        LeetCode0088 lc = new LeetCode0088();
        int[] nums1 = new int[] {0};
        lc.merge(nums1, 0, new int[] {1}, 1);
        System.out.println();
    }
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int lastIndex = m+n -1;
        m--;
        n--;
        while(m >=0 && n>=0) {
            if (nums1[m] > nums2[n]) {
                nums1[lastIndex] = nums1[m];
                m--;
            } else {
                nums1[lastIndex] = nums2[n];
                n--;
            }
            lastIndex--;
        }
        for (int i = 0; i <= n; i++) {
            nums1[i] = nums2[i];
        }
    }





    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = nums1.length - 1;
        while(i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }

        for (int l = 0; l <= j; l++) {
            nums1[l] = nums2[l];
        }
    }
}
