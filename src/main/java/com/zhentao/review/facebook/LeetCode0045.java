package com.zhentao.review.facebook;

/**
 * <b>45. Jump Game II</b> Given an array of non-negative integers, you are
 * initially positioned at the first index of the array.
 *
 * Each element in the array represents your maximum jump length at that
 * position.
 *
 * Your goal is to reach the last index in the minimum number of jumps.
 *
 * <pre>
Example:

Input: [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2.
    Jump 1 step from index 0 to 1, then 3 steps to the last index.

Note:

You can assume that you can always reach the last index.
 * </pre>
 *
 * @author zhentao.li
 *
 */
public class LeetCode0045 {
    public static void main(String[] args) {
        LeetCode0045 lc = new LeetCode0045();
        System.out.println(lc.jump(new int[] { 2,3,1,1,4 }));
    }

    /**
     * Use "last" to keep track of the maximum distance that has been reached by
     * using the minimum steps "count", whereas "curr" is the maximum distance that
     * can be reached by using "count+1" steps. Thus, curr = max(curr, i+A[i]) where
     * 0 <= i <= last.
     *
     * See https://www.cnblogs.com/lichen782/p/leetcode_Jump_Game_II.html
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        int count = 0;
        int curr = 0;
        int last = curr;

        for (int i = 0; i < nums.length; i++) {

            if (i > last) {
                last = curr;
                ++count;
            }
            curr = Math.max(curr, nums[i] + i);
        }
        return count;
    }
}
