package com.zhentao.review.facebook;

import java.util.HashMap;
import java.util.Map;

/**
 * <b>523. Continuous Subarray Sum</b> Given a list of non-negative numbers and
 * a target integer k, write a function to check if the array has a continuous
 * subarray of size at least 2 that sums up to a multiple of k, that is, sums up
 * to n*k where n is also an integer.
 *
 * <pre>
Example 1:

Input: [23, 2, 4, 6, 7],  k=6
Output: True
Explanation: Because [2, 4] is a continuous subarray of size 2 and sums up to 6.

Example 2:

Input: [23, 2, 6, 4, 7],  k=6
Output: True
Explanation: Because [23, 2, 6, 4, 7] is an continuous subarray of size 5 and sums up to 42.

Constraints:

    The length of the array won't exceed 10,000.
    You may assume the sum of all the numbers is in the range of a signed 32-bit integer.
 * </pre>
 *
 * @author zhentao.li
 *
 */
public class LeetCode0523 {
    public static void main(String[] args) {
        LeetCode0523 lc = new LeetCode0523();
        //System.out.println(lc.checkSubarraySum(new int[] { 23, 2, 6, 4, 7 }, 6));
        System.out.println(lc.checkSubarraySum(new int[] { 23, -6, 6, 4 }, 0));
        System.out.println(lc.checkSubarraySum(new int[] { 1, 2 }, 3));
    }

    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        // corner case: if the very first subarray with first two numbers in array could form the result,
        //we need to put mod value 0 and index -1 to make it as a true case
        map.put(0, -1);
        int runningSum = 0;
        for (int i = 0; i < nums.length; i++) {
            runningSum += nums[i];
            if (k != 0) {
                runningSum %= k;
            }
            Integer prev = map.get(runningSum);
            if (prev != null) {
                if (i - prev > 1) {
                    return true;
                }
            } else {
                map.put(runningSum, i);
            }
        }
        return false;
    }
}
