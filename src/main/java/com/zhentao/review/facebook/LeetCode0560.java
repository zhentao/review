package com.zhentao.review.facebook;

import java.util.HashMap;
import java.util.Map;

/**
 * <b>560. Subarray Sum Equals K</b> Given an array of integers and an integer
 * k, you need to find the total number of continuous subarrays whose sum equals
 * to k.
 *
 * <pre>
Example 1:

Input:nums = [1,1,1], k = 2
Output: 2

Constraints:

    The length of the array is in range [1, 20,000].
    The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].
 * </pre>
 *
 * @author zhentao.li
 *
 */
public class LeetCode0560 {
    public static void main(String[] args) {
        LeetCode0560 lc = new LeetCode0560();
        int total = lc.subarraySumMap(new int[] {1,1,1} , 1);
        System.out.println(total);
    }
    public int subarraySum(int[] nums, int k) {
        int[] prefixSum = new int[nums.length + 1];
        prefixSum[0] = 0;

        for (int i = 1; i < prefixSum.length; i++) {
            prefixSum[i] += prefixSum[i - 1] + nums[i - 1];
        }
        int count = 0;
        for (int i = 0; i < prefixSum.length-1; i++) {
            for (int j = i + 1; j < prefixSum.length; j++) {
                if (prefixSum[j] - prefixSum[i] == k) {
                    count++;
                }
            }
        }
        return count;
    }

    public int subarraySumMap(int[] nums, int k) {
        int prefixSum = 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        for (int num : nums) {
            prefixSum += num;
            count += map.getOrDefault(prefixSum - k, 0);
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }

}
