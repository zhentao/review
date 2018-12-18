package com.zhentao.review.dp;

/**
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which
 * has the largest sum and return its sum.
 *
 * <pre>
 * Example:
 *
 * Input: [-2,1,-3,4,-1,2,1,-5,4], Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * </pre>
 *
 * @author zhentao.li
 *
 */
public class MaxSubArray {
    public static void main(String[] args) {
        int[] array = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(max(array));
        array = new int[]{-2};
        System.out.println(max(array));
    }
    public static int max(int[] array) {
        int maxAll = Integer.MIN_VALUE;
        int maxNow = 0;
        for (int v : array) {
            maxNow = Math.max(maxNow + v, v);
            maxAll = Math.max(maxNow, maxAll);
        }
        return maxAll;
    }
}
