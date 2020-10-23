package com.zhentao.review.facebook;

/**
 * <b>42. Trapping Rain Water</b> Given n non-negative integers representing an
 * elevation map where the width of each bar is 1, compute how much water it is
 * able to trap after raining.
 *
 *
 * The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In
 * this case, 6 units of rain water (blue section) are being trapped. Thanks
 * Marcos for contributing this image!
 *
 * <pre>
Example:

Input: [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
 * </pre>
 *
 * @author zhentao.li
 *
 */
public class LeetCode0042 {
    public int trap(int[] height) {
        int result = 0;
        int maxLeft = Integer.MIN_VALUE;
        int maxRight = Integer.MIN_VALUE;

        int left = 0;
        int right = height.length-1;

        while(left <= right) {
            maxLeft = Math.max(maxLeft, height[left]);
            maxRight = Math.max(maxRight, height[right]);

            if (maxLeft < maxRight) {
                result += maxLeft - height[left];
                left++;
            } else {
                result += maxRight - height[right];
                right--;
            }
        }

        return result;
    }
}
