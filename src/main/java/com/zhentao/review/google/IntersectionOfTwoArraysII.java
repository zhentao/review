package com.zhentao.review.google;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * <b>350. Intersection of Two Arrays II</b>
 * 
 * <pre>
 * Given two arrays, write a function to compute their intersection.

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [4,9]
Note:

Each element in the result should appear as many times as it shows in both arrays.
The result can be in any order.
Follow up:

What if the given array is already sorted? How would you optimize your algorithm?
What if nums1's size is small compared to nums2's size? Which algorithm is better?
What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
 * </pre>
 * 
 * @author zhentao
 *
 */
public class IntersectionOfTwoArraysII {
    public int[] intersect(final int[] nums1, final int[] nums2) {
        final HashMap<Integer, Integer> map = new HashMap<>();
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[0];
        }
        
        for (final int i : nums1) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        final ArrayList<Integer> list = new ArrayList<>();
        for (final int i : nums2) {
            if (map.containsKey(i) && map.get(i) != 0) {
                list.add(i);
                map.put(i, map.get(i)-1);
            }
        }
        return list.parallelStream().mapToInt(i->i).toArray();
    }
}
