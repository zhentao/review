package com.zhentao.review.facebook;

import java.util.Arrays;

public class LeetCode0015 {
    /**
     * Similar to LeetCode 15, but only return true or false if the sum of 3 numbers is 0
     * @param nums
     * @return
     */
    boolean find(int[] nums) {
        Arrays.sort(nums);
        // n1 + n2 + n3 = 0
        // n1 + n2 = -n3
        int target = -nums[0];
        for (int i = 1; i < nums.length; i++) {
            int m = i;
            int n = nums.length - 1;

            while (m < n) {
                if (nums[m] + nums[n] == target) {
                    return true;
                }
                if (nums[m] + nums[n] > target) {
                    n--;
                } else {
                    m++;
                }
                target = -nums[i];
            }
        }

        return false;
    }
}
